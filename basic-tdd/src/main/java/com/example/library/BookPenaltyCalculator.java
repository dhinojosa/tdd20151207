package com.example.library;

import java.time.LocalDate;

public interface BookPenaltyCalculator {

	int calculate(LocalDate todaysDate, 
			      LocalDate checkoutDate);

}
