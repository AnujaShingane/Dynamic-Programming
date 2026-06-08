class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }

        return func(0,-1,nums,dp);
    }

    public int func(int ind,int prev,int[] nums,int[][] dp) {
        if(ind==nums.length)return 0;
        if(dp[ind][prev+1]!=-1)return dp[ind][prev+1];

        int nottake = func(ind+1,prev,nums,dp);
        int take = 0;
        if(prev==-1 || nums[ind]>nums[prev]) take = 1 + func(ind+1,ind,nums,dp);

        return dp[ind][prev+1] = Math.max(take,nottake);
    }
}



public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        
        for(int i = n-1 ; i >= 0 ; i--){
            for(int prev = i-1 ; prev >= -1 ; prev--){
                int nottake = dp[i+1][prev+1];
                int take = 0;
                if(prev==-1 || nums[i]>nums[prev]) take = 1 + dp[i+1][i+1];

                dp[i][prev+1] = Math.max(take,nottake);
            }
        }

        return dp[0][0];
    }
