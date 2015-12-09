package com.example.library;

import java.time.LocalDate;

public class BookCheckout {

	private final String patronName;
	private final String title;
	private final LocalDate checkoutDate;

	private static final String ERROR_MESSAGE_TEMPLATE = 
			"Provided %s is invalid: [%s]";
	
	public BookCheckout(String patronName, 
			String title, LocalDate checkoutDate) {
		
		
		if (patronName == null || patronName.trim().isEmpty()) throw new 
		    IllegalArgumentException 
		(String.format
				 (ERROR_MESSAGE_TEMPLATE, "Patron Name", patronName));
			
		if (title == null || title.trim().isEmpty()) throw new 
		  IllegalArgumentException
		  (String.format
			(ERROR_MESSAGE_TEMPLATE, "Title", title));
				
		if (checkoutDate == null) throw new 
		  IllegalArgumentException
		   (String.format
			 (ERROR_MESSAGE_TEMPLATE, "Checkout Date", checkoutDate));
	
		this.patronName = patronName;
		this.title = title;
		this.checkoutDate = checkoutDate;
	}

	public String getPatronName() {
		return patronName;
	}

	public String getTitle() {
		return title;
	}

	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}

}
