class Solution {
    public int numIslands(char[][] grid) {
        if(grid==null||grid.length==0)return 0;

        int islands=0;
        int rows=grid.length;
        int columns=grid[0].length;
        boolean[][] visited=new boolean[rows][columns];


        for(int r=0;r<grid.length;r++){
            for(int c=0;c<grid[0].length;c++){
                if(grid[r][c]=='1'&&!visited[r][c]){
                    islands++;
                    bfs(grid,visited,r,c);
                }
            }
        }
        return islands;
    }

    private void bfs(char[][] grid,boolean[][] visited,int row,int column){
        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[]{row,column});

        visited[row][column]=true;

        int[] dr={-1,1,0,0};
        int[] dc={0,0,-1,1};


       while(!queue.isEmpty()){

        int[] current=queue.poll();
        int r=current[0];
        int c=current[1];

        for(int i=0;i<4;i++){

            int nr=r+dr[i];
            int nc=c+dc[i];

            if(nr>=0&&nr<grid.length && nc>=0&&nc<grid[0].length && grid[nr][nc]=='1' && !visited[nr][nc]){
                visited[nr][nc]=true;
                queue.offer(new int[]{nr,nc});
            }

        }

       }
    }

}