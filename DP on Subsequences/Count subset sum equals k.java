import java.util.*;
import java.io.*;

public class Solution {
    public static int findWays(int num[], int tar) {
        int n = num.length;
        int[][] dp = new int[n][tar+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }

        return func(n-1,num,tar,dp);
    }

    public static int func(int ind,int[] num,int tar,int[][] dp) {
        if(ind==0){
            if(tar==0 && num[0]==0)return 2;
            if(tar==0 || num[0]==tar)return 1;
            return 0;
        }
        if(dp[ind][tar]!=-1)return dp[ind][tar];

        int nottake = func(ind-1,num,tar,dp);
        int take = 0;
        if(num[ind]<=tar)take = func(ind-1,num,tar-num[ind],dp);

        return dp[ind][tar] = nottake + take;
    }
}
