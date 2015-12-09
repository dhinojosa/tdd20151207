package com.example;

import static org.fest.assertions.Assertions.assertThat;

import java.util.Random;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class LambdaDieTest {

	/* @Test
	@Category(value = UnitTest.class)
	public void testBasicRollOf3() {
        LambdaDie die = new LambdaDie(() -> 3);
        assertThat(die.roll().getPips()).isEqualTo(3);
	}
	
	@Test
	@Category(value = IntegrationTest.class)
	public void testIntegrationWithRealRandom() {
		Random random = new Random();
        LambdaDie die = new 
        		LambdaDie(() -> random.nextInt(6) + 1);
        assertThat(die.roll().getPips())
           .isGreaterThan(0).isLessThan(7);
	} */
}
