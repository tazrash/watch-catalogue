package com.catalouge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.catalouge.model.request.CheckOutApiResponse;
import com.catalouge.service.WatchCatalougeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class WatchCatalougeController {
	@Autowired
	private WatchCatalougeService watchCatalougeService;

	private static final Logger LOGGER=LoggerFactory.getLogger(WatchCatalougeController.class);
	/*Service to do the checkout of items selected by the customer*/
	@PostMapping("/checkout")
	public ResponseEntity<?> checkout(@RequestBody List<String> watchIdList) throws Exception{
		LOGGER.info("Inside Checkout Method");
		if(watchIdList.size()==0) {
			LOGGER.error("Empty list");
			return new ResponseEntity<>("Please insert some items in the cart", HttpStatus.BAD_REQUEST);
		}
		CheckOutApiResponse response = null;
		try {
		   response = watchCatalougeService.checkout(watchIdList);
		   LOGGER.info("Successful fetching the total balance");
		}catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR); 	
		}
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
