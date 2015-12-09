package com.example.library;

import java.time.LocalDate;

public class SimpleBookPenaltyCalculator 
             implements BookPenaltyCalculator {

	public SimpleBookPenaltyCalculator(int penaltyPerMonth, 
			                           int gracePeriodInMonths) {
	}

	@Override
	public int calculate(LocalDate todaysDate, LocalDate checkoutDate) {
		return 0;
	}

}
