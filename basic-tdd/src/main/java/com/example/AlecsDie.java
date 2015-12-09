package com.example;

import java.util.Random;

public class AlecsDie {
	private final long seed;
	private final int pips;
	
	public AlecsDie(){
		this(0L);
	}
	
	public AlecsDie(long seed) {
		this(seed, 1);
	}

	public AlecsDie(long seed, int i) {
		this.pips = i;
		this.seed = seed;
	}

	public int getPips() {
		return this.pips;
	}

	public AlecsDie roll() {
		Random rand = new Random(seed);
		AlecsDie rolledDie = new AlecsDie(rand.nextLong(), rand.nextInt(6) + 1);
		return rolledDie;
	}

}
