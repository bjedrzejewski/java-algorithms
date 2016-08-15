package com.bjedrzejewski.algorithms.sorting;

import java.util.List;

/**
 * Created by bartoszjedrzejewski on 15/08/2016.
 */
public final class InsertionSort {

    private InsertionSort(){

    }

    /**
     * Insertion sort in place on an array of int.
     * @param input
     */
    public static void sort(int[] input){
        if(input.length < 2){
            return;
        }
        for(int j = 1; j < input.length; j++){
            int key = input[j];
            int i = j - 1;
            while(i >= 0 && input[i] > key){
                input[i + 1] = input[i];
                i = i - 1;
            }
            input[i+1] = key;
        }
    }

}
