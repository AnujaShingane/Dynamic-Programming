/*
931. Minimum Falling Path Sum

Task: Find the minimum sum of a falling path from the first row to the last row of the matrix.

Starting Point: Any cell in the first row.

Moves Allowed: From (i, j), move to:

(i + 1, j - 1) (down-left)
(i + 1, j) (down)
(i + 1, j + 1) (down-right)

Return: The minimum possible sum among all falling paths.

Example:
[[2,1,3],[6,5,4],[7,8,9]] → 13
Path: 1 → 4 → 8

DP Idea: For each cell, take its value plus the minimum of the three reachable cells in the next row. The answer is the minimum value obtainable from any cell in the first row.
*/

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < n ;i++){
            min = Math.min(min,func(m-1,i,matrix,dp));
        }
        return min;
    }

    public int func(int i , int j , int[][] matrix,int[][] dp){
        if(j<0 || j>=matrix[0].length)return (int)(1e9);
        if(i==0)return matrix[0][j];
        if(dp[i][j] != -1)return dp[i][j];

        int up = matrix[i][j] + func(i-1,j,matrix,dp);
        int left = matrix[i][j] + func(i-1,j-1,matrix,dp);
        int right = matrix[i][j] + func(i-1,j+1,matrix,dp);

        int min = Math.min(left,right);
        return dp[i][j] = Math.min(up,min);
    }
}
