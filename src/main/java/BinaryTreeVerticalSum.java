

import java.util.HashMap;

class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode(int data){
        this.val = data;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTreeVerticalSum {

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1);

        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);

        treeNode.setLeft(left);
        treeNode.setRight(right);

        TreeNode left4 = new TreeNode(4);
        TreeNode left6 = new TreeNode(6);
        TreeNode right5 = new TreeNode(5);
        TreeNode right7 = new TreeNode(7);

        left.setLeft(left4);
        left.setRight(right5);

        right.setRight(right7);
        right.setLeft(left6);

        BinaryTreeVerticalSum binaryTreeVerticalSum = new BinaryTreeVerticalSum();
        HashMap<Integer, Integer> sum = new HashMap<>();
        binaryTreeVerticalSum.verticalSum(sum, treeNode, 0);

        System.out.println(sum.entrySet());
    }

    public void verticalSum(HashMap<Integer, Integer> sum, TreeNode node, int horizontalDistance){

        if(node == null){return;}

        //inorder left root right as we have to start from left most and come to root and then to right.


        if(node.left != null){
            verticalSum(sum, node.left, horizontalDistance - 1);
        }

        if(sum.get(horizontalDistance) != null){
            sum.put(horizontalDistance, sum.get(horizontalDistance) + node.val);
        }

        else {
            sum.put(horizontalDistance, node.val);
        }

        if(node.right!= null){
            verticalSum(sum, node.right, horizontalDistance + 1);
        }

    }
}
