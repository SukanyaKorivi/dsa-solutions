class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
     Arrays.sort(nums);
     int count=0;int maxi=0;

     for(int i=0;i<nums.length-1;i++){
        if(nums[i]==nums[i+1]) continue;
        else if(nums[i]==nums[i+1]-1) {
            count++;
            maxi=Math.max(maxi,count);}
        else count=0;
     }   
     return maxi+1;
    }
}
