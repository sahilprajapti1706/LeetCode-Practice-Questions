class Solution {
    public Node flatten(Node head) {
        Node p = head;

        while (p != null) {
            if (p.child == null) {
                p = p.next;
            } else {
                Node forward = p.next;
                Node temp = p.child;

                // Find the tail of the child list
                while (temp.next != null) {
                    temp = temp.next;
                }

                // Connect child list to the original next node
                temp.next = forward;

                if (forward != null) {
                    forward.prev = temp;
                }

                p.next = p.child;
                p.child.prev = p;
                p.child = null;

                // Continue traversing the inserted child list
                p = p.next;
            }
        }

        return head;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna