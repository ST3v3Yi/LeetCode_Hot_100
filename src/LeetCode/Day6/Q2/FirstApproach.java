package LeetCode.Day6.Q2;

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
        ListNode l1 = new ListNode();
        ListNode l2 = new ListNode();
        addTwoNumbers(l1, l2);
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 创建一个虚拟节点作为结果链表的起始节点
        ListNode dummy = new ListNode(0);
        // current节点用于遍历结果链表，初始化为dummy节点
        ListNode current = dummy;
        // carry用于保存进位值，初始化为0
        int carry = 0;

        // 遍历l1和l2，直到两个链表都遍历完毕
        while (l1 != null || l2 != null) {
            // sum用于保存当前位置上的节点值之和，初始值为carry
            int sum = carry;
            // 如果l1当前节点不为空，则将其值加到sum中，并将l1指针向后移动一位
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            // 如果l2当前节点不为空，则将其值加到sum中，并将l2指针向后移动一位
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            // 创建新节点，值为sum对10取余，连接到结果链表上
            current.next = new ListNode(sum % 10);
            // 更新进位值，sum除以10取整，得到进位值
            carry = sum / 10;
            // 移动current指针到下一个节点
            current = current.next;
        }

        // 如果最后还有进位，需要在结果链表末尾添加一个新节点
        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        // 返回结果链表的起始节点（即dummy节点的下一个节点）
        return dummy.next;
    }
}
