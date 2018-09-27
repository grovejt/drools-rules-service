package com.grove.microservices.drools.controller;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grove.microservices.drools.domain.sales.Item;
import com.grove.microservices.drools.service.SalesService;



@RestController
public class SalesController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private final SalesService salesService;
	
	
	public SalesController(SalesService salesService) {
		this.salesService = salesService;
	}


	@GetMapping(name="/sales/categorizeItem", produces="application/json")
	public Item categorizeItem(
			@RequestParam(required=true) String name,
			@RequestParam(required=true) BigDecimal cost,
			@RequestParam(required=true) BigDecimal salePrice) {
		
		Item item = new Item(name, cost, salePrice);  
		Item categorizedItem = salesService.categorizeItem(item);
		return categorizedItem;
	} 
}
