// Problem: Two Sum (#1)
// Approach: HashMap O(n) lookup
// Time: O(n) | Space: O(n)


class Solution {
    public int[] twoSum(int[] nums, int target) {
       Map<Integer,Integer> unique=new HashMap<>();

       for(int i=0;i<nums.length;i++){
        int complement=target-nums[i];
        if(unique.containsKey(complement) && unique.get(complement) != i){
            return new int[]{i,unique.get(complement)};
        }
        unique.put(nums[i],i);
       } 
       return new int[0];
    }
}