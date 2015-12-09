package com.example.library;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.fail;

import java.time.LocalDate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.example.UnitTest;

public class BookCheckoutTest {

	private String patronName;
	private String title;
	private LocalDate date;

	@Before
	@Category(value=UnitTest.class)
	public void setUp() {
		patronName = "Sean Bean";
		title = "The Song of Ice and Fire";
		date = LocalDate.of(2014, 4, 30);
	}

	@Test
	@Category(value=UnitTest.class)
	public void testProperties() {
		BookCheckout bookCheckout = new BookCheckout(patronName, title, date);

		assertThat(bookCheckout.getPatronName()).isEqualTo(patronName);
		assertThat(bookCheckout.getTitle()).isEqualTo(title);
		assertThat(bookCheckout.getCheckoutDate()).isEqualTo(date);
	}

	@Test
	@Category(value=UnitTest.class)
	public void testPropertiesDifferentSet() {
		String patronName = "Elvis Presley";
		String title = "Viva Las Vegas";
		LocalDate date = LocalDate.of(2015, 1, 11);

		BookCheckout bookCheckout = new BookCheckout(patronName, title, date);

		assertThat(bookCheckout.getPatronName()).isEqualTo(patronName);
		assertThat(bookCheckout.getTitle()).isEqualTo(title);
		assertThat(bookCheckout.getCheckoutDate()).isEqualTo(date);
	}

	@Test
	@Category(value=UnitTest.class)
	public void testRequiredPatronName() {
		try {
			new BookCheckout(null, title, date);
			fail("This should not run");
		} catch (IllegalArgumentException iae) {
			assertThat(iae).hasMessage("Provided Patron Name is invalid: [null]");
		}
	}

	@Test
	@Category(value=UnitTest.class)
	public void testRequiredTitle() {
		try {
			new BookCheckout(patronName, null, date);
			fail("This should not run");
		} catch (IllegalArgumentException iae) {
			assertThat(iae).
			hasMessage("Provided Title is invalid: [null]");
		}
	}

	@Test
	@Category(value=UnitTest.class)
	public void testRequiredCheckoutDate() {
		try {
			new BookCheckout(patronName, title, null);
			fail("This should not run");
		} catch (IllegalArgumentException iae) {
			assertThat(iae).
			hasMessage(
		   "Provided Checkout Date is invalid: [null]");
		}
	}
	
	@Test
	@Category(value=UnitTest.class)
	public void testPatronNameIsNotEmpty() {
		try {
			new BookCheckout("", title, date);
			fail("This should not run");
		} catch (IllegalArgumentException iae) {
			assertThat(iae).
			hasMessage
			("Provided Patron Name is invalid: []");
		}
	}
	
	@Test
	@Category(value=UnitTest.class)
	public void testTitleIsNotEmpty() {
		try {
			new BookCheckout(patronName, "", date);
			fail("This should not run");
		} catch (IllegalArgumentException iae) {
			assertThat(iae).
			hasMessage
			("Provided Title is invalid: []");
		}
	}
	
	@Test
	@Category(value=UnitTest.class)
	public void testPatronNameIsNotEmptyWithSpaces() {
		String patronNameFluffy = "      ";
		try {
			new BookCheckout(patronNameFluffy, title, date);
			fail("This should not run");
		} catch (IllegalArgumentException iae) {
			assertThat(iae).
			hasMessage
			(String.format
			("Provided Patron Name is invalid: [%s]", patronNameFluffy));
		}
	}
	
	@Test
	@Category(value=UnitTest.class)
	public void testTitleIsNotEmptyWithSpaces() {
		String titleFluffy = "    ";
		try {
			new BookCheckout(patronName, titleFluffy, date);
			fail("This should not run");
		} catch (IllegalArgumentException iae) {
			assertThat(iae).hasMessage
			(String.format
					("Provided Title is invalid: [%s]", titleFluffy));
		}
	}
	
	@After
	public void cleanUp() {
		patronName = null;
	}
}
