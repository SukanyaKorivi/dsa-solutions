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
    int[] preorder;
    int[] inorder;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
this.inorder = inorder;
        int preStart=0;
        int preEnd=preorder.length-1;
        int instart=0;
        int inend=inorder.length-1;
        
       

        return helper(preStart,preEnd,instart,inend);
        
    }
    public TreeNode helper(int prestart,int preend,int instart,int inend){
        if (prestart > preend || instart > inend)return null;
        TreeNode root=new TreeNode(preorder[prestart]);
        int inRoot=0;

        for(int i=instart;i<=inend;i++){
           if(preorder[prestart]==inorder[i]){
            inRoot=i;
           } 
        }
        int leftsize=inRoot-instart;
       
       
         TreeNode left=helper(prestart+1,prestart+leftsize,instart,inRoot-1);
         root.left=left;

        

         TreeNode right=helper(prestart+leftsize+1,preend,inRoot+1,inend);
         root.right=right;



return root;

    }
}