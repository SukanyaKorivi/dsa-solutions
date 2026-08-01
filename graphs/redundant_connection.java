class Solution {
    public int[] findRedundantConnection(int[][] edges) {

        int[] parent=new int[edges.length+1];
        int[] rank=new int[edges.length];
        

        for(int i=0;i<edges.length;i++){
            parent[i]=i;
            rank[i]=0;
        }

        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            if(unionfind(u,v,parent,rank)){
                return new int[]{u,v};
            }

        }
        return new int[0];
    }

    private int find(int x,int[] parent){
        if(parent[x] != x){
            parent[x]=find(parent[x],parent);
        }
        return parent[x];
    }
    private boolean unionfind(int u,int v,int[] parent,int[] rank){
        int rootu=find(u,parent);
        int rootv=find(v,parent);

        if(rootu==rootv)return true;

        if(rank[rootu]<rank[rootv]){parent[rootu]=rootv;}
        else if(rank[rootu]>rank[rootv]){parent[rootv]=rootu;}
        else{
            parent[rootv]=rootu;
            rank[rootu]++;
        }
        return false;
    }
}