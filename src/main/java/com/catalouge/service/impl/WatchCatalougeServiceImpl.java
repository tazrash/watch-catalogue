package com.catalouge.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.SortedMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalouge.entity.WatchCatalouge;
import com.catalouge.model.request.CheckOutApiResponse;
import com.catalouge.repository.WatchCatalougeRepository;
import com.catalouge.service.WatchCatalougeService;

@Service
public class WatchCatalougeServiceImpl implements WatchCatalougeService{

	@Autowired
	private WatchCatalougeRepository watchCatalougeRepository;

	@Autowired
	public WatchCatalougeServiceImpl(WatchCatalougeRepository watchCatalougeRepository) {
		this.watchCatalougeRepository = watchCatalougeRepository;
	}


	@Override
	public CheckOutApiResponse checkout(List<String> catalogs) throws Exception {
		CheckOutApiResponse response = new CheckOutApiResponse();
		HashMap<String, Integer> catalogMap =  countService(catalogs);
		double finalPrice = 0 ;

		for(HashMap.Entry<String, Integer> cat : catalogMap.entrySet()) {
			Optional<WatchCatalouge> watchEntity = watchCatalougeRepository.findById(cat.getKey());
			if(watchEntity.isPresent()) {
				WatchCatalouge watch = watchEntity.get();
				if(watch.isDiscountEligible()) {
					double discountedCount =  (cat.getValue()/watch.getDiscountCount());
					double nonDiscountedCount =  (cat.getValue() % watch.getDiscountCount());
					finalPrice =  (finalPrice+(discountedCount*watch.getDiscountPrice())+(nonDiscountedCount*watch.getSingleUnitPrice()));
				}else{
					finalPrice =  (finalPrice+(watch.getSingleUnitPrice()*cat.getValue()));
				}
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
