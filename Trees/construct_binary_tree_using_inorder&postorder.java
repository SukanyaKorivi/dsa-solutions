class Solution {
    int[] inorder;
    int[] postorder;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
     int postStart=0;
     int postend=postorder.length-1;
     int instart=0;
     int inend=inorder.length-1;
     this.inorder=inorder;
     this.postorder=postorder;

     return helper(postStart,postend,instart,inend);   
    }
    public TreeNode helper(int poststart,int postend,int instart,int inend){
        if(poststart>postend||instart>inend)return null;

        TreeNode root=new TreeNode(postorder[postend]);
        int inRoot=-1;

        for(int i=instart;i<=inend;i++){
            if(postorder[postend]==inorder[i]){
                inRoot=i;
            }
        }
        int leftsize=inRoot-instart;

        TreeNode left=helper(poststart,poststart+leftsize-1,instart,inRoot-1);
        root.left=left;

        TreeNode right=helper(poststart+leftsize,postend-1,inRoot+1,inend);
        root.right=right;

        return root;
    }
}