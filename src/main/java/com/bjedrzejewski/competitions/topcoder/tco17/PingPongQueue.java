package com.bjedrzejewski.competitions.topcoder.tco17;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by bartoszjedrzejewski on 01/04/2017.
 */
public class PingPongQueue {

    public int[] whoPlaysNext(int[] skills, int N, int K){
        Queue<Integer> q = new LinkedList<>();
        for(int s : skills){
            q.add(s);
        }
        int n = 0;
        int winner = q.poll();
        int challenger = q.poll();
        for(int k = 0; k < K; k++){
            if(k == K -1){
                if(winner > challenger){
                    return new int[]{challenger, winner};
                } else {
                    return new int[]{winner, challenger};
                }
            }


            if(winner > challenger){
                q.add(challenger);
                challenger = q.poll();
                n++;
                if(n == N){
                    q.add(winner);
                    n = 0;
                    winner = q.poll();
                }
            } else {
                n = 1;
                q.add(winner);
                winner = challenger;
                challenger = q.poll();
            }
        }

        return null;
    }


}
