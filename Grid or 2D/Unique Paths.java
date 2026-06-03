/*
62. Unique Paths

Task: Count the number of unique ways for a robot to move from the top-left corner to the bottom-right corner of an m × n grid.

Moves Allowed:

Right (→)
Down (↓)

Return: Total number of distinct paths.

Example:
m = 3, n = 2 → 3

Paths:

R → D → D
D → D → R
D → R → D

DP Idea: The number of ways to reach a cell is the sum of the ways to reach the cell above it and the cell to its left.
*/

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }

        return func(m-1,n-1,dp,m,n);
    }

    public int func(int i,int j,int[][] dp,int m , int n) {
        if(i<0 || i>=m || j<0 || j>=n)return 0;
        if(i==0 && j==0)return 1;
        if(dp[i][j]!=-1)return dp[i][j];

        int left = func(i,j-1,dp,m,n);
        int top = func(i-1,j,dp,m,n);

        return dp[i][j] = left+top;
    }
}
