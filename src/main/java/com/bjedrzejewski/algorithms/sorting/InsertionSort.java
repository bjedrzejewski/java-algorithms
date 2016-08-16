package com.bjedrzejewski.algorithms.sorting;

import java.util.List;

/**
 * Created by bartoszjedrzejewski on 15/08/2016.
 */
public final class InsertionSort implements SortingAlgorithm {

    /**
     * Insertion sort in place on an array of int.
     *
     * @param a unsorted array
     */
    public void sort(int[] a) {
        //Arrays of size 0 and 1 are already sorted.
        if (a.length < 2) {
            return;
        }
        //We start with the second element, as we treat the first element as an already sorted array.
        for (int j = 1; j < a.length; j++) {
            int key = a[j];
            //We are trying to efficiently insert a[j] element into the [0 ... j-1] array.
            int i = j - 1;
            while (i >= 0 && a[i] > key) {
                a[i + 1] = a[i];
                i = i - 1;
            }
            //Once a[i] > a[j] or can't find any, we found the correct place.
            a[i + 1] = key;
        }
    }

    @Override
    public String getName() {
        return "Insertion Sort";
    }

}
