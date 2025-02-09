package com.jmj.implementations.modular;

/**
 * <li> n|(1<<x) sets the xth bit of n to 1 </li>
 * <li> n&~(1<<x) sets the xth bit of n to 0 </li>
 * <li> n^(1<<x) toggles the xth bit of n </li>
 * <li> n&-n returns the rightmost set bit of n </li>
 * <li> n&n-1 clears the rightmost set bit of n -> this is used by brian kernighan's algorithm to find number of set bit as we iterate continuously until n is 0 </li>
 * <li> n|n+1 sets the rightmost cleared bit of n </li>
 * <li> n|n-1 clears the rightmost set bit of n </li>
 * <i> n>>x & 1 checks if a bit is set </i>
 * <i> n & (2<sup>k</sup>-1)=0 => n & ((1<<k)-1) =0  divisible by kth power of 2 </i>
 * <i> n & (n-1) =0 => n is power of 2 </i>
 * <li> Count set bits upto n i.e x.2<sup>x-1</sup></li>
 */
public class BitManipluation {
}
