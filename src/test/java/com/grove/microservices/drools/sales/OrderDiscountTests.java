//package com.grove.microservices.drools.sales;
//
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.CoreMatchers.not;
//import static org.hamcrest.CoreMatchers.nullValue;
//import static org.junit.Assert.assertThat;
//
//import java.util.Collection;
//
//import org.junit.Test;
//import org.kie.api.runtime.KieSession;
//
//import com.grove.microservices.drools.domain.sales.Coupon;
//import com.grove.microservices.drools.domain.sales.Customer;
//import com.grove.microservices.drools.domain.sales.Item;
//import com.grove.microservices.drools.domain.sales.Order;
//import com.grove.microservices.drools.sales.testutils.OrdersForTesting;
//
//public class OrderDiscountTests extends AbstractDroolsTest{
//
//    @Test
//    public void highRangeOrderDiscountTest() {
//        
//    	KieSession kSession = kContainer.newKieSession();
//
//        Order o = OrdersForTesting.getOrderWithFiveHighRangeItems();
//        
//        kSession.insert(o.getCustomer());
//        kSession.insert(o.getOrderLines().get(0));
//        kSession.insert(o.getOrderLines().get(1));
//        kSession.insert(o.getOrderLines().get(2));
//        kSession.insert(o.getOrderLines().get(3));
//        kSession.insert(o.getOrderLines().get(4));
//        kSession.insert(o.getOrderLines().get(0).getItem());
//        kSession.insert(o.getOrderLines().get(1).getItem());
//        kSession.insert(o.getOrderLines().get(2).getItem());
//        kSession.insert(o.getOrderLines().get(3).getItem());
//        kSession.insert(o.getOrderLines().get(4).getItem());
//        kSession.insert(o);
//        
//        int fired = kSession.fireAllRules();
//
//        // We have 5 Items that are categorized -> 5 rules were fired
//        // We have 1 Customer that needs to be categorized -> 1 rule fired
//        // We have just one order with all HIGH RAnge items -> 1 rule fired
//        // One Coupon is created for the SILVER Customer -> 1 rule fired
//        assertThat(8, is(fired));
//        assertThat(o.getCustomer().getCategory(), is(Customer.Category.SILVER));
//        assertThat(o.getDiscount(), not(nullValue()));
//        assertThat(o.getDiscount().getPercentage(), is(10.0));
//        assertThat(o.getOrderLines().get(0).getItem().getCategory(), is(Item.Category.HIGH_RANGE));
//        assertThat(o.getOrderLines().get(1).getItem().getCategory(), is(Item.Category.HIGH_RANGE));
//        assertThat(o.getOrderLines().get(2).getItem().getCategory(), is(Item.Category.HIGH_RANGE));
//        assertThat(o.getOrderLines().get(3).getItem().getCategory(), is(Item.Category.HIGH_RANGE));
//        assertThat(o.getOrderLines().get(4).getItem().getCategory(), is(Item.Category.HIGH_RANGE));
//        // The Coupon Object was created by the Rule Engine so we need to get it from the KieSession
//        Collection<Coupon> coupons = getFactsFromKieSession(kSession, Coupon.class);
//        assertThat(1, is(coupons.size()));
//
//    }
//}
