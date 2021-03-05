package com.catalouge.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.catalouge.entity.WatchCatalouge;
import com.catalouge.repository.WatchCatalougeRepository;


@Component
public class ConfigWatchCatalougeService {



	@Autowired
	private WatchCatalougeRepository watchCatalougeRepository;


	@PostConstruct
	public void insertData() {


		WatchCatalouge watchCatalouge = new WatchCatalouge("001", "RoleX", true, 100, 200, 3);
		watchCatalougeRepository.save(watchCatalouge);


		watchCatalouge = new WatchCatalouge("002", "Micheal Kors", true, 80, 120, 2);
		watchCatalougeRepository.save(watchCatalouge);


		watchCatalouge = new WatchCatalouge("003", "Swatch", false, 50, 0, 0);
		watchCatalougeRepository.save(watchCatalouge);


		watchCatalouge = new WatchCatalouge("004", "Casio", false, 30, 0, 0);
		watchCatalougeRepository.save(watchCatalouge);



	}

}
