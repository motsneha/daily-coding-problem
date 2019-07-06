import java.util.HashMap;
import java.util.Map;

class CircularSingleLinkedList {
    public LinkedListNode head;

    static class LinkedListNode {
        int data;
        LinkedListNode next;

         LinkedListNode(int data){
           this.data = data;
        }
    }
}

public class FindHead{
    public static void main(String[] args) {
        CircularSingleLinkedList circularSingleLinkedList = new CircularSingleLinkedList();

        CircularSingleLinkedList.LinkedListNode head = new CircularSingleLinkedList.LinkedListNode(1);
        circularSingleLinkedList.head = head;

        CircularSingleLinkedList.LinkedListNode listNode = new CircularSingleLinkedList.LinkedListNode(2);
        head.next = listNode;

        CircularSingleLinkedList.LinkedListNode listNode3 = new CircularSingleLinkedList.LinkedListNode(3);
        listNode.next = listNode3;

        CircularSingleLinkedList.LinkedListNode listNode4 = new CircularSingleLinkedList.LinkedListNode(4);
        listNode3.next = listNode4;

        CircularSingleLinkedList.LinkedListNode listNode5 = new CircularSingleLinkedList.LinkedListNode(5);
        listNode4.next = listNode5;

        listNode5.next = listNode;

        CircularSingleLinkedList.LinkedListNode node = head;
        Map<Integer, Integer> nodeMap = new HashMap<>();

        while (node != null) {
            if (nodeMap.get(node.data) != null) {
                break;
            } else {
                nodeMap.put(node.data, 1);

                node = node.next;
            }

        }
        if (node == null) {
            System.out.println(-1);
        } else {
            System.out.println(node.data);
        }
        System.out.println(nodeMap);

        CircularSingleLinkedList.LinkedListNode slow = head.next;
        CircularSingleLinkedList.LinkedListNode fast = slow.next;

        while (!slow.equals(fast)) {
            if (slow != null) {
                slow = slow.next;
            } else {
                break;
            }
            if (fast != null && fast.next != null) {
                fast = fast.next.next;
            } else {
                break;
            }
        }

                if (slow != null && fast != null && slow.equals(fast))
                    System.out.println(slow.next.data);

            }
        }
    

