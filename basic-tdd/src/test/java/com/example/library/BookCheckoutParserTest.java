package com.example.library;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.fail;

import java.time.LocalDate;

import org.junit.Test;

public class BookCheckoutParserTest {
	@Test
	public void testParseLinePerfection() {
		String data = "Beth Brown~The Leftovers~2013-03-31";
		BookCheckout bookCheckout = BookCheckoutParser.parseLine(data);

		assertThat(bookCheckout.getPatronName()).isEqualTo("Beth Brown");
		assertThat(bookCheckout.getTitle()).isEqualTo("The Leftovers");
		assertThat(bookCheckout.getCheckoutDate()).isEqualTo(LocalDate.of(2013, 3, 31));
	}

	@Test
	public void testParseLinePerfectionDifferentData() {
		String data = "Jim Price~The Girl In The Spider's Web~2015-08-15";
		BookCheckout bookCheckout = BookCheckoutParser.parseLine(data);

		assertThat(bookCheckout.getPatronName()).isEqualTo("Jim Price");
		assertThat(bookCheckout.getTitle()).isEqualTo("The Girl In The Spider's Web");
		assertThat(bookCheckout.getCheckoutDate()).isEqualTo(LocalDate.of(2015, 8, 15));
	}

	@Test
	public void testParseLineWithBlankLine() {
		String data = "";
		try {
			BookCheckoutParser.parseLine(data);
			fail("Should not be here");
		} catch (IllegalArgumentException iae) {
			assertThat(iae).hasMessage("Provided data is invalid: []");
		}
	}

	@Test
	public void testParseLineWithMoreThan3Items() {
		/* We all decided that this should be permissible */
		String data = "Jim Price~The Girl In The Spider's Web~2015-08-15~ChickenParmaTasteSoGood";
		BookCheckout bookCheckout = BookCheckoutParser.parseLine(data);

		assertThat(bookCheckout.getPatronName()).isEqualTo("Jim Price");
		assertThat(bookCheckout.getTitle()).isEqualTo("The Girl In The Spider's Web");
		assertThat(bookCheckout.getCheckoutDate()).isEqualTo(LocalDate.of(2015, 8, 15));
	}

	@Test
	public void testRogueTilde() {
		String data = "Jim~Price~The Girl In The Spider's Web~2015-08-15";
		try {
			BookCheckoutParser.parseLine(data);
			fail("Should not be here");
		} catch (IllegalArgumentException iae) {
			assertThat(iae).hasMessage("Provided Checkout Date is invalid: [The Girl In The Spider's Web]");
			assertThat(iae.getCause()).isExactlyInstanceOf(java.time.format.DateTimeParseException.class);
		}
	}

	@Test
	public void testLessThan3Items() {
		String data = "Jim Price~The Girl In The Spider's Web";
		try {
			BookCheckoutParser.parseLine(data);
			fail("Should not be here");
		} catch (IllegalArgumentException iae) {
			assertThat(iae).hasMessage("Expected 3 Items, but got 2: [Jim Price~The Girl In The Spider's Web]");
		}
	}

	@Test
	public void testDateIsValid() {
		String data = 
		"Jim Price~The Girl In The Spider's Web~2015-08";
		try {
			BookCheckoutParser.parseLine(data);
			fail("Should not be here");
		} catch (IllegalArgumentException iae) {
			assertThat(iae).
			hasMessage
			("Provided Checkout Date is invalid: [2015-08]");
			assertThat(iae.getCause()).
			isExactlyInstanceOf
			(java.time.format.DateTimeParseException.class);
		}
	}

	// Less than 3 items (done)
	// Invalid Date 2014-02,
	// Poorly formatted Date
	// null data
	// vagabond tildes (Done)
	// null check?
	// Empty
	// Nothing but spaces

}
