class Solution {
    public int maxAreaOfIsland(int[][] grid) {

        int max_area=0;

        for(int r=0;r<grid.length;r++){
            for(int c=0;c<grid[0].length;c++){
                if(grid[r][c]==1){
                   
                    max_area=Math.max(max_area,dfs(grid,r,c));
                }
            }
        }
        return max_area;
    }
    private int dfs(int[][] grid,int r,int c){
        
        if(grid[r][c]==0)return 0;
        grid[r][c]=0;
        
         int area=1;
        int[] dr={-1,1,0,0};
        int[] dc={0,0,-1,1};

        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];
            if(nr>=0&&nr<grid.length&&nc>=0&&nc<grid[0].length&&grid[nr][nc]==1){
            area+=dfs(grid,nr,nc);
            }
        }
        return area;
    }
}