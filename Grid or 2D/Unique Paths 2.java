/*
63. Unique Paths II

Task: Count the number of unique ways to move from the top-left corner to the bottom-right corner of a grid containing obstacles.

Moves Allowed:

Right (→)
Down (↓)

Obstacle Rule: Cells with value 1 are blocked and cannot be visited. Cells with value 0 are free.

Return: Total number of valid paths that avoid obstacles.

Example:
[[0,0,0],[0,1,0],[0,0,0]] → 2

Valid Paths:

R → R → D → D
D → D → R → R

DP Idea: Same as Unique Paths, but if a cell is an obstacle, the number of ways to reach it is 0.
*/

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m+1][n+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }

        return func(m-1,n-1,dp,m,n,obstacleGrid);
    }

    public int func(int i,int j,int[][] dp,int m , int n,int[][] obstacleGrid) {
        if(i<0 || i>=m || j<0 || j>=n || obstacleGrid[i][j] == 1)return 0;
        if(i==0 && j==0)return 1;
        if(dp[i][j]!=-1)return dp[i][j];

        int left = func(i,j-1,dp,m,n,obstacleGrid);
        int top = func(i-1,j,dp,m,n,obstacleGrid);

        return dp[i][j] = left+top;
    }
}
