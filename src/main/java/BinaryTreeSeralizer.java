import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeSeralizer {

    public static void main(String[] args) {
        BinaryTreeSeralizer binaryTreeSeralizer = new BinaryTreeSeralizer();
        BinaryTreeNode binaryTreeNode = new BinaryTreeNode(13);
        binaryTreeNode.left = new BinaryTreeNode(2);
        BinaryTreeNode binaryTreeNode2 = new BinaryTreeNode(3);

        binaryTreeNode2.right = new BinaryTreeNode(4);
        binaryTreeNode2.left = new BinaryTreeNode(5);

        binaryTreeNode.right = binaryTreeNode2;


        System.out.println(binaryTreeSeralizer.serialize(binaryTreeNode));
        System.out.println(binaryTreeSeralizer.deserialize(binaryTreeSeralizer.serialize(binaryTreeNode)));

    }

    public String serialize(BinaryTreeNode treeNode){
        String treeSerialized = null;
        if(treeNode == null){
            return "X";
        }
        treeSerialized = treeNode.key + "," +  serialize(treeNode.left) + "," + serialize(treeNode.right);
        return treeSerialized;
    }

    public BinaryTreeNode deserialize(String treeSerialized){
        String[] nodes = treeSerialized.split(",");
        Queue<String> nodesQueue = new LinkedList<>();
        nodesQueue.addAll(Arrays.asList(nodes));
        return deserializeHelper(nodesQueue);

    }

    public BinaryTreeNode deserializeHelper(Queue<String> nodes){

        String node = nodes.poll();
        if(node.equals("X")){
                return null;
        }
        BinaryTreeNode root = new BinaryTreeNode(Integer.parseInt(node));
        root.left = deserializeHelper(nodes);
        root.right = deserializeHelper(nodes);

        return root;
        }

}
