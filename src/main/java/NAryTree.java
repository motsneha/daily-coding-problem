import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class NaryNode{
    int val;
    List<NaryNode> children;

    NaryNode(int val, List<NaryNode> children){
        this.children = children;
        this.val = val;
    }
}


class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> nodes = new ArrayList<>();
        Stack<Node> stack = new Stack<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            nodes.add(node.val);
            if (node.children != null) {
                for (int i = node.children.size() - 1; i >= 0; i--) {
                    stack.push(node.children.get(i));
                }
            }

        }

        return nodes;
    }
}


public class NAryTree {

    public static int count = 0;

    public static void main(String[] args) {
        NaryNode node8 = new NaryNode(8, null);
        NaryNode node5 = new NaryNode(5, null);
        NaryNode node6 = new NaryNode(6, null);
        NaryNode node7 = new NaryNode(7, null);

        List<NaryNode> nodes4 = new ArrayList<>();
        nodes4.add(node6);
        nodes4.add(node7);
        nodes4.add(node8);
        NaryNode node4 = new NaryNode(4, nodes4);


        List<NaryNode> nodes2 = new ArrayList<>();
        nodes2.add(node5);

        NaryNode node2 = new NaryNode(2, nodes2);
        NaryNode node3 = new NaryNode(3, null);

        List<NaryNode> nodes1 = new ArrayList<>();
        nodes1.add(node2);
        nodes1.add(node3);
        nodes1.add(node4);

        NaryNode node1 = new NaryNode(1, nodes1);

        NAryTree tree = new NAryTree();

        List<Integer> list = new ArrayList<>();
        tree.traverse(node1, list);


        System.out.println(tree.maxDepth(node1));//root node level excludeda
        Solution solution = new Solution();

        Node node8_1 = new Node(8, null);
        Node node5_1 = new Node(5, null);
        Node node6_1 = new Node(6, null);
        Node node7_1 = new Node(7, null);

        List<Node> nodes4_1 = new ArrayList<>();
        nodes4_1.add(node6_1);
        nodes4_1.add(node7_1);
        nodes4_1.add(node8_1);
        Node node4_1 = new Node(4, nodes4_1);


        List<Node> nodes2_1 = new ArrayList<>();
        nodes2_1.add(node5_1);

        Node node2_1 = new Node(2, nodes2_1);
        Node node3_1 = new Node(3, null);

        List<Node> nodes1_1 = new ArrayList<>();
        nodes1_1.add(node2_1);
        nodes1_1.add(node3_1);
        nodes1_1.add(node4_1);

        Node node1_1 = new Node(1, nodes1_1);

        System.out.println(solution.preorder(node1_1));

    }

    public int maxDepth(NaryNode root) {
        return dfs(root);
    }

    private int dfs(NaryNode node) {
        if (node == null) return 0;
        int max = 0;
        if (node.children != null) {
            for (NaryNode n : node.children) {
                int dn = dfs(n);
                if (dn > max) max = dn;
            }
        }
        return max + 1;
    }

    public void traverse(NaryNode n, List<Integer> vals) {

        if (n == null) {

            return;
        }
        vals.add(n.val);

        if (n.children != null) {

            for (NaryNode node : n.children) {
                traverse(node, vals);

            }
        }


    }
}

