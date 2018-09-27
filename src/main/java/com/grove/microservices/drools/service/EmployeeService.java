package com.grove.microservices.drools.service;

import java.util.Collection;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grove.microservices.drools.dao.EmployeeDao;
import com.grove.microservices.drools.model.Employee;



@Service
public class EmployeeService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private KieContainer kieContainer;
	
	@Autowired
	private EmployeeDao employeeDao;

	public void storeEmployee(Employee employee) {
		
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.insert(employee); // which object to validate
		int fired = kieSession.fireAllRules(); // fire all rules defined into drool file (drl)

        System.out.println( "Number of Rules executed = " + fired );
        System.out.println( "Employee: " + employee);
        printFactsMessage(kieSession);
		
		kieSession.dispose();
		logger.info("Inside Service method: " + employee);

		// save employee object to database
		employeeDao.saveEmployee(employee);
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
