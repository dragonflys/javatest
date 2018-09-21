package OnlineTest;

import java.util.ArrayDeque;

/**
 * 深度优先遍历
 * 利用Stack栈的后进先出特性实现
 * @author wangyanlong
 *
 */
public class PrintDepth {
	public void printDepth(TreeNode root){
		if (root == null) {
			return;
		}
		ArrayDeque<TreeNode> stack = new ArrayDeque<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode temp = stack.pop();
			System.out.println(temp.val);
			if (temp.right != null) {
				stack.push(temp.right);
			}
			if (temp.left != null) {
				stack.push(temp.left);
			}
			
		}
					
	}
}
