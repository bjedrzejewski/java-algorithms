package com.bjedrzejewski.competitions.topcoder.tco17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by bartoszjedrzejewski on 01/04/2017.
 */
public class CheeseSlicing {

    public int totalArea(int a, int b, int c, int s) {
        int solution =  0;
        List<Integer> sizes = new ArrayList<>();
        sizes.add(a);
        sizes.add(b);
        sizes.add(c);
        Collections.sort(sizes);
        if(a%s == 0 || b%s ==0 || c%s == 0){
            return (a*b*c)/s;
        }

        if(sizes.get(0) < s){
            return 0;
        }

        int leftoverBig = sizes.get(2);
        int leftoverMedium = sizes.get(1);
        int leftoverSmall = sizes.get(0);
        if(sizes.get(2) > 2*s){
            leftoverBig = s + (sizes.get(2)%s);
            solution += sizes.get(0)*sizes.get(1)*((sizes.get(2) - leftoverBig)/s);
            sizes.set(2, leftoverBig);
        }
        if(sizes.get(1) > 2*s){
            leftoverMedium = s + (sizes.get(1)%s);
            solution += sizes.get(0)*sizes.get(2)*((sizes.get(1) - leftoverMedium)/s);
            sizes.set(1, leftoverMedium);
        }
        if(sizes.get(0) > 2*s){
            leftoverSmall = s + (sizes.get(0)%s);
            solution += sizes.get(2)*sizes.get(1)*((sizes.get(0) - leftoverSmall)/s);
            sizes.set(0, leftoverSmall);
        }

        List<Integer> leftovers = new ArrayList<>();
        leftovers.add(leftoverBig);
        leftovers.add(leftoverMedium);
        leftovers.add(leftoverSmall);

        Collections.sort(leftovers);

        solution += leftovers.get(1)*leftovers.get(2);

        return solution;
    }
}
