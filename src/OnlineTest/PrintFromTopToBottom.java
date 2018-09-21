package OnlineTest;

import java.util.ArrayDeque;

/**
 * 广度优先遍历二叉树
 * 利用队列的先进先出特性实现
 * @author wangyanlong
 *
 */
public class PrintFromTopToBottom {
	public void printFromTopToBottom(TreeNode root){
		if (root == null) {
			return;
		}
		ArrayDeque<TreeNode> queue = new ArrayDeque<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			System.out.println(temp.val);
			if (temp.left != null) {
				queue.offer(temp.left);
			}
			if (temp.right != null) {
				queue.offer(temp.right);
			}
		}
		
	}
}
