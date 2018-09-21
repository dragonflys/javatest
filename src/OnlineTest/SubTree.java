package OnlineTest;

public class SubTree {
	public static boolean hasSubTree(TreeNode root1,TreeNode root2){
		boolean flag = false;
		if(root1 != null && root2 != null){
			if (root1.val == root2.val) {
				flag = isSubTree(root1,root2);
			}
			if (!flag) {
				flag = hasSubTree(root1.left,root2);
			}
			if (!flag) {
				flag = hasSubTree(root1.right,root2);
			}
		}
		
		return flag;
	}
	public static boolean isSubTree(TreeNode root1,TreeNode root2){
		//tree1，tree2的遍历结束情况只能有三种可能
        //tree1,tree2同时遍历结束，tree1遍历结束tree2没有结束，tree1没有结束tree2遍历结束
		if (root1 == null && root2 != null) {//tree1遍历结束tree2没有结束
			return false;
		}
		if (root2 == null) {
			return true;
		}
		
		if (root1.val != root2.val) {
			return false;
		}
		return isSubTree(root1.left,root2.left) && isSubTree(root1.right,root2.right);
	}
}
