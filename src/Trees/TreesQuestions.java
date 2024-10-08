package Trees;

public class TreesQuestions {


    // 1. count the Nodes in a complete binary tree
    // A tree is said to be complete binary tree
    // if every node in all levels except the last level has 2 child nodes.
    // The nodes in the last level may or may not have 2 children.

    // if time complexity is BigO(n) then we can use tree traversal.

    // if time complexity should be less than BigO(n) then


    public static void main(String[] args) {

        TreesQuestions tree=new TreesQuestions();
        Node root=new Node(1);

        //root.left.data=2;  // doesn't work as there is no root.left node, there no root.left.data.(since, root.left=null)

        root.left=new Node(3);
        root.right=new Node(2);

        root.left.right=new Node(4);
        root.left.left= new Node(5);

        root.left.left.left=new Node(7);
        root.left.left.right=new Node(6);
    }
}
