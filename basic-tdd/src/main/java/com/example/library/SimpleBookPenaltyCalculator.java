package com.example.library;

import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.MONTHS;

public class SimpleBookPenaltyCalculator 
             implements BookPenaltyCalculator {

	private long penaltyPerMonth;
	private int gracePeriodInMonths;

	public SimpleBookPenaltyCalculator(int penaltyPerMonth, 
			                           int gracePeriodInMonths) {
	    if (gracePeriodInMonths < 0) throw new 
	    IllegalArgumentException(
	    		String.format
	    		("Invalid Grace Period: [%d]", 
	    				gracePeriodInMonths));
		this.penaltyPerMonth = penaltyPerMonth;
	    this.gracePeriodInMonths = gracePeriodInMonths;
	}

	@Override
	public int calculate(LocalDate todaysDate, 
			LocalDate checkoutDate) {
		
		if (checkoutDate.
				plusMonths(gracePeriodInMonths).
				isAfter(todaysDate)) return 0;
		
		int monthsLate = 0;
		while (checkoutDate.
				plusMonths(monthsLate).
				isBefore(todaysDate)) {
			monthsLate++;
		}
		
		return (int) 
		((monthsLate - gracePeriodInMonths) * penaltyPerMonth);
	}
}
