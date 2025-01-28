/**
 * lcm(a,b)*gcd(a,b)=a*b
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


}
