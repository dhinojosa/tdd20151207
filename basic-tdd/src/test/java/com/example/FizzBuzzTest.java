package com.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FizzBuzzTest {

    @Test
    public void test1() {
         assertEquals("1",FizzBuzz.toString(1));
    }

    @Test
    public void testInstance() {
        new FizzBuzz();
    }
}
