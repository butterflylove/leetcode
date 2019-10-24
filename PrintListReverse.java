import java.util.Stack;

public class PrintListReverse {

    public static void printListReverse(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode cur = head;
        Stack<ListNode> stack = new Stack<>();
        while (cur != null) {
            stack.push(cur);
            cur = cur.getNext();
        }
        while (!stack.isEmpty()) {
            ListNode top = stack.peek();
            System.out.println(top);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        ListNode x = new ListNode(1);
        ListNode y = new ListNode(2, x);
        printListReverse(y);
    }

}

class ListNode {
    private int val;
    private ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public ListNode setVal(int val) {
        this.val = val;
        return this;
    }

    public ListNode getNext() {
        return next;
    }

    public ListNode setNext(ListNode next) {
        this.next = next;
        return this;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}
