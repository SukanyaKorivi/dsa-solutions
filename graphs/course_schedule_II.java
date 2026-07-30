class Solution {
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] color=new int[numCourses];
        int[] result=new int[numCourses];
        int[] index={numCourses-1};
        
        List<List<Integer>> graph=new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge:prerequisites){
            graph.get(edge[1]).add(edge[0]);
        }

        for(int course=0;course<numCourses;course++){
            if(color[course]==0){
                if(dfs(course,color,result,graph,index))return new int[0];
            }
        }
        return result;
        
    }
    private boolean dfs(int course,int[] color,int[] result,List<List<Integer>> graph,int[] index){
        color[course]=-2;

        for(int neighbor:graph.get(course)){
            if(color[neighbor]==0){
                if(dfs(neighbor,color,result,graph,index))return true;
            }
            else if(color[neighbor]== -2){
                return true;
            }
        }
        color[course]= -3;
        result[index[0]--]=course;
        return false;
    }
}