class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0 ; i < n ; i++){
            sum += nums[i];
        }
        boolean[][] dp = new boolean[n][sum+1];

        for(int i = 0 ; i < n ; i++){
            dp[i][0] = true;
        }
        if(nums[0]<=sum)dp[0][nums[0]] = true;

        for(int i = 1 ; i < n ; i++){
            for(int target = 0 ; target <= sum ; target++){
                boolean take = false;
                if(nums[i]<=target)take = dp[i-1][target-nums[i]];
                boolean nottake = dp[i-1][target];

                dp[i][target] = take || nottake;
            }
        }

        int mini = Integer.MAX_VALUE;
        for(int i = 0 ; i <= sum/2 ; i++){
            if(dp[n-1][i]){
                int s1 = i;
                int s2 = sum-i;
                mini = Math.min(mini,Math.abs(s1-s2));
            }
        }

        return mini;
    }
}
