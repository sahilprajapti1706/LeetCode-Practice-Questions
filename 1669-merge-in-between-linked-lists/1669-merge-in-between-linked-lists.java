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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

        // Moving list2Tail to tail of list2
        ListNode list2Tail = list2;
        while(list2Tail.next != null){
            list2Tail = list2Tail.next;
        }

        // Moving to before "a" i.e. a-1 position of list1
        ListNode aptr = list1;
        for(int i=0;i<a-1;i++){
            aptr = aptr.next;
        }

        ListNode bptr = aptr.next;
        for(int i=0;i<b-a;i++){
            bptr = bptr.next;
        }

        aptr.next = list2;
        list2Tail.next = bptr.next;
        
        return list1;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna