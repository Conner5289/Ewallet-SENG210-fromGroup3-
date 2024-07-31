package org.ewallet;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ExpenseCalculatorTest {
    
	// Declaring it so its visible to all test
	static ExpenseCalculator expenseCalculator;
	
    @BeforeAll
	static void setUpBeforeClass() throws Exception {
    	expenseCalculator = new ExpenseCalculator();
	}

	@Test
	@DisplayName("Testing WhenCanIBuyExactMonths()")
	final void WhenCanIBuyExactMonths() {
		
		Wage newWage = new Wage(400.0, "YouTube Streaming", new Date()); 
		WageRepository.saveWage(newWage, "admin");
		
		String username = "admin";
        double price = 100.0;

        int months = expenseCalculator.whenCanIBuy(price, username);

        assertEquals(4, months);
	}
	
	@Test
	@DisplayName("Testing WhenCanIBuyExactMonths()")
	final void updateMonthlySavings() {
		
		Wage newWage = new Wage(400.0, "YouTube Streaming", new Date()); 
		WageRepository.saveWage(newWage, "admin");
		
		String username = "admin";
        double price = 100.0;

        int months = expenseCalculator.whenCanIBuy(price, username);

        assertEquals(4, months);
	}

}
