package com.bjedrzejewski.algorithms.mathematics;

/**
 * Efficient algorithm for evaluating polynomials.
 * <p>
 * Created by bartoszjedrzejewski on 16/08/2016.
 */
public class HornersMethod {

    /**
     * Evaluates polynomial with the use of Horners Method.
     *
     * @param a array of coefficients a[0]*x^0 + a[1]*x^1 + ... + a[n]*x^n
     * @param x value of x to be evaluated
     * @return
     */
    public static double evaluatePolynomial(double[] a, double x) {
        double result = 0;
        for (int i = a.length - 1; i >= 0; i--) {
            result = a[i] + x * result;
        }
        return result;
    }

}
