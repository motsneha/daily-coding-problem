
class DLL {
    Node head; // head of list

    /* Doubly Linked list BinaryTreeNode*/
    class Node {
        int data;
        Node prev;
        Node next;

        // Constructor to create a new node
        // next and prev is by default initialized as null
        Node(int d) { data = d; }
    }
}
public class DoubleLinkedListPalindrome {



    public static void main(String[] args) {

        DLL dll = new DLL();
        DLL.Node node1 = dll.new Node(1);
        dll.head = node1;

        DLL.Node node2 = dll.new Node(4);
        node2.next = node2;

    }
}
