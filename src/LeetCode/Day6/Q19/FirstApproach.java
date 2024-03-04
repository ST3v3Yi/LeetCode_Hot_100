package LeetCode.Day6.Q19;

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
    public void Test() {
        ListNode head = new ListNode();
        int n = 0;
        removeNthFromEnd(head, n);
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 判断链表是否为空或只有一个节点，或者需要删除的是头节点
        if (head == null || (head.next == null && n == 1)) {
            return null;
        }

        // 初始化快指针和慢指针，均指向链表头节点
        ListNode fast = head; // 快指针，用于先行移动n步
        ListNode slow = head; // 慢指针，用于定位需要删除节点的前一个节点

        // 快指针先向前移动n个节点
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // 如果快指针为空，说明要删除的是头节点，直接返回头节点的下一个节点
        if (fast == null) {
            return head.next;
        }

        // 移动快慢指针，直到快指针指向链表末尾的下一个节点
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // 删除慢指针的下一个节点（即要删除的节点）
        slow.next = slow.next.next;

        // 返回头节点
        return head;
    }
}
