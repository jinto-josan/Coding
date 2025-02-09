package com.jmj;

/**
 * lcm(a,b)*gcd(a,b)=a*b</br>
 * <b>Solving recursion</b>
 * <ol>
 *
 * <li><b>Recursion to matrix </b>F<sub>n</sub>= linear combo of (F<sub>n-1</sub>,F<sub>n-2</sub>,..F<sub>n-k</sub>)
 * <ul>
 *     <li>You will need k*k matrix</li>
 *     <li>Find matrix A such that [F<sub>n</sub>, F<sub>n-1</sub>] = A[F<sub>n-1</sub>,F<sub>n-2</sub>] where , seperates row</li>
 *     <li>Example Fibonacci F<sub>n</sub>=F<sub>n-1</sub>+F<sub>n-2</sub> so we need 2x2 matrix so A becomes [ 1 1, 1 0]</li>
 *     <li> It can be made formula as [F<sub>n</sub>, F<sub>n-1</sub>] = A<sup>n</sup>[F<sub>1</sub>,F<sub>0</sub>]</li>
 * </ul>
 * </li>
 * <li>
 * <b>Master theorem</b> for T(n)=aT(n/b)+f(n) f(n) is asymptotically positive function
 * <ol>
 *     <li> if f(n) = O(n<sup>c</sup>) where c < log<sub>b</sub>a then T(n)=O(n<sup>log<sub>b</sub>a</sup>)</li>
 *     <li> if f(n) = theeta(n<sup>c</sup>) where c < log<sub>b</sub>a then T(n)=theeta(n<sup>log<sub>b</sub>a</sup> log n)</li>
 *     <li> <li> if f(n) = omega(n<sup>c</sup>) where c > log<sub>b</sub>a then T(n)=theeta(f(n))</li>
 * </ol>
 * </li>
 * <li>
 *     <b>Recursion Tree Method</b> Draw the tree. O(f(n)) = O(cost per level * height of tree)
 * </li>
 * <li><b>Iterative substitution</b> Iteratively substitue and sum it up to get result </br>
 * <ul>
 *     <p>T(n)=T(n-1)+1</br>
 *     T(n-1)=T(n-2)+1</br>
 *     ....</br>
 *     T(1)=T(0)+1</br>
 *
 *     </p>
 * </ul>
 *
 * </li>
 * <li>
 *     <b>Akra-Bazzi theorem</b> T(x)= sum<sub>i=1</sub><sup>k</sup>(g<sub>i</sub>(x)+h(x))</br>
 *     Here g<sub>i</sub> is work done in recursive call & h is work done at each level n<sub>0</sub> is small value where recurrence is initialized or stops</br>
 *     <b>Steps</b>
 *     <ol>
 *         <li>Setup functional equation sum<sub>i=1</sub><sup>k</sup>(g<sub>i</sub>(x)T(n/b<sub>i</sub>)+h(x))</li>
 *         <li>Balance equation solve to get p :- sum<sub>i=1</sub><sup>k</sup>(g<sub>i</sub>(x).b<sub>i</sub><sup>-p</sup>=1</li>
 *         <li>Solve recurrence using p if h(n) <<n<sup>p</sup> then T(n)=O(n<sup>p</sup>) else O(n<sup>p</sup> log n)</li>
 *         <li>Handle initial condition to get values</li>
 *
 *         <li> Example :- T(n)=2T(n/2)+O(n<sup>2</sup>) => g<sub>1</sub>(n)=2 , b<sub>1</sub>=2 & h(n)=O(n<sup>2</sup>)</li>
 *         <li>Exponent p =1 as 2.2<sup>-p</sup></li>
 *         <li> T(n)=O(n) and as non recursive work dominate the answer is O(n<sup>2</sup>)</li>
 *     </ol>
 *
 * </li>
 * <li>
 *     <b>Characterctic equation to show closed form using roots of polynomial equation</b></br>
 *     Example:- T(n)=3T(n-1)+2T(n-2) with initial condition T(0)=1 & T(1)=3 so T(n)=r<sup>n</sup> -> r<sup>2</sup> - 3r +2 =0 Solving equation gives root of solution as r1 & r2
 *     General soultion is T(n)=c1r1<sup>n</sup>+c2r2<sup>n</sup> where c1 & c2 will be figured out from initial condition
 * </li>
 *
 * </ol>
 *
 */
