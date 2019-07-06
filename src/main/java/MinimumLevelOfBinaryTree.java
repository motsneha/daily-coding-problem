import java.util.ArrayDeque;
import java.util.Queue;

public class MinimumLevelOfBinaryTree {
    public static void main(String[] args) {
        BinaryTreeNode binaryTreeNode = new BinaryTreeNode(13);
        binaryTreeNode.left = new BinaryTreeNode(2);
        BinaryTreeNode binaryTreeNode2 = new BinaryTreeNode(3);

        binaryTreeNode2.right = new BinaryTreeNode(4);
        binaryTreeNode2.left = new BinaryTreeNode(5);

        binaryTreeNode.right = binaryTreeNode2;


        System.out.println(minSumLevel(binaryTreeNode));
    }

    private static int minSumLevel(BinaryTreeNode rootNode) {
        int sum = 0;
        int minSum = Integer.MAX_VALUE;
        int level = 0;
        int minLevel = 0;
        Queue<BinaryTreeNode> queue1 = new ArrayDeque<>();
        Queue<BinaryTreeNode> queue2 = new ArrayDeque<>();
        queue1.add(rootNode);

        while(!queue1.isEmpty()){
            BinaryTreeNode treeNode = queue1.poll();
            if(treeNode.left != null) {
                queue2.add(treeNode.left);
            }
            if(treeNode.right != null) {
                queue2.add(treeNode.right);
            }
            sum = sum + treeNode.key;

            if(queue1.isEmpty() && !queue2.isEmpty()){
                if(sum <= minSum)
                {
                    minSum = sum;
                    minLevel = level;
                }
                level++;
                sum = 0;
                queue1 = queue2;
                queue2 = new ArrayDeque<>();


            }else if(queue1.isEmpty() && queue2.isEmpty()){
                if(sum <= minSum)
                {
                    minSum = sum;
                    minLevel = level;
                }
            }



        }


        return minLevel;
    }
}
