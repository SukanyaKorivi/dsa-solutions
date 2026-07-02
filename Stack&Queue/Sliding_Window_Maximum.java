class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
 /*        if(nums.length == 1) return nums;
        Queue<Integer> findmax=new LinkedList<>();
        int max=Integer.MIN_VALUE;
        int[] result=new int[nums.length-k+1];

        for(int i=0;i<nums.length;i++){

            findmax.offer(nums[i]);
            max=Math.max(max,nums[i]);

            if(findmax.size() == k){
                result[i-k+1]=max;
                int popped=findmax.poll();
                if(findmax.isEmpty() ){
                    max=Integer.MIN_VALUE;
                }
                else if(!findmax.isEmpty() && popped == max){
                    max = Integer.MIN_VALUE;
                   for(int val : findmax) {
                       max = Math.max(max, val);
                  }
            }

        }
      
    }
      return result;

}
}*/



   if(nums.length == 1) return nums;

   Deque<Integer> deque=new ArrayDeque<>();
   int[] result=new int[nums.length-k+1];

   for(int i=0;i<nums.length;i++){

    while(!deque.isEmpty() && nums[i] > nums[deque.peekLast()] ){
        deque.pollLast();
    }
    deque.offerLast(i);
     if(deque.peekFirst()<(i-k+1)) deque.pollFirst();

    if(i>=k-1){
        result[i-k+1]=nums[deque.peekFirst()];
    }
   

   }
   return result;
    }
    }