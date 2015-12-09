package com.example.library;


import static org.fest.assertions.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.Test;

public class SimpleBookPenaltyCalculatorTest {

	@Test
	public void testPenaltySameDayCheckout() {
		LocalDate todaysDate = LocalDate.of(2014, 12, 19);
		LocalDate checkoutDate = LocalDate.of(2014, 12, 19);
		BookPenaltyCalculator bpc = 
				new SimpleBookPenaltyCalculator(10, 1); 
		assertThat(
		  bpc.calculate
		  (todaysDate, checkoutDate)).isEqualTo(0);
	}
}
