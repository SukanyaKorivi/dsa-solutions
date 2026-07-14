class Solution {
    public int minSubArrayLen(int target, int[] nums) {
      int left=0;int right=0;
      int sum=0;
      int minlength=Integer.MAX_VALUE;
      while(right<nums.length){
        sum+=nums[right++];
        while(sum>= target){
            minlength=Math.min(minlength,right-left);
            sum-=nums[left++];
        }
      }
      return minlength==Integer.MAX_VALUE?0:minlength;
    }
}