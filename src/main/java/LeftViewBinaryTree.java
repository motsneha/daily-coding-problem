import java.util.LinkedList;
import java.util.Queue;

public class LeftViewBinaryTree {

    public static void main(String[] args) {
        BinaryTreeNode node = new BinaryTreeNode(10);
        BinaryTreeNode nodeLeft1 = new BinaryTreeNode(20);
        BinaryTreeNode nodeRight1 = new BinaryTreeNode(30);
        BinaryTreeNode nodeLeft1Left2 = new BinaryTreeNode(40);

        node.left = nodeLeft1;
        node.right = nodeRight1;
        nodeLeft1.left = nodeLeft1Left2;

        leftView(node, 0);

    }

    public static void leftView(BinaryTreeNode node, int level){
        System.out.println(node.height(node));


    }
}
