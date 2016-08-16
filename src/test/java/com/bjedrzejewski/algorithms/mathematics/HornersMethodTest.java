package com.bjedrzejewski.algorithms.mathematics;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by bartoszjedrzejewski on 16/08/2016.
 */
public class HornersMethodTest {

    @Test
    public void hornersMethodTest() {
        double x = 3;
        double[] a = {1, 4, 2, 5};

        HornersMethod hornersMethod = new HornersMethod();
        double value = hornersMethod.evaluatePolynomial(a, x);

        //1 + 4x + 2x^2  + 5x^3 for x = 3 is 1 + 12 + 18 + 135 = 166
        assertTrue(value == 166);
    }


}