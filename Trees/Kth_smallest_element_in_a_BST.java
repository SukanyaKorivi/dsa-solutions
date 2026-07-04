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
 int answer=0;
 boolean found=false;
int count=0;
    public int kthSmallest(TreeNode root, int k) {

      if(root == null) return 0;
     
      
      inOrder(root,k);

      return answer;

    }
    public void inOrder(TreeNode root,int k){
        if(root == null||found== true) return;
        
        
        inOrder(root.left,k);

       count++;
        if(count == k){
            found=true;
            answer=root.val;
            return;
        }

        inOrder(root.right,k);
    }
}