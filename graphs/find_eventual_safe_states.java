class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {

        boolean[] visited=new boolean[graph.length];
        boolean[] inRecursion=new boolean[graph.length];
        List<Integer> result=new ArrayList<>();

        for(int i=0;i<graph.length;i++){
            if(visited[i]==false){
                if(dfs(i,visited,inRecursion,graph))
                  new ArrayList<>();
            }
        }
        for(int i=0;i<inRecursion.length;i++){
            if(inRecursion[i]==false){
                result.add(i);
            }
        }
        return result;
    }
     private boolean dfs(int course, boolean[] visited, boolean[] inRecursion,int[][] graph ){
        visited[course]=true;
        inRecursion[course]=true;
        for(int i=0;i<graph[course].length;i++){
            int neighbor=graph[course][i];
            if(visited[neighbor]==false){
                if(dfs(neighbor,visited,inRecursion,graph)){
                    return true;
                }
            }

            else if(visited[neighbor]== true && inRecursion[neighbor]==true){return true;}
        }
        inRecursion[course]=false;

    return false;
    }
}