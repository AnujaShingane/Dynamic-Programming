class Solution {
    public int cutRod(int[] price) {
        int n = price.length;
        int[][] dp = new int[n][n+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        
        return func(n-1,n,price,dp);
    }
    
    public int func(int ind,int n,int[] price,int[][] dp) {
        if(ind == 0){
            return n*price[0];
        }
        if(dp[ind][n]!=-1)return dp[ind][n];
        
        int take = Integer.MIN_VALUE;
        int rodlength = ind+1;
        if(rodlength <= n) take = price[ind] + func(ind,n-rodlength,price,dp);
        
        int nottake = func(ind-1,n,price,dp);
        
        return dp[ind][n] = Math.max(take,nottake);
    }
}

public int cutRod(int[] price) {
        int n = price.length;
        int[][] dp = new int[n][n+1];
        
        for(int i = 0 ; i <= n ; i++){
            dp[0][i] = i*price[0];
        }
        
        for(int i = 1 ; i < n ; i++){
            for(int rl = 0 ; rl <= n ; rl++){
                int take = Integer.MIN_VALUE;
                int rodlength = i+1;
                if(rodlength <= rl) take = price[i] + dp[i][rl-rodlength];
                
                int nottake = dp[i-1][rl];
                
                dp[i][rl] = Math.max(take,nottake);
            }
        }
        
        return dp[n-1][n];
    }
