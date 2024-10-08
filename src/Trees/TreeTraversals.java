package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


//DFS (Depth-First Search): here preOrder(),postOrder(),inOrder().
//
//        In DFS, the algorithm starts at the root node and explores as far as possible along each branch before backtracking.
//        It can be implemented using recursion or a stack data structure.
//        DFS can be further categorized into pre-order, in-order, and post-order traversal, depending on when you visit the current node relative to its children.
//        DFS is often used when you want to explore as far as possible along each branch before backtracking, such as in maze solving or finding connected components in a graph.

//BFS (Breadth-First Search): here levelOrder().
//
//        In BFS, the algorithm starts at the root node and explores all nodes at the current depth level before moving on to nodes at the next level.
//        It is implemented using a queue data structure.
//        BFS explores the shortest path first and guarantees that it will find the shortest path to any node.
//        BFS is often used when you want to find the shortest path between two nodes or to visit nodes in level order, such as in finding the shortest path in unweighted graphs or in web crawling.

public class TreeTraversals {
    Stack<Node> stack=new Stack<>(); // for DFS
    Queue<Node> queue=new LinkedList<>();  // for BFS
    ArrayList<Node> arr=new ArrayList<>();

    public void preOrderRec(Node node){ // (root left right)

        if(node==null){
            return;
        }

        // first print root
        System.out.print(node.data+ " " );

        // then go to left subtree
        preOrderRec(node.left);

        // then go to right subtree
        preOrderRec(node.right);

    }

    public void preOrderItr1(Node node){  // have to work still

        stack.push(node);

        while (!stack.isEmpty()) {

            Node root = stack.pop();

            System.out.print(root.data+" ");

            if(root.right!=null){
                stack.push(root.right);
            }

            if (root.left != null) {
                stack.push(root.left);
            }

        }
    }

    public void preOrderItr(Node node){

        // intuition :
        // 1.we will push the root into the stack,
        // 2.we will pop the top most element and print it, which in the end forms the pre-order traversal.
        // 3.then push the right child first and then the left child(i.e. left child will be at the top as stack follows lifo)
        // 4.then repeat  steps 2,3 until the stack becomes empty.

        stack.push(node);

        while(!stack.isEmpty()){
            Node root=stack.pop();

            System.out.print(root.data+" ");

            if(root.right!=null){
                stack.push(root.right);
            }
            if(root.left!=null){
                stack.push(root.left);
            }
        }

    }

    public void postOrderRec(Node node){  // (left right root)

        if(node==null){
            return;
        }

        postOrderRec(node.left);

        postOrderRec(node.right);

        System.out.print(node.data+" ");
    }

    public void postOrderItr(Node node){  // (left right root)

        if(node==null){  // optional
            return;
        }

        stack.push(node);

        while (!stack.isEmpty()){

            Node root=stack.pop();

            arr.add(root);

            if(root.left!=null){
                stack.push(root.left);
            }
            if(root.right!=null){
                stack.push(root.right);
            }

        }

        for(int i= arr.size()-1;i>=0;i--){
            Node n= arr.get(i);
            System.out.print(n.data+" ");
        }
    }



    public void inOrderRec(Node node){ // (left root right)

        if(node==null){
            return;
        }

        inOrderRec(node.left);

        System.out.print(node.data+" ");

        inOrderRec(node.right);
    }

    public void inOrderItr(Node node){   // own logic

        stack.push(node);

        if(node==null){
            return;
        }

        while (!stack.isEmpty()) {

            if (node.left != null) { // first left
                node=node.left;
                stack.push(node);
                continue;
            }
            Node root = stack.pop();

            System.out.print(root.data+" "); // next root printing

            if(root.right!=null){ // next right
                root=root.right;
                stack.push(root);
                node=root;
            }

        }
    }

    public void levelOrder(Node node){ // commonly known as BFS(Breadth first search)

        if (node==null){
            return;
        }

        queue.add(node);

        while (!queue.isEmpty()) {

            Node root = queue.poll();
            System.out.print(root.data + " ");


            if (root.left != null) {
                queue.add(root.left);
//                queue.add(node.left); don't repeat this mistake (node instead of root).
            }

            if (root.right != null) {
                queue.add(root.right);

//                queue.add(node.right); don;t repeat this (node instead of root).
            }
        }
    }


    public static void main(String[] args) {

        TreeTraversals tree=new TreeTraversals();

        Node root=new Node(1);

        //root.left.data=2;  // doesn't work as there is no root.left node, there no root.left.data.(since, root.left=null)

        root.left=new Node(3);
        root.right=new Node(2);

        root.left.right=new Node(4);
        root.left.left= new Node(5);

        root.left.left.left=new Node(7);
        root.left.left.right=new Node(6);

        System.out.println("Pre Order Traversal--> ");

        tree.preOrderRec(root);
        System.out.println();

        System.out.println("Pre Order Traversal itr--> ");

        tree.preOrderItr1(root);
        System.out.println();

        System.out.println("Post Order Traversal--> ");

        tree.postOrderRec(root);
        System.out.println();

        System.out.println("Post Order Itr--> ");

        tree.postOrderItr(root);
        System.out.println();

        System.out.println("In Order Traversal--> ");

        tree.inOrderRec(root);
        System.out.println();

        System.out.println("In Order Itr--> ");

        tree.inOrderItr(root);
        System.out.println();



        System.out.println("Level order Traversal / Breadth First search: ");

        tree.levelOrder(root);

        System.out.println();



    }
}
