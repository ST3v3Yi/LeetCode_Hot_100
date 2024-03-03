package LeetCode.Day5.Q142;

import java.util.HashSet;
import java.util.Set;

public class FirstApproach {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public void justTest() {
        ListNode head = new ListNode(5);
        detectCycle(head);
    }
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return head;
            }
            head = head.next;
        }
        return null;
    }
}
