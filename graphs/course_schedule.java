class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] color=new int[numCourses];
        Arrays.fill(color,-1);
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        } 

        for(int[] edge : prerequisites){

            graph.get(edge[1]).add(edge[0]);

        }

        for(int course=0;course<numCourses;course++){
            if(color[course]== -1){
               if(dfs(course,color, graph))return false;
            }
        }
        
        return true;
    }
    private boolean dfs(int course, int[] color,  List<List<Integer>> graph ){
        color[course]=-2;
        for(int neighbor:graph.get(course)){
            if(color[neighbor]==-1){
                if(dfs(neighbor,color,graph))return true;
            }

            else if(color[neighbor]== -2){return true;}
        }
        color[course]= -3;

        return false;
    }
}