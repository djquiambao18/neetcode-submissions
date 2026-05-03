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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // can either handle null-case first or just go through the code. either way, it's a very minimal impact given the constraints.
        if(list1 == null && list2 == null) {
            return null;
        }
        // initialize mergedList (output)
        ListNode head = new ListNode();
        ListNode mergedList = head;

        // iterate through both lists checking if either one has reached the end:
        while(list1 != null && list2 != null) {
            // check which one is lower to add to the mergedList
            if(list1.val >= list2.val) {
                head.val = list2.val;
                list2 = list2.next;
            }
            else {
                head.val = list1.val;
                list1 = list1.next;
            }
            if (list1 != null || list2 != null) {
                head.next = new ListNode();
                head = head.next;
            }
        }
        while(list1 != null) {
            head.val = list1.val;
            list1 = list1.next;
            if (list1 != null){
                head.next = new ListNode();
                head = head.next;
            }
        }
        while(list2 != null) {
            head.val = list2.val;
            list2 = list2.next;
            if (list2 != null) {
                head.next = new ListNode();
                head = head.next;
            }
        }

        return mergedList;
    }
}