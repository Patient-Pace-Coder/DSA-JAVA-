package Trees;

public class HeightOfTree {

    int height_left;
    int height_right;
    public int  heightOfTheTree(Node node){

        if(node==null){
            return 0;
        }

        return 1+ Math.max(heightOfTheTree(node.left),heightOfTheTree(node.right));

    }

    public static void main(String[] args) {

        HeightOfTree tree= new HeightOfTree();

        Node root=new Node(1);

        //root.left.data=2;  // doesn't work as there is no root.left node, there no root.left.data.(since, root.left=null)

        root.left=new Node(3);
        root.right=new Node(2);

        root.left.right=new Node(4);
        root.left.left= new Node(5);

        root.left.left.left=new Node(7);
        root.left.left.right=new Node(6);
        System.out.println("Height of the tree: "+tree.heightOfTheTree(root));

    }

}
