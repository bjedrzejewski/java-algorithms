package com.bjedrzejewski.competitions.hackerrank.worldcodesprint6;

import java.util.*;

/**
 * Created by bartoszjedrzejewski on 27/08/2016.
 */
public class Beautiful3Set {

    public static int n;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
       // n = 3;

        HashSet<Integer> untried = new HashSet<>();
        for(int i =0; i<n; i++){
            untried.add(i);
        }

        ArrayList<Integer> pairs = solve(0, n, new ArrayList<>(), new HashSet<>(), untried);

        System.out.println(pairs.size());
        int i = 0;
        for(Integer p : pairs){
            System.out.println(i+ " "  +p+" "+(n - i -p));
            i++;
        }
    }

    public static int gC = 0;
    public static int gM = 0;
    public static List<Integer> gS = new ArrayList<>();


    public static ArrayList<Integer> solve(int current, int goal, ArrayList<Integer> triedVals, Set<Integer> completed, HashSet<Integer> untried){

        if(current >= goal){
            return triedVals;
        }

        int max = triedVals.size();

        //ArrayList<Integer> pairs = new ArrayList<>();
        //pairs.addAll(triedVals);

        ArrayList<Integer> bSol = null;

        //for(int i = 0; i + current <= goal; i++){
        HashSet<Integer> newUntried = new HashSet<>(untried);
        for(int i : untried){
            if(triedVals.contains(i))
                continue;
            else {
                if(completed.contains(i + current)) {
                    continue;
                } else {
                    if(i + current > goal){
                        continue;
                    }
                    triedVals.add(i);
                    completed.add(i + current);
                    newUntried.remove(i);
                    ArrayList<Integer> solution = solve(current+1, goal, triedVals, completed, newUntried);
                    if(solution.size() > max){
                        gC++;
                        //pairs.clear();
                        //pairs.addAll(solution);
                        bSol = new ArrayList<>(solution);
                        max = solution.size();
                        if(max > gM){
                            gM = max;
                            gS.clear();
                            gS.addAll(bSol);
                        }
                        //  if(gM ==253)
                        //      System.out.println(gC);
                        if(gC >2000000){
                            System.out.println(gM);
                            int u = 0;
                            for(Integer p : gS){
                                System.out.println(u+ " "  +p+" "+(n - u -p));
                                u++;
                            }
                            System.exit(0);
                        }
                        //System.out.println(max);

                    }
                    triedVals.remove(triedVals.size() -1);
                    completed.remove(i + current);
                    newUntried.add(i);
                }
            }
            //  triedVals.addAll(pairs);
        }
        if(bSol != null){
            //triedVals.addAll(bSol);
            //bSol.addAll(triedVals);
            return bSol;
        }

        return triedVals;
    }
}
