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
    int result=Integer.MIN_VALUE;
    public int maxAncestorDiff(TreeNode root) {
        if(root==null)return 0;
       
        int min=root.val;
        int max=root.val;

        helper(root,max,min);

        return result;
    }

    public void helper(TreeNode root,int max,int min){
        if(root==null)return;
         
         min=Math.min(min,root.val);
         max=Math.max(max,root.val);

         result=Math.max(result,max-min);

       if(root.left!=null) helper(root.left,max,min);

        
        
        if(root.right!=null)helper(root.right,max,min); 


     
    }
}