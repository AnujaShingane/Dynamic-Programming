/*
64. Minimum Path Sum

Task: Find the minimum sum path from the top-left cell to the bottom-right cell in a grid.

Moves Allowed: Right (→) or Down (↓) only.

Return: The minimum possible sum of all values along the chosen path.

Example:
[[1,3,1],[1,5,1],[4,2,1]] → 7
Path: 1 → 3 → 1 → 1 → 1

This format is concise and ideal for a GitHub problem notes repository. Send the next problem.
*/

class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n+1][m+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }

        return func(n-1,m-1,grid,dp);
    }

    public int func(int i, int j , int[][] grid,int[][] dp){
        if(i==0 && j==0)return grid[i][j];
        if(i<0 || j<0)return (int)(1e9);
        if(dp[i][j] != -1)return dp[i][j];

        int up = grid[i][j] + func(i-1,j,grid,dp);
        int left = grid[i][j] + func(i,j-1,grid,dp);

        return dp[i][j] = Math.min(up,left);
    }
}
