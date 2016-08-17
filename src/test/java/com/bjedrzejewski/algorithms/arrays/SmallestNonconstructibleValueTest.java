package com.bjedrzejewski.algorithms.arrays;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by bartoszjedrzejewski on 17/08/2016.
 */
public class SmallestNonconstructibleValueTest {

    @Test
    public void testSmallestNonconstructibleValue() throws Exception {
        List<Integer> values = new ArrayList<>();
        values.add(12);
        values.add(2);
        values.add(1);
        values.add(4);
        values.add(2);
        values.add(15);
        int result = SmallestNonconstructibleValue.smallestNonconstructibleValue(values);
        assertEquals(result,10);
    }
}