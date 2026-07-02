class Solution {
    public int maxArea(int[] height) {
        int area=0;
      int left=0;
      int right=height.length-1;

      while(left<right){
        if(height[left]<height[right]){
            area=Math.max(area,height[left]*(right-left));
            left++;
        }
        else if(height[left]>height[right]){
             area=Math.max(area,height[right]*(right-left));
             right--;
        }
        else{
            area=Math.max(area,height[left]*(right-left));
            if(height[left+1]>height[right-1]) right--;
            else left++;
        }
      }
      return area;  
    }
}