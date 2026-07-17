class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid==null||grid[0][0]==1||grid[grid.length-1][grid[0].length-1]==1) return -1;

        if(grid.length-1==0 && grid[0].length-1 ==0 && grid[0][0]==0) return 1;

        int path=0;
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        Queue<int[]> queue=new LinkedList<>();

        queue.offer(new int[]{0,0});
        visited[0][0]=true;

        while(!queue.isEmpty()){
            int size=queue.size();
            path++;

            for(int i=0;i<size;i++){
                int[] current=queue.poll();
                int row=current[0];
                int column=current[1];
                int[] dr={-1,-1,1,1,-1,1,0,0};
                int[] dc={-1,1,-1,1,0,0,-1,1};

                for(int j=0;j<8;j++){
                    int nr=row+dr[j];
                    int nc=column+dc[j];

                   

                    if(nr>=0&&nr<grid.length &&
                       nc>=0&&nc<grid[0].length &&
                       grid[nr][nc]==0 && !visited[nr][nc]){
                        visited[nr][nc]=true;
                        queue.offer(new int[]{nr,nc});
                        
                    }
                    if(nr==grid.length-1 && nc==grid[0].length-1)
                      {path++;
                      return path;}
                    
                }
            }
        }
        return -1;
        
    }
}