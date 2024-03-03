package LeetCode.Day5.Q206;

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
    public void justTest() {
        ListNode head = new ListNode();
        reverseList(head);
    }
    public ListNode reverseList(ListNode head) {
        // 如果链表为空或者只有一个节点，无需反转，直接返回头节点
        if (head == null || head.next == null) {
            return head;
        }

        ListNode tmp1 = head;
        ListNode tmp2 = head.next;
        ListNode tmp3 = null;

        while (tmp2 != null) {
            tmp3 = tmp2.next; // 暂存 tmp2 的下一个节点
            tmp2.next = tmp1; // 反转指针方向

            // 移动到下一组节点
            tmp1 = tmp2;
            tmp2 = tmp3;
        }

        head.next = null; // 原始头节点的下一个节点应为 null，成为反转后链表的尾部
        return tmp1; // 反转后链表的新头节点
    }
}
