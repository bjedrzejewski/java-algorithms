package com.bjedrzejewski.competitions.codeforces.round368;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;
import java.util.StringTokenizer;

public class QuestionThree implements Runnable {

    BufferedReader in;
    PrintWriter out;
    StringTokenizer tok = new StringTokenizer("");

    public static void main(String[] args) {
        new Thread(null, new QuestionThree(), "", 256 * (1L << 20)).start();
    }

    public void run() {
        try {
            long t1 = System.currentTimeMillis();
            if (System.getProperty("ONLINE_JUDGE") != null) {
                in = new BufferedReader(new InputStreamReader(System.in));
                out = new PrintWriter(System.out);
            } else {
                in = new BufferedReader(new FileReader("src/main/resources/r368/input3.txt"));
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
        int input = readInt();
        if (input == 1) {
            System.out.println("-1");
            return;
        }
        if (input == 2) {
            System.out.println("-1");
            return;
        }
        BigDecimal n = new BigDecimal(input);
        BigDecimal two = new BigDecimal("2");

        BigDecimal nSquare = n.multiply(n);
        BigDecimal a = null;
        BigDecimal b = null;
        if (nSquare.remainder(two).equals(BigDecimal.ZERO)) {
            a = (((nSquare.divide(two)).subtract(BigDecimal.ONE)).divide(two)).setScale(0, RoundingMode.FLOOR);
            b = a.add(two);
        } else {
            a = (nSquare.subtract(BigDecimal.ONE)).divide(two);
            b = a.add(BigDecimal.ONE);
        }

        System.out.println(a.toPlainString() + " " + b.toPlainString());
    }

}