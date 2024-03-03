package LeetCode.Day5.Q234;

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
        isPalindrome(head);
    }
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode prev = null;
        ListNode curr = head;
        while (curr != slow) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        while (prev != null && slow != null) {
            if (prev.val != slow.val) {
                return false;
            }
            prev = prev.next;
            slow = slow.next;
        }
        return true;
    }
}
