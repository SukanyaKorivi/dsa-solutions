class Solution {
    public void solve(char[][] board) {

     for(int r=0;r<board.length;r++){
        for(int c=0;c<board[0].length;c++){
            if(r==0||r==board.length-1||c==0||c==board[0].length-1){
                if(board[r][c]=='O'){
                  dfs(board,r,c);
                }
            }
        }
    }
    for(int r=0;r<board.length;r++){
        for(int c=0;c<board[0].length;c++){
            if(board[r][c]=='O'){board[r][c]='X';}
            else if(board[r][c]=='#'){board[r][c]='O';}
        }
    }  
    }
    private void dfs(char[][] board, int r,int c){
        board[r][c]='#';

        int[] dr={-1,1,0,0};
        int[] dc={0,0,-1,1};

        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];
            if(nr>=0&&nr<board.length&&
               nc>=0&&nc<board[0].length&&
               board[nr][nc]=='O'){
                dfs(board,nr,nc);
            }
        }
    }
}