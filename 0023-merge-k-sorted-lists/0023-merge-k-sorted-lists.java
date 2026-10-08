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

    // static ListNode mergeTwoList(ListNode list1,ListNode list2){
    //     ListNode dummyNode = new ListNode(-1);
    //     ListNode temp = dummyNode;

    //     while(list1!=null && list2!=null){
    //         if(list1.val <= list2.val){
    //             temp.next = list1;
    //             list1 = list1.next;
    //         }else{
    //             temp.next = list2;
    //             list2 = list2.next;
    //         }
    //         temp = temp.next;

    //     }
    //     while(list1 != null){
    //         temp.next = list1;
    //     }
    //     while(list2 != null){
    //         temp.next = list2;
    //     }
    //     return dummyNode.next;
    // }
    
    // public ListNode mergeKLists(ListNode[] lists) {

    //     if(lists.length == 0){
    //         return null;
    //     }
        
    //     ListNode head = lists[0];
    //     if(lists.length == 1){
    //         return head;
    //     }

    //     for(int i=1;i<lists.length;i++){
    //         head = mergeTwoList(head, lists[i]);
    //     }

    //     return head;
        
    // }

    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a, b) -> a.val - b.val
        );

         // Add first node of every list
        for (ListNode head : lists) {
            if (head != null) {
                pq.add(head);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;


        while (!pq.isEmpty()) {

            // Smallest node
            ListNode curr = pq.poll();

            // Add to answer
            temp.next = curr;
            temp = temp.next;

            // Add next node of same list
            if (curr.next != null) {
                pq.add(curr.next);
            }
        }

        return dummy.next;

    }
}