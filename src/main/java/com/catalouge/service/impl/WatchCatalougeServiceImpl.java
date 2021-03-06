package com.catalouge.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalouge.entity.WatchCatalouge;
import com.catalouge.model.request.CheckOutApiResponse;
import com.catalouge.repository.WatchCatalougeRepository;
import com.catalouge.service.WatchCatalougeService;

@Service
public class WatchCatalougeServiceImpl implements WatchCatalougeService{
	
	private static final Logger LOGGER=LoggerFactory.getLogger(WatchCatalougeServiceImpl.class);

	@Autowired
	private WatchCatalougeRepository watchCatalougeRepository;

	@Autowired
	public WatchCatalougeServiceImpl(WatchCatalougeRepository watchCatalougeRepository) {
		this.watchCatalougeRepository = watchCatalougeRepository;
	}


	@Override
	public CheckOutApiResponse checkout(List<String> catalogs) throws Exception {
		LOGGER.info("Inside checkout method of serviceimpl");
		CheckOutApiResponse response = new CheckOutApiResponse();
		HashMap<String, Integer> catalogMap =  countService(catalogs);
		LOGGER.info("Count service successful implementation");
		double finalPrice = 0 ;

		for(HashMap.Entry<String, Integer> cat : catalogMap.entrySet()) {
			Optional<WatchCatalouge> watchEntity = watchCatalougeRepository.findById(cat.getKey());
			if(watchEntity.isPresent()) {
				WatchCatalouge watch = watchEntity.get();
				if(watch.isDiscountEligible()) {
					LOGGER.info(" discounted item = "+cat.getKey());
					double discountedCount =  (cat.getValue()/watch.getDiscountCount());
					double nonDiscountedCount =  (cat.getValue() % watch.getDiscountCount());
					finalPrice =  (finalPrice+(discountedCount*watch.getDiscountPrice())+(nonDiscountedCount*watch.getSingleUnitPrice()));
				}else{
					LOGGER.info("Non discounted item = "+cat.getKey());
					finalPrice =  (finalPrice+(watch.getSingleUnitPrice()*cat.getValue()));
				}
			}else {
				LOGGER.info("Item not present = "+cat.getKey());
				throw new Exception(cat.getKey()+" not present with us");
			}

		}	
		response.setPrice(finalPrice);
		return response;

	}
	
	/*Service to count the occurrence of each watch*/
	private static HashMap<String, Integer> countService(List<String> list){
		HashMap<String, Integer> responseMap = new HashMap<String, Integer>();
		for(int i = 0; i < list.size(); i++) {
			responseMap.put(list.get(i), responseMap.get(list.get(i))==null?1:responseMap.get(list.get(i))+1);
		}
		return responseMap;
	}
}
