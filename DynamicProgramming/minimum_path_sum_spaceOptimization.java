class Solution {
    public int minPathSum(int[][] grid) {
      int[] dp=new int[grid[0].length];
      for(int i=0;i<grid.length;i++){
        for(int j=0;j<grid[0].length;j++){
            if(i==0 && j==0) dp[j]=grid[i][j];
            else if(i==0){dp[j]=grid[i][j]+dp[j-1];}
            else if(j==0){dp[j]=grid[i][j]+dp[j];}
            else{
                dp[j]=grid[i][j]+Math.min(dp[j],dp[j-1]);
            }
        }
      }  
      return dp[grid[0].length-1];
    }
}