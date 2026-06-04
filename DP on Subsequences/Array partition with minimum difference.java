import java.util.*;

public class Solution {
    public static int minSubsetSumDifference(int []arr, int n) {
        int sum = 0;
        for(int i = 0 ; i < n ; i++){
            sum+=arr[i];
        }

        boolean[][] dp = new boolean[n][sum+1];
        
        for(int i = 0 ; i < n ; i++){
            dp[i][0] = true;
        }
        if(arr[0] <= sum) dp[0][arr[0]] = true;
        
        for(int i = 1 ; i < n ; i++){
            for(int target = 1 ; target <= sum ; target++){
                boolean nottake = dp[i-1][target];
                boolean take = false;
                if(target>=arr[i])take = dp[i-1][target-arr[i]];
                
                dp[i][target] = take || nottake;
            }
        }

        int mini = (int)(1e9);
        for(int i = 0 ; i <= sum/2 ; i++){
            if(dp[n-1][i]==true){
                mini = Math.min(mini,Math.abs(sum-2*i));
            }
        }
        
        return mini;
    }
}
