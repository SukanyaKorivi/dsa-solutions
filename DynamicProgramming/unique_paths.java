//Memoization

class Solution {
    public int uniquePaths(int m, int n) {
      int[][] dp=new int[m][n];

      return solve(m-1,n-1,dp);
    }
    private int solve(int i,int j,int[][] dp){
        if(i==0 || j==0) return 1;
        if(dp[i][j] !=0){
            return dp[i][j];
        }

        dp[i][j]=solve(i-1,j,dp)+solve(i,j-1,dp);

        return dp[i][j];
    }
}


//Tabulation


class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0||j==0){
                    dp[i][j]=1;
                }
                else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}