package com.example;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DiceFactoryTest {
    @Test
    @Category(value=UnitTest.class)
    public void testFactoryCreation() {
    	Die die = DiceFactory.create();
    	assertThat(die.getRandom()).isNotNull();
    }
}
