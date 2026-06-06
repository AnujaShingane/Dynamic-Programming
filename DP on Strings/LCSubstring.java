class Solution {
    public int longCommSubstr(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n+1][m+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        
        int maxlen = 0;
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                maxlen = Math.max(maxlen,func(i,j,s1,s2,dp));
            }
        }

        return maxlen;
    }
    
    public int func(int ind1,int ind2,String text1,String text2,int[][] dp) {
        if(ind1<0 || ind2<0)return 0;
        if(dp[ind1][ind2]!=-1)return dp[ind1][ind2];

        int take = 0;
        if(text1.charAt(ind1)==text2.charAt(ind2)) return dp[ind1][ind2] = 1 + func(ind1-1,ind2-1,text1,text2,dp);

        return dp[ind1][ind2] = 0;
    }
}

class Solution {
    public int longCommSubstr(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
    
        int[][] dp = new int[n + 1][m + 1];
        int maxlen = 0;
    
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    maxlen = Math.max(maxlen,dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
    
        return maxlen;
    }
}
