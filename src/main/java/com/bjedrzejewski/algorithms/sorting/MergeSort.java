package com.bjedrzejewski.algorithms.sorting;

/**
 * Created by bartoszjedrzejewski on 16/08/2016.
 */
public final class MergeSort implements SortingAlgorithm {

    /**
     * Merge sort in place on an array of int.
     *
     * @param a unsorted array
     */
    public void sort(int[] a) {
        mergeSort(a, 0, a.length-1);
    }

    private void mergeSort(int[] a, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(a, p, q); //divide into smaller problems
            mergeSort(a, q + 1, r); //divide into smaller problems
            merge(a, p , q, r); //merge the smaller problems
        }
    }

    /**
     * Methods for merging two sorted subarrays into a sorted array
     *
     * @param a unsorted array from the original problem
     * @param p array index such that p <= q < r starting the first subarray
     * @param q array index such that p <= q < r ending the first and starting the second subarray
     * @param r array index such that p <= q < r ending the subarray array
     */
    public void merge(int[] a, int p, int q, int r) {
        int n1 = q - p + 1; //length of the first subarray
        int n2 = r - q; //length of the second subarray
        int[] left = new int[n1 + 1];
        int[] right = new int[n2 + 1];
        //Creating temporary arrays for the merge step.
        for (int i = 0; i < n1; i++) {
            left[i] = a[p + i];
        }
        for (int i = 0; i < n2; i++) {
            right[i] = a[q + i + 1];
        }
        left[n1] = Integer.MAX_VALUE; //Sentinel value for representing the largest possible value
        right[n2] = Integer.MAX_VALUE; //Sentinel value representing the largest possible value
        //Merging of the two temporary arrays into the original array.
        int i = 0;
        int j = 0;
        for (int k = p; k <= r; k++) {
            if (left[i] <= right[j]) {
                a[k] = left[i];
                i++;
            } else {
                a[k] = right[j];
                j++;
            }
        }
    }
}
