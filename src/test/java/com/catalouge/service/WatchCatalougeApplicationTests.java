package com.catalouge.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.catalouge.entity.WatchCatalouge;
import com.catalouge.model.request.CheckOutApiResponse;
import com.catalouge.repository.WatchCatalougeRepository;
import com.catalouge.service.impl.WatchCatalougeServiceImpl;

@SpringBootTest
class WatchCatalougeApplicationTests {



	@Mock
	private WatchCatalougeRepository watchCatalougeRepository;



	@MockBean
	private WatchCatalougeService watchCatalougeService;






	@Test
	public void testFindTheGreatestFromAllData() throws Exception {
		List<String> lst =  new ArrayList<String>();
		lst.add("001");
		lst.add("001");
		lst.add("001");
		lst.add("002");
		lst.add("003");

		Optional<WatchCatalouge> watchCatalouge = Optional.ofNullable(new WatchCatalouge("001", "RoleX", true, 100, 200, 3));
		when(watchCatalougeRepository.findById("001")).thenReturn(watchCatalouge);


		Optional<WatchCatalouge> watchCatalouge2 = Optional.ofNullable(new WatchCatalouge("002", "Micheal Kors", true, 80, 120, 2));
		when(watchCatalougeRepository.findById("002")).thenReturn(watchCatalouge2);

		Optional<WatchCatalouge> watchCatalouge3 = Optional.ofNullable(new WatchCatalouge("003", "Swatch", false, 50, 0, 0));
		when(watchCatalougeRepository.findById("003")).thenReturn(watchCatalouge3);

		Optional<WatchCatalouge> watchCatalouge4 = Optional.ofNullable(new WatchCatalouge("004", "Casio", false, 30, 0, 0));
		when(watchCatalougeRepository.findById("004")).thenReturn(watchCatalouge4);


		WatchCatalougeService businessImpl = new WatchCatalougeServiceImpl(watchCatalougeRepository);

		CheckOutApiResponse result = businessImpl.checkout(lst);

		
		assertNotNull(result);
		
		assertEquals(result.getPrice(), 330.0);
	}



}
