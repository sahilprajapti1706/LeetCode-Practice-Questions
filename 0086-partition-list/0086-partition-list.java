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
    public ListNode partition(ListNode head, int x) {
        ListNode lesserHead = new ListNode(-1);
        ListNode greaterHead = new ListNode(-1);

        ListNode lesserTail = lesserHead;
        ListNode greaterTail = greaterHead;
        ListNode temp = head;

        while(temp!=null){
            if(temp.val< x){
                lesserTail.next = temp;
                lesserTail = lesserTail.next;
            }else{
                greaterTail.next = temp;
                greaterTail = greaterTail.next;
            }
            temp = temp.next;
        }

        lesserTail.next = greaterHead.next;
        greaterTail.next = null;

        return lesserHead.next;
        
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna