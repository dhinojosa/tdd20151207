package com.example;

public class PaulsDieImpl {

	   private final int value;
	   
	   public PaulsDieImpl(int value) {
		   this.value = value;
	   }
	   
	   public int read() {
		   return value;
	   }
}
