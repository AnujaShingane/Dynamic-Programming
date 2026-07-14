class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);

        return func(n-1,nums,dp);
    }

    public int func(int ind,int[] nums,int[] dp) {
        if(ind<0)return 0;
        if(dp[ind]!=-1)return dp[ind];

        int take = nums[ind] + func(ind-2,nums,dp);
        int nottake = func(ind-1,nums,dp);

        return dp[ind] = Math.max(take,nottake);
    }
}


class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        
        for(int i = 1 ; i < n ; i++){
            int take = nums[i];
            if(i>1) take += dp[i-2];
            int nottake = dp[i-1];

            dp[i] = Math.max(take,nottake);
        }

        return dp[n-1];
    }
}
