class Solution {
    public int[][] updateMatrix(int[][] mat) {
    if(mat==null)return mat;

    Queue<int[]> queue=new LinkedList<>();
    boolean[][] visited=new boolean[mat.length][mat[0].length];
    int[][] result=new int[mat.length][mat[0].length];
    int path=0;

      for(int r=0;r<mat.length;r++){
        for(int c=0;c<mat[0].length;c++){
            if(mat[r][c]==0){
                queue.offer(new int[]{r,c});
                visited[r][c]=true;
            }
        }
      }  
      while(!queue.isEmpty()){
        int size=queue.size();
        path++;
        for(int i=0;i<size;i++){
            int[] current=queue.poll();
            int row=current[0];
            int column=current[1];
            int[] dr={-1,1,0,0};
            int[] dc={0,0,-1,1};

            for(int j=0;j<4;j++){
                int nr=row+dr[j];
                int nc=column+dc[j];
                if(nr>=0&&nr<mat.length &&
                   nc>=0&&nc<mat[0].length &&
                   !visited[nr][nc]){
                    result[nr][nc]=path;
                    visited[nr][nc]=true;
                    queue.offer(new int[]{nr,nc});
                   }
            }
        }
      }
      return result;
    }
}