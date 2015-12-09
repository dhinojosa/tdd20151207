package com.example;

import java.math.BigDecimal;
import java.util.Random;

public class Die {

	private final int pips;
	
	//Random Is Not Immutable
	private final Random random;

	public Die(Random random) {
		this(random, 1);
	}

	public Die(Random random, int i) {
		if (random == null) throw new 
		IllegalArgumentException("Random cannot be null");
		
		this.random = random;
		this.pips = i;
	}

	public int getPips() {
		return pips;
	}

	public Die roll() {
		return new Die(random, random.nextInt(6) + 1);
	}

	public Random getRandom() {
		// TODO Auto-generated method stub
		return random;
	}
}
