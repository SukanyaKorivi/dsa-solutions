class Solution {
    public int findCircleNum(int[][] isConnected) {
       if(isConnected==null) return 0;

       boolean[] visited=new boolean[isConnected.length];
       int result=0;

       for(int r=0;r<isConnected.length;r++){

            if(!visited[r]){
                result++;
                dfs(isConnected,visited,r);
            }
       
       }  
        return result;
    }
    private void dfs(int[][] isConnected,boolean[] visited,int i){
        visited[i]=true;

        for(int j=0;j<isConnected[0].length;j++){
            if(isConnected[i][j]==1 && !visited[j]){
                dfs(isConnected,visited,j);
            }
        }
    }
}