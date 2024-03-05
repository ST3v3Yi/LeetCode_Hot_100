package LeetCode.Day7.Q148;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FirstApproach {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        List<Integer> sortedList = new ArrayList<>();
        while (head != null) {
            sortedList.add(head.val);
            head = head.next;
        }
        Collections.sort(sortedList);
        ListNode res = new ListNode();
        ListNode iter = res;
        for (int num : sortedList) {
            iter.next = new ListNode(num);
            iter = iter.next;
        }
        return res.next;
    }
}
