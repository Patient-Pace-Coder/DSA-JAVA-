package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PracticeTrees { // my implementation

    Queue<Node> queue=new LinkedList<>();

//    public void populate(int val){   --> not needed if root is initialized in the main method.
//        Node root=new Node(val);
//        populate(root);
//    }

    public void populate(Node node){

        Scanner sc=new Scanner(System.in);
        System.out.println("Want to add left of "+node.data);
        boolean res=sc.nextBoolean();
        if(res==true){
            System.out.println("Enter the value: ");
            int val=sc.nextInt();
            node.left=new Node(val);
            populate(node.left);
        }
        System.out.println("Want to add right of "+node.data);
        res=sc.nextBoolean();
        if(res==true){
            System.out.println("Enter the value: ");
            int val=sc.nextInt();
            node.right=new Node(val);
            populate(node.right);
        }

    }

    public void levelOrder(Node node){  // for checking if the populate method worked correctly or not.

        queue.add(node);

        while (!queue.isEmpty()) {

            Node root = queue.poll();

            System.out.print(root.data + " ");

            if (root.left != null) {
                queue.add(root.left);
            }
            if (root.right != null) {
                queue.add(root.right);
            }
        }

    }

    public int heightOfTree(Node node){

        if(node==null){
            return 0;
        }

        return (1+Math.max(heightOfTree(node.left),heightOfTree(node.right)));

    }

    public static void main(String[] args) {

        PracticeTrees tree=new PracticeTrees();
       // Node root=new Node(10);

      //  tree.populate(root);

      //  tree.levelOrder(root);

        Node root=new Node(10);

        root.left=new Node(2);
        root.right=new Node(3);

        root.left.right=new Node(5);
        root.left.left= new Node(4);

        root.right.left=new Node(8);
        root.right.right=new Node(9);

        root.left.left.left=new Node(6);

        root.right.left.left=new Node(11);
        root.right.right.right=new Node(12);


        System.out.println("Height of the tree: "+tree.heightOfTree(root));


    }
}
