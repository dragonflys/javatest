package OnlineTest;

public class BinarySortTree {

	/**
	 * 利用迭代法遍历二叉排序树
	 * 
	 * @param root
	 * @param key
	 * @return
	 */
	public static TreeNode binarySortTree(TreeNode root, int key) {
		if (root == null) {
			return null;
		}
		TreeNode temp = root;
		while (temp.val != key) {// 当temp.val == key时退出循环，temp就是要找的结点，当没找到key时，
			if (key < temp.val) {
				temp = temp.left;
			} else if (key > temp.val) {
				temp = temp.right;
			}

			if (temp == null) {// 当没找到key时，temp已遍历到叶子结点的left或right，
								// 此时temp == null，如果不在while体内结束循环，会进入死循环
				return null;
			}
		}

		return temp;
	}

	/**
	 * 递归遍历二叉查找树查找key
	 * 
	 * @param root
	 * @param key
	 * @return
	 */
	public static TreeNode binarySortTree2(TreeNode root, int key) {
		if (root == null) {
			return null;
		}
		if (key < root.val) {
			return binarySortTree2(root.left, key);
		} else if (key > root.val) {
			return binarySortTree2(root.right, key);
		}
		
		return root;
	}

	/**
	 * 递归遍历二叉排序树查找key
	 * 
	 * @param root
	 * @param key
	 * @return
	 */
	public static TreeNode binarySortTree3(TreeNode root, int key) {
		if (root == null) {
			return null;
		}

		if (key < root.val) {
			root = binarySortTree3(root.left, key);
		} else if (key > root.val) {
			root = binarySortTree3(root.right, key);
		}

		return root;

	}

}
