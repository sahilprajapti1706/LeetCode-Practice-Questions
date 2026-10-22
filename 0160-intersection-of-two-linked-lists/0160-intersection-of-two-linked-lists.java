/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;

        while(tempA != null && tempB != null){
            tempA = tempA.next;
            tempB = tempB.next;
        }

        if(tempA == null){
            int extraLenB = 0;
            while(tempB != null){
                tempB = tempB.next;
                extraLenB++;
            }

            while(extraLenB > 0){
                headB = headB.next;
                extraLenB--;
            }
        }

        if(tempB == null){
            int extraLenA = 0;

            while(tempA != null){
                tempA = tempA.next;
                extraLenA++;
            }
            
            while(extraLenA >0){
                headA = headA.next;
                extraLenA--;
            }
        }

        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
        
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna