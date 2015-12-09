package com.example;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

// Specs
// Die 1-6
// Immutability
public class AlecsDieTest {
	@Test
	public void testDefaultIsOne(){
		AlecsDie die = new AlecsDie();
		assertEquals(1, die.getPips());
	}
	
	@Test
	public void testThatICanRollA2(){
		Long seed = 0L;
		AlecsDie die = new AlecsDie(seed);
		assertEquals(2, die.roll().getPips());
	}
	
	@Test
	public void testImmutability(){
		AlecsDie die = new AlecsDie();
		assertEquals(die.roll().getPips(), die.roll().getPips());
	}
	
	@Test
	public void integrationTestBetween1And6(){
		AlecsDie die = new AlecsDie(System.currentTimeMillis());
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(1,0);
		map.put(2,0);
		map.put(3,0);
		map.put(4,0);
		map.put(5,0);
		map.put(6,0);
		
		for(int i = 0; i < 1000000; i++){
			die = die.roll();
			assertTrue(die.getPips() <= 6 && die.getPips() >= 1);
			map.put(die.getPips(), map.get(die.getPips()) + 1);
		}
		double sum = 0;
		for(int i = 1; i <= 6; i++){
			sum += (map.get(i) / 10000.0);
			System.out.println((map.get(i) / 10000.0) + "%");
		}
		assertEquals(sum, 100, .01);

		
	}
	
	
}
