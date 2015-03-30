package practice;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
    	if(root==null) return false;
        return mySum(root, 0, sum);
    }
    
    public static boolean mySum(TreeNode node,int temp,int sum){   	
    	if(node.left==null&&node.right==null){
    		if((temp+node.val)==sum) return true;
    		else return false;
    	}else{
    		boolean x=false,y=false;
    		if(node.left!=null){
    			x=mySum(node.left, temp+node.val, sum);
    		}
    		if(node.right!=null){
    			y=mySum(node.right, temp+node.val, sum);
    		}
    		return x||y;
    	}
    }
}
