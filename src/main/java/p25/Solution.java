package p25;

/**
 * K 个一组翻转链表
 */
public class Solution {

    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode hair = new ListNode(0);
        hair.next = head;

        ListNode pre = hair;

        while (head != null) {
            ListNode tail = pre;
            // 查看剩余部分长度是否大于等于 k
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
            }

            ListNode next = tail.next;

            ListNode[] nodes = reverse(head, tail);
            // 把子链表重新接回原链表
            pre.next = nodes[0];
            nodes[1].next = next;
            pre = tail;
            head = tail.next;
        }

        return hair.next;
    }

    private ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next, p = head;
        while (prev != tail) {
            ListNode next = p.next;
            p.next = prev;
            prev = p;
            p = next;
        }

        return new ListNode[]{tail, head};
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode tmp = head;
        // 检查接下来的 k 个节点是否需要翻转

        for (int i = 0; i < k; i++) {
            if (tmp == null) return head;
            else tmp = tmp.next;
        }

        // 这步是关键，如果过了 k 个节点直接递归即可，将递归得到的结果放到迭代翻转中
        ListNode pre = reverseKGroup(tmp, k);

        //后面就是正常的翻转链表，不同的是 pre 从 null 变成了递归得到的结果
        ListNode cur = head;
        for (int i = 0; i < k; i++) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}
