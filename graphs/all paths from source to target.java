class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
     List<List<Integer>> answer=new ArrayList<>();
      if(graph==null) return answer;

     List<Integer> path=new ArrayList<>();
     int destination=graph.length-1;

     int node=0;
     dfs(graph,answer,path,node,destination);   
    
    return answer;
}
private void dfs(int[][] graph,List<List<Integer>> answer,List<Integer> path, int node,int destination){
 path.add(node);

 if(node==destination){
    answer.add(new ArrayList<>(path));
    
 }

 for(int i=0;i<graph[node].length;i++){
    int neighbor=graph[node][i];
    dfs(graph,answer,path,neighbor,destination);
 }

 path.remove(path.size()-1);
}
}