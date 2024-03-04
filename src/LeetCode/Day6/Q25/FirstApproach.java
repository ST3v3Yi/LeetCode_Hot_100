package LeetCode.Day6.Q25;

public class FirstApproach {
    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        int count = 0;
        while (curr != null) {
            count++;
            // 当 count 是 k 的倍数时，翻转从 prev 到 curr 的 k 个节点
            if (count % k == 0) {
                prev = reverseList(prev, curr.next); // 翻转从 prev 到 curr 的 k 个节点
                curr = prev.next; // 更新 curr 指针为翻转后的下一个节点
            } else {
                curr = curr.next; // 否则继续遍历链表
            }
        }
        return dummy.next;
    }
    private ListNode reverseList(ListNode start, ListNode end) {
        ListNode prev = start.next;
        ListNode curr = prev.next;
        while (curr != end) {
            prev.next = curr.next;
            curr.next = start.next;
            start.next = curr;
            curr = prev.next;
        }
        return prev;
    }
}
