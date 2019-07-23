import java.util.LinkedList;
import java.util.Queue;

class HeapNode{
    int data;
    HeapNode left;
    HeapNode right;
    HeapNode parent;

    public HeapNode(){

    }
}


public class Heap {

    public static void main(String[] args) {
        int[] array = {3, 2, 0, 5, 7};
        HeapNode heapNode = minHeap(array);
        printHeap(heapNode);

    }

    static HeapNode minHeap(int[] arr){
        int i = 0;
        HeapNode heapNode = new HeapNode();
        Queue<HeapNode> heapNodes = new LinkedList<>();
        heapNodes.add(heapNode);
        heapNode.left = null;
        heapNode.right = null;
        heapNode.parent = null;


        while (!heapNodes.isEmpty() && i < arr.length){
            HeapNode node = heapNodes.poll();
            node.left = new HeapNode();
            node.right = new HeapNode();
            node.left.parent = node;
            node.right.parent = node;
            heapNodes.add(node.left);
            heapNodes.add(node.right);

            node.data = arr[i];
            i++;


                while(node.parent != null){
                    if(node.data < node.parent.data){
                        node.parent.data = node.data ^ node.parent.data;
                        node.data = node.parent.data ^ node.data;
                        node.parent.data = node.parent.data ^ node.data;

                        node = node.parent;

                    }else{
                        break;
                    }

                }

        }
        return heapNode;
    }

    static void printHeap(HeapNode heapNode){
      if(heapNode.left == null && heapNode.right == null)
        System.out.println(heapNode.data);

       if(heapNode.left != null) printHeap(heapNode.left);
       if(heapNode.right != null) printHeap(heapNode.right);
    }
}
