class BinaryTreeNode
{
   int key;
   BinaryTreeNode left, right;

   public BinaryTreeNode(int item)
   {
       key = item;
       left = right = null;
   }

   public int height(BinaryTreeNode n){

       int left = 0 , right = 0;

       if(n.left!= null)
        left = height(n.left);
       if(n.right != null)
        right = height(n.right);

       return Math.max(left, right) + 1;
   }
}
