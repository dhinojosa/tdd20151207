package com.example;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Random;

import org.junit.Test;
import org.junit.experimental.categories.Category;

//Requirements
//1 to 6, Standard Die
//Immutability
public class DieTest {
	
    @Test
    @Category(value=UnitTest.class)
	public void testDieDefaultIs1() {
    	Random random = mock(Random.class);
    	Die die = new Die(random);
    	assertThat(die.getPips()).isEqualTo(1);
    }
    
    @Test
    @Category(value=UnitTest.class)
    public void testSimpleRollOf4() {
    	//Stub 
    	//Collaborator
        Random random = new Random() {
        	@Override
        	public int nextInt(int bound) {
        		return 3;
        	}
        };
         
        Die die = new Die(random);
        Die rolledDie = die.roll();
        assertThat(die.getPips()).isEqualTo(1);
        assertThat(rolledDie.getPips()).isEqualTo(4);
    }
    
    @Test
    @Category(value=UnitTest.class)
    public void testSimpleRollOf2() {
    	//Stub 
    	//Collaborator
        Random random = new Random() {
        	@Override
        	public int nextInt(int bound) {
        		return 1;
        	}
        };
         
        Die die = new Die(random);
        Die rolledDie = die.roll();
        assertThat(die.getPips()).isEqualTo(1);
        assertThat(rolledDie.getPips()).isEqualTo(2);
    }
    
    @Test
    @Category(value=UnitTest.class)
    public void testMultipleRolls() {
    	Random random = mock(Random.class);
    	when(random.nextInt(6)).thenReturn(2, 3);
    	
        Die die = new Die(random);
        Die rolledDie = die.roll().roll();
        assertThat(rolledDie.getPips()).isEqualTo(4);
    }
    
    @Test
    @Category(value=UnitTest.class)
    public void testBUG3001() {
    	Random random = mock(Random.class);
    	when(random.nextInt(6)).thenReturn(2);
    	
        Die die = new Die(random);
        Die rolledDie = die.roll();
        assertThat(rolledDie.getPips()).isEqualTo(3);
    }
    
    @Test
    @Category(value=IntegrationTest.class)
    public void testIntegrationRolls() {
    	Random random = new Random();
    	Die die = new Die(random);
    	for (int i = 0; i < 100000; i++) {
    	   assertThat(die.roll().getPips())
    	      .isGreaterThan(0).isLessThan(7);	
    	}
    }
    
    @Test
    @Category(value=UnitTest.class)
    public void testRandomMustBeProvided() {
    	try {
    	   new Die(null);
    	   fail("This line should not run");
    	} catch (IllegalArgumentException iae) {
            assertThat(iae)
               .hasMessage("Random cannot be null");  		
    	}
    }
}