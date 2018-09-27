package com.grove.microservices.drools.sales.testutils;

import java.math.BigDecimal;

import com.grove.microservices.drools.domain.sales.Item;

public class ItemBuilder {
	
    private final OrderLineBuilder superBuilder;
    private final Item instance;

    public ItemBuilder(OrderLineBuilder superBuilder) {
        this.superBuilder = superBuilder;
        
        this.instance = new Item();
        //default values
        this.instance.setId(1L);
        this.instance.setCost(new BigDecimal("0.0"));
        this.instance.setName("");
        this.instance.setSalePrice(new BigDecimal("0.0"));
        this.instance.setCategory(Item.Category.NA);
    }
    
    public ItemBuilder withId(long id){
        this.instance.setId(id);
        return this;
    }
    
    public ItemBuilder withCost(BigDecimal cost){
        this.instance.setCost(cost);
        return this;
    }
    
    public ItemBuilder withName(String name){
        this.instance.setName(name);
        return this;
    }
    
    public ItemBuilder withSalePrice(BigDecimal salePrice){
        this.instance.setSalePrice(salePrice);
        return this;
    }
    
    public ItemBuilder withCategory(Item.Category category){
        this.instance.setCategory(category);
        return this;
    }
    
    public Item build(){
        return this.instance;
    }
    
    public OrderLineBuilder end(){
        return superBuilder;
    } 

}
