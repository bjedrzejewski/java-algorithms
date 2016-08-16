package com.bjedrzejewski.algorithms.sorting;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by bartoszjedrzejewski on 15/08/2016.
 */
public class SortingTest {

    @Test
    public void insertionSort() throws Exception {

        InsertionSort insertionSort = new InsertionSort();

        testSorting(insertionSort);

    }

    @Test
    public void mergeSort() throws Exception {

        MergeSort mergeSort = new MergeSort();

        testSorting(mergeSort);

    }

    public void testSorting(SortingAlgorithm sortingAlgorithm) throws Exception {

        int[] arr = {1,5,4,2,3,6,9,8,7,0};

        sortingAlgorithm.sort(arr);

        for(int i = 0; i < arr.length; i++){
            assertEquals(arr[i], i);
        }

    }
}