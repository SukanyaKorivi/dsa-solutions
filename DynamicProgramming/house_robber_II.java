class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1)return nums[0];
        if(n==2)return Math.max(nums[0],nums[1]);

        int x=helper(nums,0,n-2);
        int y=helper(nums,1,n-1);

        return Math.max(x,y);
        
    }
    private int helper(int[] nums,int start,int end){
        
        int prev2=nums[start];
        int prev1=Math.max(nums[start],nums[start+1]);

        for(int i=start+2;i<=end;i++){
            int current=Math.max(prev1,prev2+nums[i]);
            prev2=prev1;
            prev1=current;
        }
        return prev1;
    }
}