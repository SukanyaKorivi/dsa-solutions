class Solution {
    public int[] topKFrequent(int[] nums, int k) {
     int[] result=new int[k];
     Map<Integer,Integer> freq=new HashMap<>();
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> freq.get(b) - freq.get(a));

     for(int i=0;i<nums.length;i++){
        freq.put(nums[i],freq.getOrDefault(nums[i],0)+1);

     }   

     pq.addAll(freq.keySet());

     for(int i=0;i<k;i++){
        result[i]=pq.poll();
     }
     return result;
     
    }
}