public class Algebra {

    public record Pair(int a, int b){
    };

    /**
     *
     * @param a
     * @param b
     * @return euclidanGcd(a,b)
     * @description Theory
     * <ol>
     *     <li>a=qb+r where q=floor(a/b)</li>
     *     <li>gcd(a,b)=gcd(b,r)</li>
     *     <li>gcd(a,b)=gcd(b,a%b)</li>
     *     <li>Recursively iterate until gcd(a,0)=a</li>
     * </ol>
     */
    public static long gcd(int a, int b){
        if(b==0)
            return a;
        return gcd(b,a%b);
    }
    public static long binaryGcd(int a, int b){
        if((a&1)==0 && (b&1)==0)
            return 2*binaryGcd(a>>1,b>>1);
        else if((a&1)==1 && (b&1)==1)
            if(a>b)
                return binaryGcd(b,a-b);
            else
                return binaryGcd(a,b-a);
        else
            return binaryGcd(b,a%b);
    }

    /**
     *
     * @param a
     * @param b
     * @return coeffecients x & y in equation ax+by=gcd(a,b)
     * @description Derivation
     * <h3>Recursive process</h3>
     * <ol>
     *     <li> a*x1+b*y1=gcd(a,b) </li>
     *     <li> b*x2+(a%b)*y2=gcd(b,a%b) </li>
     *     <li> b*x2+(a-(a/b)*b)*y2=gcd(b,a%b) </li>
     *     <li> b*x2+a*y2-(a/b)*b*y2=gcd(b,a%b) </li>
     *     <li> a*y2+b*(x2-(a/b)*y2)=gcd(b,a%b) </li>
     *     <li> x1=y2, y1=x2-(a/b)*y2 </li>
     * </ol>
     * <h3>Iterative process</h3>
     * <ol>
     *     <li>a=bq<sub>1</sub>+r<sub>1</sub> => r<sub>1</sub>=a-bq<sub>1</sub></li>
     *     <li>b=r<sub>1</sub>q<sub>2</sub>+r<sub>2</sub> => r<sub>2</sub>=b-r<sub>1</sub>q<sub>2</sub></li>
     *     <li>r<sub>1</sub>=r<sub>2</sub>q<sub>3</sub>+r<sub>3</sub></li>...
     *     <li>r<sub>n-2</sub>=r<sub>n-1</sub>q<sub>n</sub>+0</li>
     * </ol>
     * <p>Initialize</p>
     * <ol>
     *     <li>For ax+by=gcd(a,b)</li>
     *     <li>At x=1 & y=0  corresponds to a let this be a<sub>0</sub></li>
     *     <li>At x=0 & y=1  corresponds to b let this be b<sub>0</sub></li>
     *     <li>At each iteration q=a<sub>i</sub>//b<sub>i</sub> & r=a<sub>i</sub>%b<sub>i</sub> </li>
     *     <li>Update each time a & b as & a<sub>i+1</sub>=b<sub>i</sub> & b<sub>i+1</sub>=r</li>
     *     <li>So coeffecients become x<sub>i+1</sub>=x<sub>i</sub>-qx<sub>i-1</sub> & y<sub>i+1</sub>=y<sub>i</sub>-qy<sub>i-1</sub></li>
     *     <li>At point when b<sub>i</sub>=0 & a<sub>i</sub>=gcd(a,b) x<sub>i</sub> & y<sub>i</sub> are coeffecients</li>
     * </ol>
     * Todo: I have to see how this was derived for iterative
     */
    public static Pair extendedEuclideanGcd(int a, int b){
        if(b>a){
            int swTmp=a;
            a=b;
            b=swTmp;
        }

        Pair prevXY=new Pair(1,0), curXY=new Pair(0,1), a1B1=new Pair(a,b);
        while(a1B1.b()>0){
            int q=a1B1.a()/a1B1.b();
            int newx= prevXY.a()-q* curXY.a();
            int newy= prevXY.b()-q* curXY.b();
            a1B1=new Pair(a1B1.b(),a1B1.a()%a1B1.b());
            prevXY=curXY;
            curXY=new Pair(newx,newy);
        }
        return prevXY;
    }

