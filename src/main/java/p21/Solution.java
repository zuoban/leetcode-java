package p21;

/**
 * 21. 合并两个有序链表
 */
public class Solution {

    public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        if (l1 == null ) return l2;
        else if (l2 == null) return l1;
        else if (l1.val <= l2.val)  {
            l1.next = mergeTwoLists3(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeTwoLists3(l1, l2.next);
            return l2;
        }
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);

        ListNode prev = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        prev.next = l1 == null ? l2 : l1;

        return dummy.next;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head = l1;

        ListNode prev = null;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                ListNode l2NextTemp = l2.next;

                l2.next = l1.next;
                l1.next = l2;
                l2 = l2NextTemp;
            } else {
                prev = l1;
                l1 = l1.next;
            }
        }

        if (l2 != null) prev.next = l2;

        return head;
    }


    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {

        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
