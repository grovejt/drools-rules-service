package com.grove.microservices.drools.service;

import java.util.Collection;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grove.microservices.drools.domain.sales.Item;

@Service
public class SalesService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private final KieContainer kieContainer;
	
	@Autowired
	public SalesService(KieContainer kieContainer) {
		logger.info("Initializing a new sales session");
		this.kieContainer = kieContainer;
	}
	
	/**
     */
	public Item categorizeItem(Item item) {
		//KieSession kieSession = kieContainer.newKieSession("salesSession");
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.insert(item);
		int fired = kieSession.fireAllRules();
		
        System.out.println( "Number of Rules executed = " + fired );
        System.out.println( "Item Category: " + item.getCategory());
        printFactsMessage(kieSession);
		
        kieSession.dispose();
		return item;
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
