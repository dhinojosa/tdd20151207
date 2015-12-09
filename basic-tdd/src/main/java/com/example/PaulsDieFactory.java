package com.example;

import java.util.Random;
import java.util.function.IntSupplier;

public class PaulsDieFactory {
   public static PaulsDieImpl roll(Random random) {
     return roll(new IntSupplier() {
		@Override
		public int getAsInt() {
			return random == null ? 1 : random.nextInt(6) + 1;
		}
	});	   
   }
   
   public static PaulsDieImpl roll(IntSupplier supplier) {
	   if (supplier == null) {
		   return new PaulsDieImpl(1);
	   }
	   return new PaulsDieImpl(supplier.getAsInt());
   }
}
