class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
    List<List<Integer>> answer=new ArrayList<>();
    
    int m = heights.length;
    int n = heights[0].length;

    boolean[][] pacific = new boolean[m][n];
    boolean[][] atlantic = new boolean[m][n]; 

    
    for (int c = 0; c < n; c++) {
        dfs(heights, 0, c, pacific);
    }


    for (int r = 0; r < m; r++) {
        dfs(heights, r, 0, pacific);
    }

    for (int c = 0; c < n; c++) {
        dfs(heights, m - 1, c, atlantic);
    }


    for (int r = 0; r < m; r++) {
        dfs(heights, r, n - 1, atlantic);
    }
      for(int r=0;r<heights.length;r++){
        for(int c=0;c<heights[0].length;c++){
            if (pacific[r][c] && atlantic[r][c]) {
                answer.add(Arrays.asList(r, c));
            }
        }
      }
      return answer;
    }

    private void dfs(int[][] heights,int r ,int c, boolean[][] ocean){
        if(ocean[r][c])return;
        ocean[r][c]=true;
        int[] dr={-1,1,0,0};
        int[] dc={0,0,-1,1};

        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];
            if(nr>=0&&nr<heights.length&&nc>=0&&nc<heights[0].length&&heights[nr][nc]>=heights[r][c]){
                dfs(heights,nr,nc,ocean);
            }
        }
    }
}