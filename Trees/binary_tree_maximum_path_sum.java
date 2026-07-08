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
    int pathsum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root==null)return 0;
        helper(root);

        return pathsum;
    }
    public int helper(TreeNode root){
        if(root==null)return 0;

        int left=helper(root.left);
        int right=helper(root.right);

        int leftgain=Math.max(0,left);
        int rightgain=Math.max(0,right);

        pathsum=Math.max(pathsum,root.val+leftgain+rightgain);

        return root.val+Math.max(leftgain,rightgain);
    }
     
}