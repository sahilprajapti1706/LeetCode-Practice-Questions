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
    public ListNode mergeNodes(ListNode head) {
        ListNode temp = head;
        ListNode tail = head;

        while(temp != null){
            int sum = 0;

            while(temp != null && temp.val != 0){
                sum += temp.val;
                temp = temp.next;
            }

            if(sum != 0){
                tail.next.val = sum;
                tail = tail.next;
            }
            temp = temp.next;
        }

        tail.next = null;
        return head.next;

        
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna