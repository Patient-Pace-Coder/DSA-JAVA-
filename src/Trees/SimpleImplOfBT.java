package Trees;

public class SimpleImplOfBT {

    static class Node{

        Node left;
        Node right;

        int data;

        Node(int value){
            this.data=value;
            this.left=null;
            this.right=null;
        }
    }

    public void printTree(Node node){ // normal print , not (post/in-order)
        if(node==null){  // base case
            return;
        }

            // print data
            System.out.println(node.data+" ");

            // left traversal
            printTree(node.left);

            // right traversal
            printTree(node.right);

            return; // by default after completion control goes the block from where it was called.

    }

    public static void main(String[] args) {

        SimpleImplOfBT tree=new SimpleImplOfBT();

        Node root=new Node(10);

        root.left.data=2;  // doesn't work as there is no root.left node, there no root.left.data.(root.left=null)

        root.left=new Node(2);
        root.left.left= new Node(4);
        root.left.right=new Node(5);
        root.right=new Node(3);
        root.right.left=new Node(6);
        root.right.right=new Node(7);

        tree.printTree(root);
    }
}
