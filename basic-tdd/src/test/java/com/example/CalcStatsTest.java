package com.example;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CalcStatsTest {

    //We need to calc the min value from a list...
    //Shift + Alt + X, T
    @Test
    public void testOneElementList() {
        List<Integer> list = Arrays.asList(1);
        CalcStats cs = new CalcStats(list);
        assertEquals(new Integer(1), cs.getMinimum());
    }

    @Test
    public void testOneElementListWithDifferentNumber() {
        List<Integer> list = Arrays.asList(40);
        CalcStats cs = new CalcStats(list);
        assertEquals(new Integer(40), cs.getMinimum());
    }

    @Test
    public void testEmptyList() {
        List<Integer> list = Arrays.asList();
        CalcStats cs = new CalcStats(list);
        assertNull(cs.getMinimum());
    }

    @Test
    public void testThreePositiveItems() {
        List<Integer> list = Arrays.asList(10, 3, 12);
        CalcStats cs = new CalcStats(list);
        assertEquals(new Integer(3), cs.getMinimum());
    }

    @Test
    public void testMixNegativeAndPositiveItems() {
        List<Integer> list = Arrays.asList(10, -9, 14, 3, 11);
        CalcStats cs = new CalcStats(list);
        assertEquals(new Integer(-9), cs.getMinimum());
    }
    
    @Test
    public void testNullListAtConstruction() {
        try {
            new CalcStats(null);
            fail("This line should not invoked");
        } catch (IllegalArgumentException iae) {
            assertEquals(CalcStats.LIST_CANNOT_BE_NULL_MSG,
                    iae.getMessage());
        }
    }
    
    @Test
    public void testMaximumOneElementList() {
        List<Integer> list = Arrays.asList(1);
        CalcStats cs = new CalcStats(list);
        assertEquals(new Integer(1), cs.getMaximum());
    }

    @Test
    public void testMaximumOneElementListDifferentNumber() {
        List<Integer> list = Arrays.asList(43);
        CalcStats cs = new CalcStats(list);
        assertEquals(new Integer(43), cs.getMaximum());
    }
    
    @Test
    public void testMaximumNoElementList() {
        List<Integer> list = Arrays.asList();
        CalcStats cs = new CalcStats(list);
        assertEquals(null, cs.getMaximum());
    }
    
    @Test
    public void testMaximumThreePositiveItems() {
        List<Integer> list = Arrays.asList(10, 3, 12);
        CalcStats cs = new CalcStats(list);
        assertEquals(new Integer(12), cs.getMaximum());
    }
    
    @Test
    public void testSizeOneElementList() {
        List<Integer> list = Arrays.asList(1);
        CalcStats cs = new CalcStats(list);
        assertEquals(1, cs.getSize());
    }
    
    @Test
    public void testSizeNoElementList() {
        List<Integer> list = Arrays.asList();
        CalcStats cs = new CalcStats(list);
        assertEquals(0, cs.getSize());
    }
    
    @Test
    public void testSizeThreeItems() {
        List<Integer> list = Arrays.asList(10, 3, 12);
        CalcStats cs = new CalcStats(list);
        assertEquals(3, cs.getSize());
    }
    
    @Test
    public void testAverageWithNoElements() {
    	List<Integer> list = Arrays.asList();
        CalcStats cs = new CalcStats(list);
        assertTrue(Double.isNaN(cs.getAverage()));
    }
    
    @Test
    public void testAverageWith1Element() {
    	List<Integer> list = Arrays.asList(56);
        CalcStats cs = new CalcStats(list);
        assertEquals(56.0, cs.getAverage(), 0.0);
    }
    
    @Test
    public void testAverageWith3Elements() {
    	List<Integer> list = Arrays.asList(56, 72, 98);
        CalcStats cs = new CalcStats(list);
        assertEquals(75.3, cs.getAverage(), 0.1);
    }
    
}
