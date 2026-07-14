public class Solution {
    public static int frogJump(int n, int heights[]) {
        int[] dp = new int[n];

        for(int i = 1 ; i < n ; i++){
            int one = Math.abs(heights[i]-heights[i-1]) + dp[i-1];
            int two = Integer.MAX_VALUE;
            if(i>1) two = Math.abs(heights[i]-heights[i-2]) + dp[i-2];

            dp[i] = Math.min(one,two);
        }

        return dp[n-1];
    }
}

import java.util.* ;
import java.io.*; 
public class Solution {
    public static int frogJump(int n, int heights[]) {
        int[] dp = new int[n];
        Arrays.fill(dp,(int)(-1e9));
        return func(n-1,heights, dp);
    }

    public static int func(int ind, int heights[], int[] dp) {
        if(ind<0)return 0;
        if(ind==0)return 0;
        if(dp[ind]!=(int)(-1e9))return dp[ind];

        int one = Math.abs(heights[ind]-heights[ind-1]) + func(ind-1,heights,dp);
        int two = Integer.MAX_VALUE;
        if(ind>1) two = Math.abs(heights[ind]-heights[ind-2]) + func(ind-2,heights,dp);

        return dp[ind] = Math.min(one,two);
    }
}
