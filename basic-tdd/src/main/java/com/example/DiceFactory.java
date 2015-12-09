package com.example;

import java.util.Random;
import java.util.function.IntSupplier;

public class DiceFactory {
	public static Die create() {
		return new Die(new java.util.Random());
	}
	
	public static LambdaDie createLambdaDie() {
		Random random = new java.util.Random();
		return new LambdaDie(new IntSupplier() {
			@Override
			public int getAsInt() {
				return random.nextInt();
			}
		});
	}
}
