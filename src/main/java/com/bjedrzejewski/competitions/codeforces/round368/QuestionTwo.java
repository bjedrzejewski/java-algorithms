package com.bjedrzejewski.competitions.codeforces.round368;

import java.io.*;
import java.util.*;

public class QuestionTwo implements Runnable {

    BufferedReader in;
    PrintWriter out;
    StringTokenizer tok = new StringTokenizer("");

    public static void main(String[] args) {
        new Thread(null, new QuestionTwo(), "", 256 * (1L << 20)).start();
    }

    public void run() {
        try {
            long t1 = System.currentTimeMillis();
            if (System.getProperty("ONLINE_JUDGE") != null) {
                in = new BufferedReader(new InputStreamReader(System.in));
                out = new PrintWriter(System.out);
            } else {
                in = new BufferedReader(new FileReader("src/main/resources/r368/input2.txt"));
                out = new PrintWriter("output.txt");
            }
            Locale.setDefault(Locale.US);
            solve();
            in.close();
            out.close();
            long t2 = System.currentTimeMillis();
            System.err.println("Time = " + (t2 - t1));
        } catch (Throwable t) {
            t.printStackTrace(System.err);
            System.exit(-1);
        }
    }

    String readString() throws IOException {
        while (!tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }

    int readInt() throws IOException {
        return Integer.parseInt(readString());
    }

    long readLong() throws IOException {
        return Long.parseLong(readString());
    }

    double readDouble() throws IOException {
        return Double.parseDouble(readString());
    }

    // solution

    void solve() throws IOException {
        long n = readLong();
        int m = readInt();
        long k = readLong();
        if (k == 0 || k == n) {
            System.out.println("-1");
            return;
        }
        Map<Long, Map<Long, Long>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            long u = readLong();
            long v = readLong();
            long l = readInt();

            if (map.get(u) == null) {
                map.put(u, new HashMap<>());
            }
            if (map.get(v) == null) {
                map.put(v, new HashMap<>());
            }

            if (map.get(u).containsKey(v)) {
                long lOld = map.get(u).get(v);
                if (l < lOld) {
                    map.get(u).put(v, l);
                    map.get(v).put(u, l);
                }
            } else {
                map.get(u).put(v, l);
                map.get(v).put(u, l);
            }
        }
        Set<Long> storages = new HashSet<>();
        for (long i = 0; i < k; i++) {
            long c = readLong();
            storages.add(c);
        }

        long min = Long.MAX_VALUE;

        for (Long city : storages) {
            if (map.containsKey(city)) {
                for (Long nei : map.get(city).keySet()) {
                    if (!storages.contains(nei)) {
                        if (map.get(city).get(nei) < min) {
                            min = map.get(city).get(nei);
                        }
                    }
                }
            }
        }
        if (min == Long.MAX_VALUE) {
            System.out.println("-1");
        } else {
            System.out.println(min);
        }
    }
}