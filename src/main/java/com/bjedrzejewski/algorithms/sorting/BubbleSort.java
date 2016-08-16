package com.bjedrzejewski.algorithms.sorting;

/**
 * Created by bartoszjedrzejewski on 15/08/2016.
 */
public final class BubbleSort implements SortingAlgorithm {

    /**
     * Bubble sort in place on an array of int.
     *
     * @param a unsorted array
     */
    public void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for(int j = a.length - 1; j > i; j--){
                if(a[j] < a[j-1]){
                    int temp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = temp;
                }
            }
        }
    }

    @Override
    public String getName() {
        return "Bubble Sort";
    }


}
