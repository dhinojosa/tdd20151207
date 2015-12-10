package com.example.library;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.fail;

import java.time.LocalDate;

import org.junit.Test;

public class SimpleBookPenaltyCalculatorTest {

	@Test
	public void testPenaltySameDayCheckout() {
		LocalDate todaysDate = LocalDate.of(2014, 12, 19);
		LocalDate checkoutDate = LocalDate.of(2014, 12, 19);
		BookPenaltyCalculator bpc = new SimpleBookPenaltyCalculator(10, 1);
		assertThat(bpc.calculate(todaysDate, checkoutDate)).isEqualTo(0);
	}

	@Test
	public void testPenaltyOneMonthCheckout() {
		LocalDate todaysDate = LocalDate.of(2015, 1, 19);
		LocalDate checkoutDate = LocalDate.of(2014, 12, 19);
		BookPenaltyCalculator bpc = new SimpleBookPenaltyCalculator(10, 1);
		assertThat(bpc.calculate(todaysDate, checkoutDate)).isEqualTo(0);
	}

	@Test
	public void testPenaltyOneMonthAndOneDayCheckout() {
		LocalDate todaysDate = LocalDate.of(2015, 1, 20);
		LocalDate checkoutDate = LocalDate.of(2014, 12, 19);
		BookPenaltyCalculator bpc = new SimpleBookPenaltyCalculator(10, 1);
		assertThat(bpc.calculate(todaysDate, checkoutDate)).isEqualTo(10);
	}

	@Test
	public void testOneMonthFromFebuary() {
		LocalDate todaysDate = LocalDate.of(2015, 3, 1);
		LocalDate checkoutDate = LocalDate.of(2015, 1, 31);
		BookPenaltyCalculator bpc = new SimpleBookPenaltyCalculator(10, 1);
		assertThat(bpc.calculate(todaysDate, checkoutDate)).isEqualTo(10);
	}

	@Test
	public void testTwoMonthsAndWithGracePeriodOfTwoMonths() {
		LocalDate checkoutDate = LocalDate.of(2015, 3, 1);
		LocalDate todaysDate = LocalDate.of(2015, 5, 1);
		BookPenaltyCalculator bpc = new SimpleBookPenaltyCalculator(10, 2);
		assertThat(bpc.calculate(todaysDate, checkoutDate)).isEqualTo(0);
	}

	@Test
	public void testReversePenalty() {
		LocalDate checkoutDate = LocalDate.of(2015, 4, 1);
		LocalDate todaysDate = LocalDate.of(2015, 5, 1);
		BookPenaltyCalculator bpc = 
				new SimpleBookPenaltyCalculator(10, 2);
		assertThat(bpc.
				calculate(todaysDate, checkoutDate)).
		           isEqualTo(0);
	}

	@Test
	public void testNegativeGracePeriod() {
		try {
			new SimpleBookPenaltyCalculator(10, -2);
		    fail("Should not be here");
		} catch (IllegalArgumentException iae) {
            assertThat(iae).
            hasMessage("Invalid Grace Period: [-2]");
		}
	}
	
	@Test
	public void testLeapYear() {
		LocalDate todaysDate = 
				LocalDate.of(2016, 2, 29);
		LocalDate checkoutDate = 
				LocalDate.of(2016, 1, 31);
		BookPenaltyCalculator bpc = 
				new SimpleBookPenaltyCalculator(10, 1);
		assertThat(bpc.
				calculate(todaysDate, checkoutDate)).
		          isEqualTo(0);
	}
	
	@Test
	public void testLeapYearDifferentCondition() {
		LocalDate todaysDate = 
				LocalDate.of(2016, 3, 1);
		LocalDate checkoutDate = 
				LocalDate.of(2016, 1, 31);
		BookPenaltyCalculator bpc = 
				new SimpleBookPenaltyCalculator(10, 1);
		assertThat(bpc.
				calculate(todaysDate, checkoutDate)).
		          isEqualTo(10);
	}

}
