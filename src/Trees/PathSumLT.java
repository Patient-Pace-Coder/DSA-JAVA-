package Trees;

public class PathSumLT {
    private static boolean pathSum( TreeNode node, int targetSum ){
        if( node == null ){
            return false;
        }
        int sum = 0;
        return helper( node,targetSum,sum);
    }
    private static boolean helper( TreeNode node, int targetSum, int sum ){
        sum += node.val;
        boolean isLeftSum = false;
        boolean isRightSum = false;
        if( sum == targetSum && (node.left == null && node.right == null) ){
            return true;
        }
        if( node.left != null ){
            isLeftSum = helper(node.left,targetSum,sum);
            if( isLeftSum ){
                return isLeftSum;
            }
        }
        if( node.right != null ){
            isRightSum = helper(node.right,targetSum,sum);
        }
        return isLeftSum || isRightSum;
    }
    public static void main(String[] args) {
        int targetSum = 22;
        // [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
        TreeNode tree = new TreeNode(5);
        tree.left = new TreeNode(4);
        tree.left.left = new TreeNode(11);
        tree.left.left.right = new TreeNode(2);
        tree.left.left.left = new TreeNode(7);
        tree.right = new TreeNode(8);
        tree.right.right = new TreeNode(4);
        tree.right.left = new TreeNode(13);
        tree.right.right.right = new TreeNode(1);
        System.out.println(pathSum(tree,targetSum));
    }
}
