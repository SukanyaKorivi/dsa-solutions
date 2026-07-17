class Solution {
    public int orangesRotting(int[][] grid) {
        

      int fresh=0;
      int minutes=0;
      Queue<int[]> queue=new LinkedList<>();

      for(int r=0;r<grid.length;r++){
        for(int c=0;c<grid[0].length;c++){
            if(grid[r][c]==2){queue.offer(new int[]{r,c});}
            if(grid[r][c]==1){fresh++;}
        }
      }  
      if(fresh==0)return 0;

      while(!queue.isEmpty()){
        int size=queue.size();

        for(int i=0;i<size;i++){
            int[] current=queue.poll();
            int row=current[0];
            int column=current[1];

            int[] dr={-1,1,0,0};
            int[] dc={0,0,-1,1};
            for(int j=0;j<4;j++){
                int nr=row+dr[j];
                int nc=column+dc[j];

                if(nr>=0&&nr<grid.length  && 
                   nc>=0&&nc<grid[0].length &&
                   grid[nr][nc]==1){
                    grid[nr][nc]=2;
                     fresh--;
                    queue.offer(new int[]{nr,nc});
                   
                   }
            }
        }
        if(!queue.isEmpty())minutes++;
      }
      if(fresh!=0)return -1;
      return minutes;
    }
}