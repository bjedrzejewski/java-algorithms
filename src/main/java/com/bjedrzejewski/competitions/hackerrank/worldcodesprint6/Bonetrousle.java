package com.bjedrzejewski.competitions.hackerrank.worldcodesprint6;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by bartoszjedrzejewski on 27/08/2016.
 */
public class Bonetrousle {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int it = 0; it < t; it ++){
            long n = in.nextLong();
            long k = in.nextLong();
            int b = in.nextInt();
            //   (1+b)*b/2   for 1 it is 1, for 4 it is 10.
            BigDecimal min = BigDecimal.valueOf(b + 1).multiply(BigDecimal.valueOf(b)).divide(BigDecimal.valueOf(2));
            //   System.out.println(min);
            //   (k-b+1 + k)*b/2   for k = 10 and n = 2, you get 19
            BigDecimal max = BigDecimal.valueOf(k - b + 1 + k).multiply(BigDecimal.valueOf(b)).divide(BigDecimal.valueOf(2));
            //   System.out.println(max);
            BigDecimal N = BigDecimal.valueOf(n);
            if(N.compareTo(min) < 0){
                System.out.println("-1");
                continue;
            }
            if(N.compareTo(max) > 0){
                System.out.println("-1");
                continue;
            }
            long[] adjust = new long[b]; //array is 0 based, but boxes are 1 based
            long dif = N.subtract(min).longValue();
            //b = 3, ai = 2
            int ai = b-1; //starting at the end of the array

            int loop = 0;
            while(dif > 0){
                //val = 3
                long val = ai+1;
                //check increase requierd -> val + dif
                long newVal = val + dif;
                //k -
                if(newVal > k - loop){
                    newVal = k - loop;
                }
                long difMade = newVal - val;
                adjust[adjust.length-1-loop] = (difMade);
                dif -= difMade;
                ai--;
                loop++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i =0; i < b; i++){
                sb.append(1 + i + adjust[i]);
                if(i != b-1)
                    sb.append(" ");
            }
            System.out.println(sb.toString());
          //  if(it != t-1)
          //      System.out.println();
        }
    }


}