    /**
     * Linear Diophantine equation ax+by=c has solution only if c is divisible by g
     * Todo: Not sure why c has to be divisible by g
     * <ul>
     *     <li>Degenerate case when a=b=0 so infinite solution if c=0 else no solution</li>
     *     <li>Finding one solution</br>
     *          <ol>
     *              <li>ax<sub>g</sub>+by<sub>g</sub>=g</li>
     *              <li>Multiply entire equation by c/g so ax<sub>g</sub> * c/g + by<sub>g</sub> * c/g = c</li>
     *              <li>So x=x<sub>g</sub> * c/g & y=y<sub>g</sub> * c/g if a or b < 0 then multiply x or y with -1 respectively</li>
     *          </ol>
     *     </li>
     *     <li>Finding all solution</li>
     *          <ol>
     *              <li>Adding b/g to x<sub>g</sub> & subtracting a/g from y<sub>g</sub> the equation remains same</li>
     *              <li>a(x<sub>g</sub>+b/g)+b(y<sub>g</sub>-a/g)=c => x=x<sub>g</sub>+k*b/g & y=y<sub>g</sub>-k*b/g are all solution</li>
     *          </ol>
     *     <li>Finding number of solutions & solution themselves in a given interval [min<sub>x</sub>,max<sub>x</sub>] & [min<sub>y</sub>,max<sub>y</sub>]</li>
     *          <ol>
     *              <li>Find x such that x>min<sub>x</sub> & x< max<sub>x</sub></li>
     *              <li>Similarly find for y</li>
     *              <li>Intersection of both this points would be the values</li>
     *          </ol>
     *     <li>Finding a solution with minimum x+y</li>
     *          <ol>
     *              x+y = x<sub>g</sub> + y<sub>g</sub> + k (b/g-a/g) if a<b then choose smallest k else largest k
     *          </ol>
     * </ul>
     */
    public static Pair linearDiophantineEquation(){

        //Todo: need to implement

        return new Pair(0,0);
    }


    /**
     * F<sub>n</sub>=F<sub>n-1</sub>+F<sub>n-2</sub>
     * <ol>
     *     <li>Cassinis Identitiy :- F<sub>n-1</sub>F<sub>n+1</sub> - F<sub>n</sub><sup>2</sup> = (-1)<sup>n</sup></li>
     *     <li>Addition rule:- F<sub>n+k</sub> = F<sub>k</sub>F<sub>n+1</sub> + F<sub>k-1</sub>F<sub>n</sub></li>
     *     <li>Substituting k=n in above then F<sub>2n</sub>=F<sub>n</sub>(F<sub>n+1</sub> + F<sub>n-1</sub></li>
     *     <li>Which also implies F<sub>m</sub> is multiple of F<sub>n</sub> then m is multiple of n</li>
     *     <li>GCD Identity :- GCD(F<sub>m</sub>,F<sub>n</sub>)=F<sub>GCD(m,n)</sub></li>
     *     <li>Zeckendrof's theory - any natural number can be represented as sum of Fibonacci number. Only the representation shouldnt use consecutive fib number</li>
     *     <li>For binary encoding 19 - F7+F5+F1 - Find  fib number less than 19 and set F(i-2) bit from left indexed 0 to 1. Subtract and repeat and at end put 1 to indicate end</li>
     *     <li>nth Fibonacci number F<sub>n</sub>= (((1+5<sup>1/2</sup>)/2)<sup>n</sup> - (1-5<sup>1/2</sup>)/2)<sup>n</sup>))/5<sup>1/2</sup></li> where 5<sup>1/2</sup>=2.236
     * </ol>
     * @return
     */

    public static long fibonacciNumber(){
        return 0;
    }


}
