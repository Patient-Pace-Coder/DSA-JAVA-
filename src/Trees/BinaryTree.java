package Trees;

import java.util.Scanner;

public class BinaryTree {  // kk's implementation

    private class Node{

        int value;
        Node left;
        Node right;

        Node(int value){
            this.value=value;
        }
    }

    Node root;


    public void Insert(Scanner scanner){
        System.out.print("Enter the root node ");
        root=new Node(scanner.nextInt());
        this.Insert(scanner,root);

    }

    public void Insert(Scanner scanner,Node node){

        System.out.print("Do you want to enter left of "+node.value+" ");
        boolean left=scanner.nextBoolean();   // nextBoolean() will take either treu or false as inputs (case-insensitive)
        if(left){
            System.out.print("Enter the node value of the left of "+node.value+" ");
            int val=scanner.nextInt();
            Node left_node=new Node(val);
            node.left=left_node;
            Insert(scanner,left_node);

        }

        System.out.print("Do you want to enter right of "+node.value+" ");
        boolean right=scanner.nextBoolean();   // nextBoolean() will take either treu or false as inputs (case-insensitive)
        if(right){
            System.out.print("Enter the node value of the right of "+node.value+" ");
            int val=scanner.nextInt();
            Node right_node=new Node(val);
            node.right=right_node;
            Insert(scanner,right_node);

        }


    }

    public void display(){
        display(" ",root);
    }

    public void display(String indent,Node node){
        if(node==null){   // base condition
            return;
        }
        System.out.println(indent+node.value);
        display(indent+"\t",node.left);
        display(indent+"\t",node.right);

        // if a node value is displayed exactly below another node, then both the nodes are of same level.

    }

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        BinaryTree bt=new BinaryTree();
        bt.Insert(sc);
        bt.display();
    }
}
