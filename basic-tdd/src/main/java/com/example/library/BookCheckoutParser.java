package com.example.library;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class BookCheckoutParser {

	private static final String PROVIDED_CHECKOUT_DATE_IS_INVALID_MSG = "Provided Checkout Date is invalid: [%s]";

	public static BookCheckout parseLine(String data) {
		if (data.isEmpty()) 
			throw new 
		IllegalArgumentException
		("Provided data is invalid: []");
		
		String[] items = data.split("~");
		
		if (items.length < 3) {
			throw new 
			IllegalArgumentException
			(String.format("Expected 3 Items, but got %d: [%s]",
					items.length, data));
		}
		
		LocalDate parsedDate = null;
		String dateString = items[2];
		
		try {
		   parsedDate= LocalDate.parse(dateString);
		} catch (DateTimeParseException dpe) {
		   throw new IllegalArgumentException
		   (String.format(
				   PROVIDED_CHECKOUT_DATE_IS_INVALID_MSG,
				   dateString),dpe);	
		}
		
		return new BookCheckout
		(items[0], items[1], parsedDate);
	}
	
	
	

	

}
