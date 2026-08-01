class Solution {
    public int makeConnected(int n, int[][] connections) {

        if(connections.length<n-1) return -1;


        int[] parent=new int[n];
        int[] rank=new int[n];
        int components=0;
        
             

        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=0;
        }

        for(int[] edge:connections){
            int u=edge[0];
            int v=edge[1];
            unionfind(u,v,parent,rank);
       
            
        }
      
        for(int i=0;i<n;i++){
            if(parent[i]==i)components++;
        }

  
        return components-1;
       
    }

    private int find(int x,int[] parent){
        if(parent[x] != x){
            parent[x]=find(parent[x],parent);
        }
        return parent[x];
    }
    private void unionfind(int u,int v,int[] parent,int[] rank){
        int rootu=find(u,parent);
        int rootv=find(v,parent);

        if(rootu==rootv)return;

        if(rank[rootu]<rank[rootv]){parent[rootu]=rootv;}
        else if(rank[rootu]>rank[rootv]){parent[rootv]=rootu;}
        else{
            parent[rootv]=rootu;
            rank[rootu]++;
        }
        return;
    }
}  