package com.zach.unittesting.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zach.unittesting.business.ItemBusinessService;
import com.zach.unittesting.model.Item;

@RestController
public class ItemController {
	
	@Autowired
	ItemBusinessService businessservice;
	
	
	@GetMapping("/dummy-item")
	public Item dummyItem() {
		return new Item(1, "Ball", 10,100);
		
	}
	
	@GetMapping("/item-from-business-service")
	public Item ItemFromService() {
		return businessservice.retreiveHardcodedItem();
		
	}
	
	@GetMapping("/all-items-from-database")
	public List<Item> retrieveAllItems() {
		return businessservice.retrieveAllItems();
	}

}
