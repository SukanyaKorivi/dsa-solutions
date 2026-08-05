class Solution {
    public int minimumEffortPath(int[][] heights) {
    PriorityQueue<int[]> pq =
new PriorityQueue<>((a,b) -> a[0] - b[0]);

int rows=heights.length;
int cols=heights[0].length;

int[][] effort = new int[rows][cols];

for(int[] row : effort){
    Arrays.fill(row, Integer.MAX_VALUE);
}

effort[0][0] = 0;

pq.offer(new int[]{0,0,0});
  int[] dr = {0,0,-1,1};
int[] dc = {-1,1,0,0};


while(!pq.isEmpty()){

    int[] curr = pq.poll();

    int currEffort = curr[0];
    int r = curr[1];
    int c = curr[2];

    if(currEffort > effort[r][c]) continue;

   
for(int i=0;i<4;i++){

    int nr = r + dr[i];
    int nc = c + dc[i];

    if(nr>=0 &&
       nr<rows &&
       nc>=0 &&
       nc<cols){

        int edgeWeight =
        Math.abs(heights[r][c]-heights[nr][nc]);

        int newEffort =
        Math.max(currEffort, edgeWeight);

        if(newEffort < effort[nr][nc]){

            effort[nr][nc] = newEffort;

            pq.offer(new int[]{
                newEffort,
                nr,
                nc
            });

        }

    }

}
} 
return effort[rows-1][cols-1];   
    }
}