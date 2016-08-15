package com.bjedrzejewski.algorithms.sorting;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by bartoszjedrzejewski on 15/08/2016.
 */
public class InsertionSortTest {

    @Test
    public void testSort() throws Exception {
        int[] test1 = {1,5,4,2,3,6,9,8,7,0};

        InsertionSort.sort(test1);

        for(int i = 0; i < test1.length; i++){
            assertEquals(test1[i], i);
        }

    }
}