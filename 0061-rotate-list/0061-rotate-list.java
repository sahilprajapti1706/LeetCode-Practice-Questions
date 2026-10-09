/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0){
            return head;
        }

        // Node 1 ya ek se jyda hai

        int totalNodes = 1;
        ListNode tail = head;

        while(tail.next!=null){
            totalNodes++;
            tail = tail.next;
        }

        k = k % totalNodes;
        ListNode temp = head;

        for(int i=1;i<=totalNodes-k-1;i++){
            temp = temp.next;
        }

        tail.next = head;
        head = temp.next;
        temp.next = null;

        return head;
        
    }
}