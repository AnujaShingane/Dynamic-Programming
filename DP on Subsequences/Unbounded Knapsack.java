import java.util.Arrays;

public class Solution {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        int[][] dp = new int[n][w+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }

        return func(n-1,w,profit,weight,dp);
    }

    public static int func(int ind,int wt,int[] profit,int[] weight,int[][] dp) {
        if(ind==0){
            if(wt>=weight[ind] && wt%weight[ind]==0)return (wt/weight[ind])*profit[ind];
            return 0;
        }
        if(dp[ind][wt]!= -1)return dp[ind][wt];

        int take = Integer.MIN_VALUE;
        if(weight[ind]<=wt) take = profit[ind] + func(ind,wt-weight[ind],profit,weight,dp);

        int nottake = func(ind-1,wt,profit,weight,dp);

        return dp[ind][wt] = Math.max(take,nottake);
    }
}



import java.util.Arrays;

public class Solution {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        int[][] dp = new int[n][w+1];
        for(int i = 0 ; i <= w ; i++){
            if(i>=weight[0] && i%weight[0]==0)dp[0][i] = (i/weight[0])*profit[0];
            else dp[0][i] = 0;
        }

        for(int i = 1 ; i < n ; i++){
            for(int wt = 0 ; wt <= w ; wt++){
                int take = Integer.MIN_VALUE;
                if(weight[i]<=wt) take = profit[i] + dp[i][wt-weight[i]];

                int nottake = dp[i-1][wt];

                dp[i][wt] = Math.max(take,nottake);
            }
        }

        return dp[n-1][w];
    }
}
