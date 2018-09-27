package com.grove.microservices.drools.sales;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.util.Collection;

import org.junit.Test;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

import com.grove.microservices.drools.domain.sales.Item;
import com.grove.microservices.drools.domain.sales.Item.Category;
import com.grove.microservices.drools.sales.testutils.ItemBuilder;


public class ClassifyItemsTests extends AbstractDroolsTest{

	Item itemToTest;
	
	@Test
	public void testRangeClassifications() {
		
		assertNotNull("kContainer was null!", kContainer);
		
		itemToTest = itemBuilder.withName("A").withCost(new BigDecimal("199.99")).build();
		KieSession kSession = kContainer.newKieSession();
		kSession.insert(itemToTest);
        int fired = kSession.fireAllRules();
        printFactsMessage(kSession);
        //kSession.dispose();
        assertThat(1, is(fired));
        assertThat(Category.LOW_RANGE, is(itemToTest.getCategory()));
        System.out.println( "Item: " + itemToTest);
        
//        itemToTest = itemBuilder.withName("A").withCost(new BigDecimal("500.01")).build();
//        kSession = kContainer.newKieSession();
//		kSession.insert(itemToTest);
//        fired = kSession.fireAllRules();
//        printFactsMessage(kSession);
//        kSession.dispose();
//        assertThat(1, is(fired));
//        assertThat(Category.HIGH_RANGE, is(itemToTest.getCategory()));
//        System.out.println( "Item: " + itemToTest);
        
	}

    /**
     * Print out details of all facts in working memory.
     * Handy for debugging.
     */
    @SuppressWarnings("unused")
    private void printFactsMessage(KieSession kieSession) {
        Collection<FactHandle> allHandles = kieSession.getFactHandles();
        
        String msg = "\nAll facts:\n";
        for (FactHandle handle : allHandles) {
            msg += "    " + kieSession.getObject(handle) + "\n";
        }
        System.out.println(msg);
    }	
}
