package com.bjedrzejewski.algorithms.sorting;

/**
 * Created by bartoszjedrzejewski on 16/08/2016.
 */
public interface SortingAlgorithm {

    /**
     * Sort an integer array in place
     *
     * @param a unsorted array
     */
    void sort(int[] a);

    /**
     *
     * @return algorithm name
     */
    String getName();
}
