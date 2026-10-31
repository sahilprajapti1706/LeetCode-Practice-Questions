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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        
        ListNode prev = head;
        ListNode curr = head.next;
        List<Integer> points = new ArrayList<>();
        int i = 1;

        while(curr != null && curr.next != null){

            if(curr.val < prev.val && curr.val < curr.next.val){
                points.add(i);
            }
            if(curr.val > prev.val && curr.val > curr.next.val){
                points.add(i);
            }

            curr = curr.next;
            prev = prev.next;
            i = i+1;
        }

        if(points.size()<2){
            return new int[]{-1, -1};
        }

        int minDis = Integer.MAX_VALUE;
        for(int j=1;j<points.size();j++){
            minDis = Math.min(minDis, points.get(j)- points.get(j-1));
        }
        int maxDis = points.get(points.size()-1)- points.get(0);

        return new int[]{minDis, maxDis};
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna