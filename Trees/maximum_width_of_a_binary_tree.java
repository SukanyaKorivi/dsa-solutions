/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null)return 0;
       Queue<Object[]> q = new LinkedList<>();
       int max=0;
       int first=0;
       int last=0;

       int digit=0;

       q.add(new Object[]{root,digit});

       while(!q.isEmpty()){
        int size=q.size();
        Object[] dummy=q.peek();
        int min=(int) dummy[1];


        for(int i=0;i<size;i++){
          Object[] pair=q.poll();
          TreeNode temp=(TreeNode) pair[0];
          int data=(int) pair[1] -min;

          if(temp.left!=null){q.add(new Object[]{temp.left,2*data+1});}

         if(temp.right!=null){q.add(new Object[]{temp.right,2*data+2});}

          if(i==0){ first=data;}
          if(i==size-1){ last=data;}

           max=Math.max(max,last-first+1);
        }


       }
        return max;
    }
}