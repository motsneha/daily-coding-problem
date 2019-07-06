import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        BinaryTreeNode binaryTreeNode = new BinaryTreeNode(1);
        binaryTreeNode.left = new BinaryTreeNode(2);
        BinaryTreeNode binaryTreeNode2 = new BinaryTreeNode(3);

        binaryTreeNode2.right = new BinaryTreeNode(4);
        binaryTreeNode2.left = new BinaryTreeNode(5);

        binaryTreeNode.right = binaryTreeNode2;


        new BinaryTreePaths().path(binaryTreeNode, list);

    }

    public void path(BinaryTreeNode n, List<Integer> list){


        if(n == null) return;
        list.add(n.key);

        if(n.left == null && n.right == null){
            System.out.println(list);
            list.remove(list.size() - 1 );
        }

        path(n.left, list);
        path(n.right, list);

    }
}
