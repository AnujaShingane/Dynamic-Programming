class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m-1).size();
        int[][] dp = new int[m+1][n+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }

        return func(0,0,triangle,m,n,dp);
    }

    public int func(int i,int j ,List<List<Integer>> triangle,int m , int n,int[][] dp){
        if(i==n-1)return triangle.get(i).get(j);
        if(dp[i][j] != -1)return dp[i][j];

        int diag = triangle.get(i).get(j) + func(i+1,j+1,triangle,m,n,dp);
        int down = triangle.get(i).get(j) + func(i+1,j,triangle,m,n,dp);

        return dp[i][j] = Math.min(diag,down);
    }
}

public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m-1).size();
        int[][] dp = new int[m][m];

        for(int j = 0 ; j < m ; j++){
            dp[m-1][j] = triangle.get(m-1).get(j);
        }

        for(int i = m-2 ; i >= 0 ; i--){
            for(int j = 0 ; j <= i ; j++){
                int diag = triangle.get(i).get(j) + dp[i+1][j+1];
                int down = triangle.get(i).get(j) + dp[i+1][j];

                dp[i][j] = Math.min(diag,down);
            }
        }

        return dp[0][0];
    }
