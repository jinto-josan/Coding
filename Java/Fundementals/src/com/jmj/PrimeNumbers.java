package com.jmj;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * <ul>
 *     <li>One of the factors of n should be less than sqrt(n) if no such factors then n is prime </li>
 *     <li>Above point doesnt mean prime numbers lie only until sqrt(n) but by sieving all prime numbers until sqrt(n) we have sieved out all prime numbers</li>
 *     <li>
 *         <ul>Sieve of eratosthenes O(nloglogn) space is n & optimize we have to sieve until sqrt(n). Also j starts with i*i until n</ul>
 *         <ul>Segmented sieve , get all prime until sqrt(n) and then sieve segments one by one space is S</ul>
 *         <ul>Gries & Misra algo using lp[i](leastPrimeFactor) & pr(primelist) pr[j]<=lp[i] i*pr[j]=i</ul>
 *     </li>
 *     <li>#ofprimes from 1 to n= n/ln(n)</li>
 *     <li>Test of primality</li>
 *     <li>MillerRabin test</li>
 *     <ol>
 *         <li>for odd n, n-1 is even so n-1=2<sup>s</sup>d</li>
 *         <li>So Fermat's little theorem becomes a<sup>2<sup>s</sup>d</sup>-1 congruent 0 %n</li>
 *         <li>Which translates to (a<sup>2<sup>s-1</sup>d</sup>+1)(a<sup>2<sup>s-2</sup>d</sup>+1)(a<sup>2<sup>s-3</sup>d</sup>+1)...(a<sup>d</sup>+1)(a<sup>d</sup>-1) congruent 0mod n </li>
 *         <li>So we check each factor separately if its -1 or not</li>
 *         <li>So we check for a base 2<=a<=n-2 a<sup>d</sup>%n=1 or a<sup>2<sup>r</sup>d</sup> %n =-1, if we find a base a which doesnt satisfy it then its not prime</li>
 *         <li>Deterministically for a 32 bit we need to check first 4 prime bases only & smallest that fails it is 151*751*28351</li>
 *         <li>For 64 first 12 prime bases</li>
 *     </ol>
 *
 *     <li>#offactorsof n tao(n) where n is p<sup>a</sup>*q<sup>b</sup>*.. = (a+1)(b+1)*(...) because p can be put as p+1 ways</li>
 *     <li>SumOfFactors of n sigma(n)= P<sub>i=1</sub><sup>k</sup>(1+p<sub>i</sub>+p<sub>i</sub><sup>2</sup>...) = P<sub>i=1</sub><sup>k</sup>(GP)</li>
 *     <li>ProductOfFactors of mu(n)=n<sup>tao(n)/2</sup></li>
 *
 *     <li>phi(m) is totient function = #coprimes to n upto n
 *     <ol>
 *         <li>if m is prime then phi(m)=m-1 </li>
 *         <li>if m is prime then for m<sup>k</sup> then from 1 to m<sup>k</sup>, m would divide (m<sup>k</sup>/m) i.e m<sup>k-1</sup> numbers</li>
 *         <li>So phi(p<sup>k</sup>)=p<sup>k</sup>-p<sup>k-1</sup></li>
 *         <li>And phi(ab)=phi(a)*phi(b) where a & b are coprime & in general phi(ab)=phi(a)*phi(b)*gcd(a,b)/phi(gcd(a,b))</li>
 *         <li>So phi(n)=phi(p<sup>a1</sup>)*phi(q<sup>a2</sup>)...</li>
 *         <li>For general phi(n)=n * P<sub>p|n</sub>(1-1/p)</li>
 *     </ol>
 *     </li>
 *     <li>Sum of totient of  all positive divisors d of n = n , i.e sum<sub>d|n</sub>(phi(d))=n </li>
 *     <li>Euler's theorem x<sup>phi(m)</sup>%m=1</li>
 *     <li>Fermat's theorem x<sup>m-1</sup>%m =1 where x & m are coprime & x is prime</li>
 *
 * </ul>
 */
public  class PrimeNumbers  {
    private int N;

    PrimeNumbers(int n){
        N=n;

    }
    PrimeNumbers(){}

    public void optimizedEratosthenesCompute(){
        var arr=new boolean[N+1];
        for(int i=2;i*i<=N;i++){
            if(!arr[i])//not composite
                for(int j=i*i;j<=N;j+=i)
                    arr[j]=true;//composite
        }
        for (int i = 2; i < arr.length; i++) {
            if(!arr[i])
                System.out.printf("%d,",i);

        }
        System.out.println();
    }

    public void griesAndMisra(){
        int[] lp=new int[N+1];
        ArrayList<Integer> pr=new ArrayList<>();

        for(int i=2;i<=N;i++){
            if(lp[i]==0){
                lp[i]=i;
                pr.add(i);
            }
            for(int j=0;j<pr.size() && pr.get(j)<=lp[i] && i*pr.get(j)<=N;j++)
                lp[i*pr.get(j)]=i;
        }
        pr.forEach(i->System.out.printf("%d,",i));
        System.out.println();
    }

    public boolean isPrime(int n){
        if(n<2)
            return false;
        int r=0;
        int d=n-1;
        while((d&1)==0){
            d>>=1;
            r++;
        }
        int[] primeBases={2,3,5,7,11,13,17,19,23,29,31,37};
        for (int a : primeBases) {
            if(n==a)
                return true;
            if(checkComposite(a,n,d,r))
                return false;

        }
        return true;
    }
    public boolean checkComposite(int a, int n, int d, int s){
        int x=(int)BinaryExponenation.modularExponentiation(a,d,n);
        if(x==1 || x==n-1)
            return false;
        for(int r=1;r<s;r++){
            x=x*x%n;
            if(x==n-1)
                return false;
        }
        return true;
    }

    /**
     * Here we are calculating phi of all numbers between 1 to n using an approach similar to sieve of eratosthenes
     * @param n
     */
    public void phi_1_to_n(int n){
        int []phi= new int[n+1];
        phi[0]=0;
        phi[1]=1;
        for(int i=2;i<=n;i++)
            //Assuming all are prime
            phi[i]=i;
        for(int i=2;i<=n;i++)
            if(phi[i]==i)//checking if its prime
                for(int j=i;j<=n;j+=i)
                    phi[j]-=phi[j]/j;
    }
}
