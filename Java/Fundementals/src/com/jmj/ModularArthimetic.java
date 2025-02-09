package com.jmj;

/**
 * <ol>
 *     <lo>x congruent b mod m => x mod m =b</lo>
 *     <li>(x+-*y)%m=(x%m+-*y%m)%m & x<sup>n</sup>%m=(x%m)<sup>n</sup>%m</li>
 *     <li>So equation can be solved such as m=ka+r <=> 0=ka+r mod m <=> -r=ka mod m <=> -ra^-1=k mod m <=> a^-1=-kr^-1 mod m<=> Here note that = means congruent</li>
 *     <li>Modular inverse (aa<sup>-1</sup> congruent 1 mod m) exist only if gcd(a,m)=1</li>
 *     <li>Linear congruence equation ax congruent b mod m</li>
 *     <li>
 *     <ol>
 *         <li>if gcd(a,m) divides b then solution exist</li>
 *         <li>if x<sub>0</sub> is a solution then x<sub>0</sub>+m/gcd(a,m) is also a solution</li>
 *         <li>if gcd(a,m) is 1 then unique solution exist</li>
 *         <li>if a,b,m are given then x=a<sup>-1</sup>b mod m</li>
 *         <li>Solve a.x +m.k=b to get solution where a, m and b are divided by g and solved</li>
 *     </ol>
 *     </li>

 *     <li>Chineese Remainder theorem
 *     <ul>
 *         <li>M=m1.m2.m3.m4.m5... where mi are pairwise coprime & we have a=a1 mod m1 , a=a2 mod m2, a=a3 mod m3 ...where a1 a2 a3.. are some constant, then the given system has one & exactly one solution for a mod M </li>
 *         <li>x= i=1toksum(ai*Mi*yi) where Mi=M/mi & Mi*yi congruent to 1 mod mi</li>
 *     </ul>
 *     </li>
 *     <li>Factorial both in numerator and denominator modulo p where p is prime and factors of p cancels on both num & den
 *     <ul>
 *
 *         <li>(p-1)! congruent to -1 mod p as per Wilson's theorem</li>
 *         <li>Here n is where all p terms factor out , then we would have n//p blocks and the rest so result will (-1)<sup>n//p</sup>*rest mod(p)</li>
 *
 *     </ul>
 *     </li>
 *
 * </ol>
 */
public class ModularArthimetic {

    public static long modInverse(int a, int m) {
        return Algebra.extendedEuclideanGcd(a, m).a();
    }

    /**
     * <ul>
     *     <li>Its using fermat's theorem to solve the problem in O(logn) time</li>
     *     <li>a<sup>phi(m-1)</sup> congruent to 1 mod m & if m is prime then a<sup>m-1</sup> congruent to 1 mod m</li>
     *     <li>For prime modulus a<sup>m-2</sup> congruent a <sup>-1</sup> mod m & for arbitary it would be a<sup>phi(m)-1</sup> congurent a <sup>-1</sup> mod m</li>
     * </ul>
     * @param a
     * @param m
     * @return
     */

    public static long modInverseFermat(long a, long m) {
        return BinaryExponenation.modularExponentiation(a, m - 2, m);
    }

    /**
     * For prime modulus m>a(or make it smaller by taking modula) especially for 10^9+7
     * <ul>
     *     <li>According to eucledian division m=k*a+r and it will be solved as a^-1 congruent to -k*r^-1 mod m where k is m//a & r =m mod a</li>
     * </ul>
     * @param a
     * @param m
     * @return
     */

    int inv(int a, int m){
        return a<=1?a:m-(m/1)*inv(m%a,m)%m;
    }

    public static int solveLinearCongruence(int a, int b, int m){
        long g=Algebra.gcd(a,m);
        if(b%g!=0)
            return -1;
        a/=g;
        b/=g;
        m/=g;
        return (int) ((modInverse(a,m)*b)%m);
    }




}
