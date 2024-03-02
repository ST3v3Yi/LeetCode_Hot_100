package LeetCode.Day4.Q160;

import org.junit.Test;

import java.util.List;

public class FirstApproach {
    @Test
    public void justTest() {

    }
     private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
     }
     private ListNode getIntersectionNode(ListNode headA, ListNode headB) {
         while (headA != null) {
             ListNode tempB = headB; // 保存 headB 的引用，以便每次循环重新使用
             while (tempB != null) {
                 if (headA == tempB) {
                     return headA;
                 }
                 tempB = tempB.next;
             }
             headA = headA.next;
         }
         return null;
    }
}
