
class Solution {
    public int countWays(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        
        return f(n,dp);
    }
    
    public int f(int ind,int[] dp) {
        if(ind==0)return 1;
        if(ind==1)return 1;
        if(dp[ind]!=-1)return dp[ind];
        
        int one = f(ind-1,dp);
        int two = f(ind-2,dp);
        
        return dp[ind] = one+two;
    }
}


class Solution {
    public int countWays(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i = 2 ; i <= n ; i++){
            int one = dp[i-1];
            int two = dp[i-2];
            
            dp[i] = one+two;
        }
        
        return dp[n];
    }
}
