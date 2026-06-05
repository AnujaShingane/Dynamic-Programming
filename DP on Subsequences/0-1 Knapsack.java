class Solution {
    public int knapsack(int W, int val[], int wt[]) {
        int n = val.length;
        int[][] dp = new int[n][W+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        
        return func(n-1,W,val,wt,dp);
    }
    
    public int func(int ind,int W,int[] val,int[] wt,int[][] dp) {
        if(ind==0){
            if(wt[ind]<=W)return val[ind];
            return 0;
        }
        if(dp[ind][W]!=-1)return dp[ind][W];
        
        int take = (int)(-1e9);
        if(wt[ind]<=W)take = val[ind] + func(ind-1,W-wt[ind],val,wt,dp);
        int nottake = func(ind-1,W,val,wt,dp);
        
        return dp[ind][W] = Math.max(take,nottake);
    }
}
class Solution {
    public int knapsack(int W, int val[], int wt[]) {
        int n = val.length;
        int[][] dp = new int[n][W+1];
        
        for(int w = wt[0] ; w <= W ; w++){
            if(wt[0]<=W)dp[0][w] = val[0];   
        }
        
        for(int i = 1 ; i < n ; i++){
            for(int w = 0 ; w <= W; w++){
                int take = (int)(-1e9);
                if(wt[i]<=w)take = val[i] + dp[i-1][w-wt[i]];
                int nottake = dp[i-1][w];
                
                dp[i][w] = Math.max(take,nottake);
            }
        }
        
        return dp[n-1][W];
    }
}
