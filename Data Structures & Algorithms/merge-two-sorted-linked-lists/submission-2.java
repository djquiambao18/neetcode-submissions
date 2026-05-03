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
        // case when neither have anything, just return null
        if(list1 == null && list2 == null) {
            return null;
        }

        // normal case, we need a new list, and a pointer to the head of the list
        ListNode mergedList = new ListNode();
        ListNode curr = mergedList;

        // go through the lists and add them into the new merged list in sorted order:
        while(list1 != null && list2 != null) {
            curr.next = new ListNode();
            if(list1.val <= list2.val) {
                // add the value of list 1 to the current listItem value:
                curr.next.val = list1.val;
                // point list 1 to the next item
                list1 = list1.next;
            }
            else {
                curr.next.val = list2.val;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        // either one could be longer than the other list. if so, just add the remainder to the mergedList;
        curr.next = list1 != null ? list1 : list2;

        return mergedList.next;
    }
}