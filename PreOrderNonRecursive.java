import java.util.Stack;

public class PreOrderNonRecursive {

    public static void main(String[] args) {
        TreeNode x = new TreeNode(1 , null, null);
        TreeNode y = new TreeNode(2, null, null);
        TreeNode z = new TreeNode(3, x, y);
        TreeNode w = new TreeNode(4, z, null);
        postOrderNonRecursive(w);
    }

    public static void preOrderNonRecursive(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            System.out.println(cur.getVal());
            if (cur.getRight() != null) {
                stack.push(cur.getRight());
            }
            if (cur.getLeft() != null) {
                stack.push(cur.getLeft());
            }
        }
    }

    public static void inOrderNonRecursive(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.getLeft();
            } else {
                cur = stack.pop();
                System.out.println(cur.getVal());
                cur = cur.getRight();
            }
        }
    }

    public static void postOrderNonRecursive(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode lastVisit = cur;
        while (!stack.isEmpty() || cur != null) {
            // 一直向左遍历
            while (cur != null) {
                stack.push(cur);
                cur = cur.getLeft();
            }
            // 获取栈顶元素
            cur = stack.peek();
            // 若cur 的right 为空 或者 等于lastVsit，则输出当前节点
            if (cur.getRight() == null || cur.getRight() == lastVisit) {
                System.out.println(cur.getVal());
                stack.pop();
                lastVisit = cur;
                cur = null;
            } else {
                cur = cur.getRight();
            }
        }
    }
}

class TreeNode {
    private int val;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public int getVal() {
        return val;
    }

    public TreeNode setVal(int val) {
        this.val = val;
        return this;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode setLeft(TreeNode left) {
        this.left = left;
        return this;
    }

    public TreeNode getRight() {
        return right;
    }

    public TreeNode setRight(TreeNode right) {
        this.right = right;
        return this;
    }
}
