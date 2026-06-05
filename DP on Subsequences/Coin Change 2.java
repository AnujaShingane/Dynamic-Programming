class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }

        return func(n-1,amount,coins,dp);
    }

    public int func(int ind,int amount,int[] coins,int[][] dp) {
        if(ind==0){
            if(amount%coins[0]==0)return 1;
            return 0;
        }
        if(dp[ind][amount]!=-1)return dp[ind][amount];

        int take = 0;
        if(amount>=coins[ind]) take = func(ind,amount-coins[ind],coins,dp);

        int nottake = func(ind-1,amount,coins,dp);

        return dp[ind][amount] = take + nottake;
    }
}

public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        
        for(int amt = 0 ; amt <= amount ; amt++){
            if(amt%coins[0]==0)dp[0][amt] = 1;
        }

        for(int i = 1 ; i < n ; i++){
            for(int amt = 0 ; amt <= amount ; amt++){
                int take = 0;
                if(amt>=coins[i]) take = dp[i][amt-coins[i]];

                int nottake = dp[i-1][amt];

                dp[i][amt] = take + nottake;
            }
        }

        return dp[n-1][amount];
    }
