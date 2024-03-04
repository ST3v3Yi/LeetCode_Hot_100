package LeetCode.Day6.Q138;

public class FirstApproach {
    private class Node {
        int val;
        Node next;
        Node random;
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        // 创建复制的新链表，将新节点插入到每个原节点的后面
        Node curr = head;
        while (curr != null) {
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }
        // 设置复制节点的 random 指针
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        // 拆分原链表和复制链表
        curr = head;
        Node newHead = head.next;
        while (curr != null) {
            Node temp = curr.next;
            curr.next = temp.next;
            if (temp.next != null) {
                temp.next = temp.next.next;
            }
            curr = curr.next;
        }
        return newHead;
    }
}
