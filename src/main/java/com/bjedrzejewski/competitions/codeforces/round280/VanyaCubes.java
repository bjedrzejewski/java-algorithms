package com.bjedrzejewski.competitions.codeforces.round280;

import java.util.Scanner;

/**
 * Basic template for CodeForces submissions
 */
public class VanyaCubes {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long n = input.nextLong();
        long currentLevel = 0;
        long currentSum = 0;
        long level = 0;

        while(currentSum < n){
            level++;
            currentLevel =  currentLevel + level;
            currentSum += currentLevel;
        }

        if(currentSum > n){
            level = level -1;
        }

        System.out.println(level);

        input.close();
    }
}

