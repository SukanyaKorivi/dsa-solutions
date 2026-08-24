class Solution {
    public int minPathSum(int[][] grid) {
        int i=grid.length;
        int j=grid[0].length;
        int[][] dp=new int[i][j];

        return solve(i-1,j-1,dp,grid);
    }
    private int solve(int i,int j,int[][] dp,int[][] grid){
        if(i==0 && j==0)return grid[0][0];

        if(dp[i][j] !=0){
            return dp[i][j];
        }
         if (i == 0) {
            dp[i][j] = grid[i][j] + solve(i, j - 1, dp, grid);
        } 
        else if (j == 0) {
            dp[i][j] = grid[i][j] + solve(i - 1, j, dp, grid);
        } 
        else{
            dp[i][j]=grid[i][j]+Math.min(solve(i-1,j,dp,grid),solve(i,j-1,dp,grid));
        }
        return dp[i][j];
    }
}