package com.bjedrzejewski.algorithms.arrays;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Algorithm for finding the smallest value that can't be constructed from array elements.
 *
 * Created by bartoszjedrzejewski on 17/08/2016.
 */
public class SmallestNonconstructibleValue {

    /*
     * @param values unsorted array of positive integers
     * @return smallest value that can't be constructed
     */
    public static int smallestNonconstructibleValue(List<Integer> values){
        Collections.sort(values);
        int maxValue = 0;
        for(int i : values) {
            if (i > maxValue + 1) {
                break;
            }
            maxValue += i;
        }
        return maxValue + 1;

    }

}
