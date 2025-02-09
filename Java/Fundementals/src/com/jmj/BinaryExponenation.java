package com.jmj;

/**
 * @description This function calculates a^b in O(log b) time. Can be used with (AB)C=A(BC)
 * <p><b>Concept used:- </b></p>
 * <ul>
 *    <li>a^b 2^5 = 2^(2^2) * 2^(2^0) because 5 is 101 in binary and we keep on squaring the base when we encounter 1 in binary representation of b we multiply the result with the base</li>
 *    <li>a^(b/2) * a^(b/2) = a^b</li>
 *    <li>if b is even then a^b = a^(b/2) * a^(b/2) else a^b = a^(b/2) * a^(b/2) * a and this is recursive approach</li>
 * </ul>
 *
 * <b>Applications</b>
 * <ul>
 *     <li>Fast exponentiation</li>
 *     <li>Modular exponentiation</li>
 *     <li>Calculating Fibonacci numbers</li>
 *     <li>Calculating nCr % p</li>
 * </ul>
 **/
public class BinaryExponenation {

    // Function to calculate a^b in O(log b) time
    /**
     * @param a base
     * @param b exponent
     * @return a^b
     */
    public static long binaryExponentiation(long a, long b) {
        long result = 1;
        while (b > 0) {
            if ((b & 1) ==1 ) {
                result = result * a;
            }
            a = a * a;
            b >>= 1;
        }
        return result;
    }
    public static double binaryExponentiationRecursion(long a, long b){
        if(b==0)
            return 1;
        if((b&1)==0)
            return Math.pow(binaryExponentiationRecursion(a,b>>1),2);
        else
            return Math.pow(binaryExponentiationRecursion(a,(b-1)>>1),2) * a;

    }

    /**
     * @param a base
     * @param b exponent
     * @param m modulo
     * @return a^b % m
     * @description a.b % m = (a % m) * (b % m) % m
     *
     */

    public static long modularExponentiation(long a, long b, long m) {
        long result = 1;
        a = a % m;
        while (b > 0) {
            if ((b & 1) ==1 ) {
                result = (result * a) % m;
            }
            a = (a * a) % m;
            b >>= 1;
        }
        return result;
    }


    public static long nthFibonacci(long n) {
        long[][] F = new long[][]{{1, 1}, {1, 0}};
        if (n == 0) {
            return 0;
        }
        power(F, n - 1);
        return F[0][0];
    }

    private static void power(long[][] F, long n) {
        if (n == 0 || n == 1) {
            return;
        }
        long[][] M = new long[][]{{1, 1}, {1, 0}};
        power(F, n / 2);
        multiply(F, F);
        if (n % 2 != 0) {
            multiply(F, M);
        }
    }

    private static void multiply(long[][] F, long[][] M) {
        long x = F[0][0] * M[0][0] + F[0][1] * M[1][0];
        long y = F[0][0] * M[0][1] + F[0][1] * M[1][1];
        long z = F[1][0] * M[0][0] + F[1][1] * M[1][0];
        long w = F[1][0] * M[0][1] + F[1][1] * M[1][1];
        F[0][0] = x;
        F[0][1] = y;
        F[1][0] = z;
        F[1][1] = w;
    }
}
