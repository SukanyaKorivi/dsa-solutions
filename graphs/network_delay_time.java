class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        List<List<int[]>> adj=new ArrayList<>();

        for(int i=0;i<n+1;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<times.length;i++){
          int[] j=times[i];
          adj.get(j[0]).add(new int[]{j[1],j[2]});
        }
        
       int[] dist=new int[n+1];
       Arrays.fill(dist,Integer.MAX_VALUE);
       dist[k]=0;
       dist[0]=0;

       PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);

       pq.offer(new int[]{0,k});
       while(!pq.isEmpty()){
        int[] curr=pq.poll();
        int currDist=curr[0];
        int node=curr[1];
        if(currDist > dist[node]) continue;

        for(int[] nei:adj.get(node)){
            int next=nei[0];
            int weight=nei[1];

            if(currDist + weight < dist[next]){
                dist[next]=currDist + weight;
                pq.offer(new int[]{dist[next],next});
            }
        }
       }

       int max = 0;

for(int i=1;i<=n;i++){

    if(dist[i]==Integer.MAX_VALUE)
        return -1;

    max = Math.max(max, dist[i]);
}

return max;
    }
}