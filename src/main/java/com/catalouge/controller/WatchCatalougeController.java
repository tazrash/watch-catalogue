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

@RestController
public class WatchCatalougeController {
	@Autowired
	private WatchCatalougeService watchCatalougeService;

	@PostMapping("/checkout")
	public ResponseEntity<?> checkout(@RequestBody List<String> watchIdList) throws Exception{
		CheckOutApiResponse response = watchCatalougeService.checkout(watchIdList);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
