package OnlineTest;

/**
 * 递归求二叉树的深度
 * 
 * @author wangyanlong
 *
 */
public class TreeDepth {
	public static int treeDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int leftSubtreeDepth = treeDepth(root.left);// 一个结点左子树的深度
		int rightSubtreeDepth = treeDepth(root.right);// 一个结点右子树的深度

		return (leftSubtreeDepth > rightSubtreeDepth) ? (leftSubtreeDepth + 1) : (rightSubtreeDepth + 1);

	}
}
