class Solution {
    public int minCostConnectPoints(int[][] points) {
        List<int[]> edges=new ArrayList<>();
        int cost=0;
        int edgesused=0;

        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                int[] u=points[i];
                int[] v=points[j];
                int wt=Math.abs(u[0]-v[0])+Math.abs(u[1]-v[1]);
                edges.add(new int[]{i,j,wt});
            }
        }

        Collections.sort(edges,(a,b)->a[2]-b[2]);

        int[] parent=new int[points.length];
        int[] rank=new int[points.length];

        for(int i=0;i<points.length;i++){
            parent[i]=i;
            rank[i]=0; 
        }
        for(int[] edge:edges){
            
            int rootu=find(edge[0],parent);
            int rootv=find(edge[1],parent);

            if(rootu!=rootv){
                cost+=edge[2];
                union(rootu, rootv, parent, rank);
                edgesused++;
            }
            
            if(edgesused==points.length-1){break;}
        }
        return cost;
        
    }

    private int find(int x, int[] parent){
        if(parent[x]!=x){
            parent[x]=find(parent[x],parent);
        }
        return parent[x];
    }

    private void union(int rootu,int rootv, int[] parent, int[] rank){
            if (rank[rootu] < rank[rootv]) {
        parent[rootu] = rootv;
    }
    else if (rank[rootu] > rank[rootv]) {
        parent[rootv] = rootu;
    }
    else {
        parent[rootv] = rootu;
        rank[rootu]++;
    }
    }
}