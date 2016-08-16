package com.bjedrzejewski.algorithms.sorting;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertTrue;

/**
 * Created by bartoszjedrzejewski on 15/08/2016.
 */
public class SortingTest {

    public static final int SEED = 0;
    int[][] testCases;

    @Before
    public void setUp() {
        int numberOfTestCases = 4;
        testCases = new int[numberOfTestCases][];
        Random random = new Random(SEED);
        for (int i = 1; i <= numberOfTestCases; i++) {
            int n = (int) Math.pow(10, i);
            testCases[i - 1] = new int[n];
            for (int j = 0; j < n; j++) {
                testCases[i-1][j] = random.nextInt();
            }
        }
    }

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

    @Test
    public void bubbleSort() throws Exception {
        BubbleSort bubbleSort = new BubbleSort();
        testSorting(bubbleSort);
    }

    public void testSorting(SortingAlgorithm sortingAlgorithm) throws Exception {

        for(int[] a : testCases){
            int[] test = a.clone();
            long start = System.currentTimeMillis();
            sortingAlgorithm.sort(test);
            long end = System.currentTimeMillis();
            long timeTaken = end - start;
            System.out.println(sortingAlgorithm.getName()+" took "+timeTaken+" milliseconds to sort "+a.length+" elements");
        }
    }

    /**
     * Check that the array is sorted
     * @param a
     * @throws Exception
     */
    public void isSorted(int[] a) throws Exception {
        for (int i = 0; i < a.length - 1; i++) {
            assertTrue(a[i] < a[i+1]);
        }
    }

}