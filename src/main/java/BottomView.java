/**
 * The horizontal distance of a binary tree node describes how far left or right the node will be when the tree is printed out.
 * More rigorously, we can define it as follows:
 * The horizontal distance of the root is 0.
 * The horizontal distance of a left child is hd(parent) - 1.
 * The horizontal distance of a right child is hd(parent) + 1.
 * For example, for the following tree, hd(1) = -2, and hd(6) = 0.
 *             5
 *           /     \
 *         3         7
 *       /  \        /   \
 *     1     4    6     9
 *    /                   /
 *   0                  8
 *
 * The bottom view of a tree, then, consists of the lowest node at each horizontal distance. If there are two nodes at the same depth and horizontal distance, either is acceptable.
 * For this tree, for example, the bottom view could be [0, 1, 3, 6, 8, 9].
 * Given the root of a binary tree, return its bottom view.
 */

import java.util.*;

class HdNode{
    HdNode left;
    HdNode right;
    int data;
    int hd;

    public HdNode(int data){
       this.data = data;
       this.hd = Integer.MAX_VALUE;
    }
}
public class BottomView {

    public void bottomView(HdNode root){
        if(root ==  null){
            return ;
        }
        Map<Integer, HdNode> horizontalDistance = new TreeMap<>();
        Queue<HdNode> queue = new LinkedList<>();
        root.hd = 0;
        queue.add(root);

        while(!queue.isEmpty()){

            HdNode node = queue.poll();
            horizontalDistance.put(node.hd, node);

            if(node.left != null){
                node.left.hd = node.hd - 1;
                queue.add(node.left);
            }

            if(node.right != null){
                node.right.hd = node.hd + 1;
                queue.add(node.right);

            }
        }

        for(HdNode node : horizontalDistance.values()){
            System.out.print(node.data +" ");
        }


    }

    public static void main(String[] args) {
        HdNode root = new HdNode(20);
        root.left = new HdNode(8);
        root.right = new HdNode(22);
        root.left.left = new HdNode(5);
        root.left.right = new HdNode(3);
        root.right.left = new HdNode(4);
        root.right.right = new HdNode(25);
        root.left.right.left = new HdNode(10);
        root.left.right.right = new HdNode(14);

        BottomView bottomView = new BottomView();
        System.out.println("Bottom view of the given binary tree:");
        bottomView.bottomView(root);


    }
}
