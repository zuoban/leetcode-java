package p206;

/**
 * 206. 反转链表
 * <p>
 * 反转一个单链表。
 * 示例:
 * <pre>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * </pre>
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head;

        while (cur != null) {
            ListNode tempNext = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tempNext;
        }
        return pre;
    }

    public ListNode reverseList3(ListNode head) {
        return reverseListInternally(head, null);
    }

    private ListNode reverseListInternally(ListNode head, ListNode newNode) {
        if (head == null) {
            return newNode;
        }
        ListNode next = head.next;
        head.next = newNode;
        return reverseListInternally(next, head);
    }


    public ListNode reverseList2(ListNode head) {
        // 终止条件
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = reverseList2(head.next);

        head.next.next = head;
        head.next = null;
        return p;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            ListNode p = this;
            while (p != null) {
                sb.append(p.val).append(" ");
                p = p.next;
            }

            return sb.toString();
        }
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);

        System.out.println(l);

        ListNode result = new Solution().reverseList2(l);

        System.out.println(result);
    }
}
