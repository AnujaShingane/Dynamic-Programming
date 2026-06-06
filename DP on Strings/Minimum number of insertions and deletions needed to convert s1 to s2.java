// User function Template for Java

class Solution {
    public int minOperations(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        
        int ans = (n+m)-2*lcs(s1,s2);
        return ans;
    }
    
    public int lcs(String text1, String text2) {
    int n = text1.length();
    int m = text2.length();

    int[][] dp = new int[n + 1][m + 1];

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                dp[i][j] = 1 + dp[i - 1][j - 1];
            } else {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
    }

    return dp[n][m];
}
}

// n-lcs + m-lcs
// 4-2 + 3-2
// 13-5 + 5-5
// n+m-2*lcs
