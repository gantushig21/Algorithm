import java.util.*;

public class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode current = head;
        int size = 1;
        while (current.next != null){
            size++;
            current = current.next;            
        }
        current = head;
        for (int i = 0; i < size / 2; i++)
            current = current.next;

        return current;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode current = head;
        for (int i = 2; i < 7; i++){
            current.next = new ListNode(i);
            current = current.next;
        }

        MiddleOfLinkedList problem = new MiddleOfLinkedList();

        System.out.println(problem.middleNode(head));
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}