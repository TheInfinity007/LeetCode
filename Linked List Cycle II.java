// find-first-node-of-loop-in-a-linked-list

public class LinkedListCycleII {
    public static void main(String[] args) {
        ListNode head = newNode(50);
        head.next = newNode(20);
        head.next.next = newNode(15);
        head.next.next.next = newNode(4);
        head.next.next.next.next = newNode(10);

        printList(head);
        // Create a loop for testing
        head.next.next.next.next.next = head.next.next;

        ListNode res = new Solution().detectCycle(head);
        if (res == null)
            System.out.print("Loop does not exist");
        else
            System.out.print("Loop starting node is " +  res.val);
    }

    static ListNode newNode(int key)
    {
        ListNode temp = new ListNode();
        temp.val = key;
        temp.next = null;
        return temp;
    }

    static void printList(ListNode head)
    {
        while (head != null) 
        {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }


}




public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slowPtr, fastPtr;
        
        if(head == null || head.next == null)
            return null;
        
        slowPtr = head.next;
        fastPtr = head.next.next;
        
        while(fastPtr != null && fastPtr.next != null){
            if(slowPtr == fastPtr) break;
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        
        if(slowPtr == null || fastPtr == null || slowPtr != fastPtr)
            return null;
        

        System.out.println(slowPtr.val + " " + fastPtr.val);
        slowPtr = head;
        
        while(slowPtr != fastPtr){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next;
        }
        return slowPtr;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(){};
    ListNode(int x) {
        val = x;
        next = null;
    }
}

