class Solution {
    int profit = 0;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }

        return func(0,1,prices,dp);
    }

    public int func(int ind,int buy,int[] prices,int[][] dp){
        if(ind==prices.length) return 0;
        if(dp[ind][buy]!=-1)return dp[ind][buy];

        if(buy==1){
            profit = Math.max(-prices[ind]+func(ind+1,0,prices,dp),
                                0 + func(ind+1,1,prices,dp));
        }
        else{
            profit = Math.max(prices[ind]+func(ind+1,1,prices,dp),
                                0 + func(ind+1,0,prices,dp));
        }

        return dp[ind][buy] = profit;
    }
}

class Solution {
    int profit = 0;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        dp[n][0] = dp[n][1] = 0;

        for(int i = n-1 ; i >= 0 ; i--){
            for(int j = 0 ; j <= 1 ; j++){
                if(j==1){
                    profit = Math.max(-prices[i]+dp[i+1][0],
                                        0 + dp[i+1][1]);
                }
                else{
                    profit = Math.max(prices[i]+dp[i+1][1],
                                        0 + dp[i+1][0]);
                }
                dp[i][j] = profit;
            }
        }

        return dp[0][1];
    }

    public int func(int ind,int buy,int[] prices,int[][] dp){
        if(ind==prices.length) return 0;
        if(dp[ind][buy]!=-1)return dp[ind][buy];

        if(buy==1){
            profit = Math.max(-prices[ind]+func(ind+1,0,prices,dp),
                                0 + func(ind+1,1,prices,dp));
        }
        else{
            profit = Math.max(prices[ind]+func(ind+1,1,prices,dp),
                                0 + func(ind+1,0,prices,dp));
        }

        return dp[ind][buy] = profit;
    }
}


class Solution {
    int profit = 0;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] ahead = new int[n+1];
        int[] cur = new int[2];

        for(int i = n-1 ; i >= 0 ; i--){
            for(int j = 0 ; j <= 1 ; j++){
                if(j==1){
                    profit = Math.max(-prices[i]+ahead[0],
                                        0 + ahead[1]);
                }
                else{
                    profit = Math.max(prices[i]+ahead[1],
                                        0 + ahead[0]);
                }
                cur[j] = profit;
            }
            ahead = cur;
        }

        return ahead[1];
    }
}
