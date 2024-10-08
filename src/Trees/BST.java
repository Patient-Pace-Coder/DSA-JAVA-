package Trees;

// for my reference

public class BST {

    private class Node{
        Node left;
        Node right;
        int data;
        int height;

        Node(int val){
            this.data =val;
        }
    }

    Node root;

    public int height(Node node){
        if(node==null){
            return -1;
        }
        return node.height;
    }

    public void insert(int value){
        root=insert(value,root);
    }

    public Node insert(int value, Node node){

        if(node==null){
            node=new Node(value);
            return node;
        } else if (value<node.data) {
            node.left=insert(value,node.left);
        }
        else if(value>node.data){
            node.right=insert(value,node.right);
        }

        node.height=Math.max(height(node.left),height(node.right))+1;
//        System.out.println("height of "+node.value+" : "+node.height);
        return node;
    }

//    * The application of inorder traversal in binary search tree is that ,
//    it will give us the set of nodes in the sorted manner.

    public void inOrderRec(){
        inOrderRec(root);
    }
    public void inOrderRec(Node node){ // (left root right)

        if(node==null){
            return;
        }

        inOrderRec(node.left);

        System.out.print(node.data+" ");

        inOrderRec(node.right);
    }

    public void display(){
        display("Root node : ",root);
    }

    public void display(String details,Node node){

        if(node==null){
            return;
        }

        System.out.println(details+node.data);
        display("left child of "+node.data +" : ",node.left);
        display("right child of "+node.data +" : ",node.right);

    }

    public void prettyDisplay(){
        System.out.println();
        System.out.println("Binary Search tree ----------------------------------------------------------------->");
        System.out.println();
        prettyDisplay(" ",root);
    }

    public void prettyDisplay(String indent, Node node){
        if(node==null){   // base condition
            return;
        }
        System.out.println(indent+node.data);
        prettyDisplay(indent+"\t",node.left);
        prettyDisplay(indent+"\t",node.right);

        // if a node value is displayed exactly below another node, then both the nodes are of same level.


    }

    public boolean balanced() {
        return balanced(root);
    }

    private boolean balanced(Node node) {
        if (node == null) {
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);   // condition for a bst to be called as a balanced.
    }


    public static void main(String[] args) {
        BST tree=new BST();
        tree.insert(15);
        tree.insert(10);
        tree.insert(18);
        tree.insert(8);
        tree.insert(12);
        tree.insert(7);
        tree.insert(9);
        tree.insert(16);
        tree.insert(20);

//        tree.display();

        tree.prettyDisplay();
        System.out.println();

        System.out.println("Sorted BST ---> ");

        tree.inOrderRec();





    }

}
