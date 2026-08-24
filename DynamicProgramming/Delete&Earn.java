class Solution {
    public int deleteAndEarn(int[] nums) {

        int n=nums.length;
        int max=0;

      for(int i=0;i<n;i++){
        max=Math.max(max,nums[i]);
      }  

      int[] points=new int[max+1];

      for(int i=0;i<n;i++){
        points[nums[i]]+=nums[i];
      }

      int[] dp=new int[max+1];

      dp[0]=points[0];
      dp[1]=Math.max(points[0],points[1]);

      for(int i=2;i<=max;i++){
        dp[i]=Math.max(dp[i-1],dp[i-2]+points[i]);
      }
      return dp[max];
    }
}