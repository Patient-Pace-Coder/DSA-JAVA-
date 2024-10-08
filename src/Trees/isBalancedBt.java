package Trees;

// * Definition for a binary tree node.
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class Solution {
    public static int height( TreeNode root ){

        if( root == null ){
            return 0;
        }
        int leftHeight = height(root.left);
        if( leftHeight == -1 ){
            return -1;
        }
        int rightHeight = height(root.right);
        if( rightHeight == -1 ){
            return -1;
        }
        if( Math.abs( leftHeight - rightHeight ) >= 2 ){
            return -1;
        }
        return 1 + Math.max(leftHeight,rightHeight);
    }
    private static boolean isBalanced(TreeNode root) {

        return height(root) != -1;
    }
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.left.left = new TreeNode(3);
        tree.left.left.left = new TreeNode(4);
        tree.right = new TreeNode(2);
        tree.right.right = new TreeNode(3);
        tree.right.right.right = new TreeNode(4);
        System.out.println(isBalanced(tree));
    }
}