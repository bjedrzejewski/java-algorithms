package com.bjedrzejewski.algorithms.sorting;

import java.util.List;

/**
 * Created by bartoszjedrzejewski on 15/08/2016.
 */
public final class InsertionSort implements SortingAlgorithm{

    /**
     * Insertion sort in place on an array of int.
     * @param input
     */
    public void sort(int[] input){
        //Arrays of size 0 and 1 are already sorted.
        if(input.length < 2){
            return;
        }
        //We start with the second element, as we treat the first element as an already sorted array.
        for(int j = 1; j < input.length; j++){
            int key = input[j];
            //We are trying to efficiently insert input[j] element into the [0 ... j-1] array.
            int i = j - 1;
            while(i >= 0 && input[i] > key){
                input[i + 1] = input[i];
                i = i - 1;
            }
            //Once input[i] > input[j] or can't find any, we found the correct place.
            input[i+1] = key;
        }
    }

}
