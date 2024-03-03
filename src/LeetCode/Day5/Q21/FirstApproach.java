package LeetCode.Day5.Q21;

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
        ListNode list1 = new ListNode();
        ListNode list2 = new ListNode();
        mergeTwoLists(list1, list2);
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(); // 创建一个虚拟头节点
        ListNode current = dummy; // 用于遍历结果链表

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next; // 更新 current 指针
        }

        // 处理某一个链表遍历完后，将另一个链表剩余部分连接到结果链表的末尾
        if (list1 != null) {
            current.next = list1;
        }
        if (list2 != null) {
            current.next = list2;
        }

        return dummy.next; // 返回虚拟头节点的下一个节点，即为合并后的链表的头节点
    }
}
