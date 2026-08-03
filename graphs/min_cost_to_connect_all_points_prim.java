class Solution {
    public int minCostConnectPoints(int[][] points) {
        
        List<List<int[]>> adj=new ArrayList<>();
        
        
        for(int i=0;i<points.length;i++){
    adj.add(new ArrayList<>());
}

        for(int i=0;i<points.length;i++){
            
            for(int j=i+1;j<points.length;j++){
                int[] u=points[i];
                int[] v=points[j];
                int wt=Math.abs(u[0]-v[0])+Math.abs(u[1]-v[1]);
                adj.get(i).add(new int[]{j,wt});
                adj.get(j).add(new int[]{i,wt});
            }
        }


        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        boolean[] visited = new boolean[points.length];

        pq.offer(new int[]{0,0});
        int cost = 0;

        while(!pq.isEmpty()){

            int[] curr = pq.poll();
            int wt = curr[0];

            int node = curr[1];

            if(visited[node])continue;
            visited[node]=true;
          
            cost+=wt;
            for(int[] nei : adj.get(node)){

                int next = nei[0];
                int edgeWeight = nei[1];

                 if(!visited[next]){

                    pq.offer(new int[]{edgeWeight,next});

                }

            }
            

        }

    return cost;
    }
}