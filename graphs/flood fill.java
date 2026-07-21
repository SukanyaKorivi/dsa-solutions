class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

       if(image[sr][sc]==color) return image;

       int prev=image[sr][sc];
       
        dfs(image,sr,sc,color,prev);
        
        return image;
    }
    private void dfs(int[][] image,int r,int c,int color,int prev){
        if(r<0||r>=image.length||c<0||c>=image[0].length||image[r][c]!=prev)return;
        
        image[r][c]=color;

        int[] dr={-1,1,0,0};
        int[] dc={0,0,-1,1};

        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];

            
                dfs(image,nr,nc,color,prev);
               }
        }
    }