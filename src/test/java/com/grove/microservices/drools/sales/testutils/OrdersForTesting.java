package com.grove.microservices.drools.sales.testutils;

import java.math.BigDecimal;

import com.grove.microservices.drools.domain.sales.Customer;
import com.grove.microservices.drools.domain.sales.Order;
import com.grove.microservices.drools.domain.sales.OrderState;

public class OrdersForTesting {

	  public static Order getOrderWithFiveHighRangeItems() {
	        
	        return new OrderBuilder(new Customer())
	            .newLine()
	                .withItem()
	                    .withName("A")
	                    .withCost(new BigDecimal("700.0"))
	                    .withSalePrice(new BigDecimal("800.0"))
	                .end()
	                .withQuantity(1)
	                .end()
	            .end()
	            .newLine()
	                .withItem()
	                    .withName("B")
	                    .withCost(new BigDecimal("800.0"))
	                    .withSalePrice(new BigDecimal("850.0"))
	                .end()
	                .withQuantity(2)
	                .end()
	            .end()
	            .newLine()
	                .withItem()
	                    .withName("C")
	                    .withCost(new BigDecimal("800.0"))
	                    .withSalePrice(new BigDecimal("850.0"))
	                .end()
	                .withQuantity(3)
	                .end()
	            .end()
	            .newLine()
	                .withItem()
	                    .withName("D")
	                    .withCost(new BigDecimal("800.0"))
	                    .withSalePrice(new BigDecimal("850.0"))
	                .end()
	                .withQuantity(4)
	                .end()
	            .end()    
	            .newLine()
	                .withItem()
	                    .withName("E")
	                    .withCost(new BigDecimal("800.0"))
	                    .withSalePrice(new BigDecimal("850.0"))
	                .end()
	                .withQuantity(5)
	                .end()
	            .end()
	        .build();
	    }
	    
	    public static Order getPendingOrderWithTotalValueGreaterThan10000(Customer customer){
	        return new OrderBuilder(customer)
	            .withSate(OrderState.PENDING)
	            .newLine()
	                .withItem()
	                    .withSalePrice(new BigDecimal("5000.0"))
	                .end()
	                .withQuantity(2)
	            .end()
	            .newLine()
	                .withItem()
	                    .withSalePrice(new BigDecimal("800.0"))
	                .end()
	                .withQuantity(5)
	            .end()
	        .build();
	    }
	    
	    public static Order getPendingOrderWithTotalValueLessThan10000(Customer customer){
	        return new OrderBuilder(customer)
	            .withSate(OrderState.PENDING)
	            .newLine()
	                .withItem()
	                    .withSalePrice(new BigDecimal("1000.0"))
	                .end()
	                .withQuantity(1)
	            .end()
	        .build();
	    }
}
