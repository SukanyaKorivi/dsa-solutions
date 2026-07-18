class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> list=new ArrayList<>(n);
        boolean[] visited=new boolean[n];

        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int index=edges[i][0];
            int value=edges[i][1];
            int index2=edges[i][1];
            int value2=edges[i][0];

            list.get(index).add(value);
            list.get(index2).add(value2);
        }
      
       
       return dfs(list,visited,source,destination);

    }

    private boolean dfs(List<List<Integer>> list,boolean[] visited,int source,int destination){
        if(source==destination) return true;
        visited[source]=true;

        for(int numbers:list.get(source)){
            if(!visited[numbers]){
              
            boolean result= dfs(list,visited,numbers,destination);
              if(result==true)return result;
            }
        }
        return false;
    }
}