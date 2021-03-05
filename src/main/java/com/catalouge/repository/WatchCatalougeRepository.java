package com.catalouge.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.catalouge.entity.WatchCatalouge;

@Repository
public interface WatchCatalougeRepository extends CrudRepository<WatchCatalouge, String>{
	
	

}
