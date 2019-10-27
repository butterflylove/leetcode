import java.util.Stack;

/**
 * Created by zhangtianlong on 19/10/27.
 */
public class SQueue<T> {
    private Stack<T> stack1 = new Stack<>();
    private Stack<T> stack2 = new Stack<>();

    public T deleteHead() {
        if (stack2.size() <= 0) {
            while (stack1.size() > 0) {
                T data = stack1.peek();
                stack1.pop();
                stack2.push(data);
            }
        }

        if (stack2.size() <= 0) {
            throw new RuntimeException("queue is empty");
        }
        T head = stack2.peek();
        stack2.pop();
        return head;
    }

    public void appendTail(T element) {
        stack1.push(element);
    }

    public static void main(String[] args) {
        SQueue<Integer> queue = new SQueue<>();
        queue.appendTail(1);
        queue.appendTail(2);
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
    }
}
