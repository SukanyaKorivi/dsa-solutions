class Solution {
    public int[] searchRange(int[] nums, int target) {
      int left=0;
      int right=nums.length-1;

      while(left<=right){
        int mid=left+(right-left)/2;

        if(nums[mid] == target){
            int fo=mid;
            int lo=mid;

            while(left<mid){
                if(nums[left] == target) {
                    fo=left;
                    break;}
                else left++; 
            }
            while(mid<right){
                
                if(nums[right]==target){
                  lo=right;
                  break;
                }
                else right--;
            }
            return new int[]{fo,lo};
        }
        
        else if(nums[mid] < target){ left=mid+1;}
        else {right = mid-1;}
      }  
      return new int[]{-1,-1};
    }
}