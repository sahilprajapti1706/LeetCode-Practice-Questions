/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {

       Node p = head;

       while(p != null){
        if(p.child != null){

            Node childHead = flatten(p.child);

            Node forward = p.next;
            p.child = null;

            // Get the tail of child tree
            Node temp = childHead;
            while(temp.next != null){
                temp = temp.next;
            }

            p.next = childHead;
            childHead.prev = p;
            if(forward != null){
                forward.prev = temp;
            }
            temp.next = forward;
        }
        p = p.next;
       }
       return head;
        
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna