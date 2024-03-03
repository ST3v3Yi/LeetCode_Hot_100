package LeetCode.Day5.Q141;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SecondApproach {
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
        System.out.println(hasCycle(head));
    }
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
