import java.util.ArrayList;
import java.util.List;

public class ConstructBinaryTree {

    public static TreeNode construct(List<Integer> preOrder, List<Integer> inOrder, int length) {
        if (preOrder == null || inOrder == null || length <= 0) {
            return null;
        }
        return constructCore(preOrder, inOrder);
    }

    public static TreeNode constructCore(List<Integer> preOrder, List<Integer> inOrder) {
        int rootVal = preOrder.get(0);
        TreeNode root = new TreeNode(rootVal, null, null);
        if (preOrder.size() == 1) {
            if (inOrder.size() == 1 && preOrder.get(0).equals(inOrder.get(0))) {
                return root;
            } else {
                throw new RuntimeException("invalid input.");
            }
        }
        // 找到中序遍历中的根节点
        int rootIndexOfInOrder = 0;
        while (rootVal != inOrder.get(rootIndexOfInOrder) && rootIndexOfInOrder < inOrder.size()) {
            rootIndexOfInOrder++;
        }
        if (rootIndexOfInOrder == inOrder.size()) {
            throw new RuntimeException("invalid input.");
        }
        int leftStart = 0;
        int leftEnd = rootIndexOfInOrder;
        int rightStart = rootIndexOfInOrder + 1;
        int rightEnd = inOrder.size();

        int leftStartPre = 1;
        int leftEndPre = leftStartPre + (leftEnd - leftStart);
        int rightStartPre = leftEndPre;
        int rightEndPre = inOrder.size();
        if (leftStart < leftEnd) {
            TreeNode left = constructCore(preOrder.subList(leftStartPre, leftEndPre), inOrder.subList(leftStart, leftEnd));
            root.setLeft(left);
        }
        if (rightStart < rightEnd) {
            TreeNode right = constructCore(preOrder.subList(rightStartPre, rightEndPre), inOrder.subList(rightStart, rightEnd));
            root.setRight(right);
        }
        return root;
    }

    public static void main(String[] args) {
        List<Integer> pre = new ArrayList<>();
        pre.add(1);
        pre.add(2);
        pre.add(4);
        pre.add(7);
        pre.add(3);
        pre.add(5);
        pre.add(6);
        pre.add(8);

        List<Integer> inO = new ArrayList<>();
        inO.add(4);
        inO.add(7);
        inO.add(2);
        inO.add(1);
        inO.add(5);
        inO.add(3);
        inO.add(8);
        inO.add(6);

        TreeNode root = construct(pre, inO, 8);
        PreOrderNonRecursive.inOrderNonRecursive(root);
    }

}
