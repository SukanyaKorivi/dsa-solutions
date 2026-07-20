class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        int result=0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
            if(grid[i][j]=='1' && !visited[i][j]){
                result++;
                dfs(grid,visited,i,j);
            }
            }
        }
     return result;   
    }
    private void dfs(char[][] grid,boolean[][] visited,int i,int j){
        visited[i][j]=true;

        int[] dr={-1,1,0,0};
        int[] dc={0,0,-1,1};

        for(int k=0;k<4;k++){
            int nr=i+dr[k];
            int nc=j+dc[k];

            if(nr>=0&&nr<grid.length &&
               nc>=0&&nc<grid[0].length &&
               grid[nr][nc]=='1' && !visited[nr][nc]){

                
                dfs(grid,visited,nr,nc);
                
            }
        }
    }
}