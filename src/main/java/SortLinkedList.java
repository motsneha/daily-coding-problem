/*
Given a linked list, sort it in O(n log n) time and constant space.
For example, the linked list 4 -> 1 -> -3 -> 99 should become -3 -> 1 -> 4 -> 99.

 */

public class SortLinkedList {



    LinkedListNode push(LinkedListNode head, int data){
        LinkedListNode node = new LinkedListNode(data);
        node.next = head;
        head = node;
        return head;
    }


   public LinkedListNode middle(LinkedListNode head){
        LinkedListNode slow = head;
        LinkedListNode fast = head;
        while(fast.next !=  null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }

    LinkedListNode mergeSort(LinkedListNode head){
        if(head == null || head.next == null){
            return head;
        }
        LinkedListNode left = head;
        LinkedListNode middle = middle(head);
        LinkedListNode right = middle.next;

        middle.next = null;
        left = mergeSort(left);
        right = mergeSort(right);

        return mergeLinkedList(left, right);
    }


    public LinkedListNode mergeLinkedList(LinkedListNode left, LinkedListNode right){
        LinkedListNode result = null;

        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }
        if(left.data <= right.data){
            result = left;
            result.next = mergeLinkedList(left.next, right);
        }
        else{
            result = right;
            result.next = mergeLinkedList(left, right.next);

        }

        return result;
    }

    public void printList(LinkedListNode head){

        while (head != null){
            if(head.next == null){
                System.out.print( head.data + " ");
            }
            else{
                System.out.print( head.data + " > ");
            }
            head = head.next;
        }
        System.out.println("");

    }
    public static void main(String[] args) {
        LinkedListNode head ;
        SortLinkedList sortLinkedList = new SortLinkedList();
        head =  new LinkedListNode(99);
        head = sortLinkedList.push(head, -3);
        head = sortLinkedList.push(head,1);
        head = sortLinkedList.push(head, 4);
        sortLinkedList.printList(head);
        head = sortLinkedList.mergeSort(head);
        sortLinkedList.printList(head);
    }


}
