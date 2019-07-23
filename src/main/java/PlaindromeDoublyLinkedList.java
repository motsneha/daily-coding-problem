
class DoublyLinkedList{
    DoublyLinkedList next;
    DoublyLinkedList previous;

    int value;

    DoublyLinkedList(int value){
        this.value = value;
    }
}



class LinkedListNode{
    LinkedListNode next;
    int data;

    LinkedListNode(int data){
        this.data = data;
    }

    @Override
    public String toString() {
        return " " + data ;
    }
}




public class PlaindromeDoublyLinkedList {


    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList(10);
        doublyLinkedList.next = new DoublyLinkedList(4);
        doublyLinkedList.previous = null;
        doublyLinkedList.next.previous  = doublyLinkedList;
        doublyLinkedList.next.next = new DoublyLinkedList(3);
        doublyLinkedList.next.next.previous = doublyLinkedList.next;

        doublyLinkedList.next.next.next = new DoublyLinkedList(4);
        doublyLinkedList.next.next.next.previous = doublyLinkedList.next.next;


        doublyLinkedList.next.next.next.next = new DoublyLinkedList(10);
        doublyLinkedList.next.next.next.next.previous = doublyLinkedList.next.next.next;

        DoublyLinkedList doublyLinkedList2 = new DoublyLinkedList(10);
        doublyLinkedList2.next = new DoublyLinkedList(4);
        doublyLinkedList2.previous = null;
        doublyLinkedList2.next.previous  = doublyLinkedList2;

        doublyLinkedList2.next.next = new DoublyLinkedList(4);
        doublyLinkedList2.next.next.previous = doublyLinkedList2.next;

        doublyLinkedList2.next.next.next = new DoublyLinkedList(10);
        doublyLinkedList2.next.next.next.previous = doublyLinkedList2.next.next;



        PlaindromeDoublyLinkedList pal = new PlaindromeDoublyLinkedList();
        DoublyLinkedList last = pal.findLast(doublyLinkedList);

        //System.out.println(pal.isPalindrome(doublyLinkedList, last));

        DoublyLinkedList last2 = pal.findLast(doublyLinkedList2);
       // System.out.println(pal.isPalindrome(doublyLinkedList2, last2));


        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);

        head.next.next = new LinkedListNode(2);
        head.next.next.next = new LinkedListNode(1);

        System.out.println(pal.isPalindrome(head));

    }

    DoublyLinkedList findLast(DoublyLinkedList node){

        while (node.next!= null){
            node = node.next;
        }
        return node;
    }

    boolean isPalindrome(DoublyLinkedList head, DoublyLinkedList last){
        if(head == null) return false;
        while(head.value == last.value){
            if(head == last || head.next == last){
                return true;
            }

            head = head.next;
            last = last.previous;
        }
        return false;
    }

    LinkedListNode reverse(LinkedListNode head){
        LinkedListNode current = head;
        LinkedListNode temp2 = null;
        LinkedListNode temp1 = current.next;
        current.next = null;
        while(temp1 != null){
            temp2 = temp1.next;
            temp1.next = current;
            current = temp1;
            temp1 = temp2;
        }
        return current;
    }

    boolean isPalindrome(LinkedListNode node){
        int n = 0;
        LinkedListNode head = node;
        LinkedListNode current = head;
        LinkedListNode mid = head;
        LinkedListNode tail = null;

        while(current.next != null){
            n++;
            current = current.next;
        }


        // System.out.println(n);
        for(int i = 0; i < n/2; i++){
            mid = mid.next;
        }


        tail = reverse(mid);

        while(head != tail && tail.next != head) {
            if(head.data == tail.data){
                head = head.next;
                tail = tail.next;
            }else{
                return false;
            }
        }
        if(tail.next == head){
            if(head.data == tail.data){
               return true;
            }else{
                return false;
            }
        }
        return true;







    }
}
