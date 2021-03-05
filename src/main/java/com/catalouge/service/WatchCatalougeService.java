package com.catalouge.service;

import java.util.List;

import com.catalouge.model.request.CheckOutApiResponse;

public interface WatchCatalougeService {
	
	
	public CheckOutApiResponse checkout(List<String> catelouge) throws Exception;

}
