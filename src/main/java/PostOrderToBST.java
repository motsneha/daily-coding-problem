public class PostOrderToBST {

    public static void main(String[] args) {
        PostOrderToBST postOrderToBST = new PostOrderToBST();
        int[] arr = {2, 4, 3, 8, 7, 5};
        BinaryTreeNode root = postOrderToBST.createBinarySearchTree(arr, 0, arr.length - 1);

        System.out.println(root);
        System.out.println(root.right);
        System.out.println(root.left);

    }


    BinaryTreeNode createBinarySearchTree(int[] arr, int startIndex, int endIndex){

        if(startIndex == endIndex){
            return new BinaryTreeNode(arr[startIndex]);
        }
        if(startIndex > endIndex){
            return null;
        }

        int i = startIndex;
        int rootElement = arr[endIndex];
        while(arr[i] <= rootElement){
            i++;
        }

        BinaryTreeNode left = createBinarySearchTree(arr, startIndex, i - 1);
        BinaryTreeNode right = createBinarySearchTree(arr, i, endIndex -1);
        BinaryTreeNode root = new BinaryTreeNode(arr[endIndex]);
        root.left = left;
        root.right = right;
        return root;

    }

}
