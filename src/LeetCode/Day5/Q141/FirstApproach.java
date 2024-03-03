package LeetCode.Day5.Q141;

import java.util.*;

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
        System.out.println(hasCycle(head));
    }
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
