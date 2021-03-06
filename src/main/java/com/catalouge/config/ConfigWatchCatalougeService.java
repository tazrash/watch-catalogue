package com.catalouge.config;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.catalouge.entity.WatchCatalouge;
import com.catalouge.repository.WatchCatalougeRepository;


@Component
public class ConfigWatchCatalougeService {

	private static final Logger LOGGER=LoggerFactory.getLogger(ConfigWatchCatalougeService.class);

	@Autowired
	private WatchCatalougeRepository watchCatalougeRepository;


	@PostConstruct
	public void insertData() {

		LOGGER.info("Entering insert data post construct method");
		WatchCatalouge watchCatalouge = new WatchCatalouge("001", "RoleX", true, 100, 200, 3);
		watchCatalougeRepository.save(watchCatalouge);


		watchCatalouge = new WatchCatalouge("002", "Micheal Kors", true, 80, 120, 2);
		watchCatalougeRepository.save(watchCatalouge);


		watchCatalouge = new WatchCatalouge("003", "Swatch", false, 50, 0, 0);
		watchCatalougeRepository.save(watchCatalouge);


		watchCatalouge = new WatchCatalouge("004", "Casio", false, 30, 0, 0);
		watchCatalougeRepository.save(watchCatalouge);
		LOGGER.info("Exiting insert data post construct method");


	}

}
