
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode lesserHead = new ListNode(-1);
        ListNode greaterHead = new ListNode(-1);

        ListNode lesserTail = lesserHead;
        ListNode greaterTail = greaterHead;

        ListNode temp = head;

        while (temp != null) {
            ListNode next = temp.next;
            temp.next = null;

            if (temp.val < x) {
                lesserTail.next = temp;
                lesserTail = temp;
            } else {
                greaterTail.next = temp;
                greaterTail = temp;
            }

            temp = next;
        }

        lesserTail.next = greaterHead.next;

        return lesserHead.next;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna