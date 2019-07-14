package edu.xidian.OnlineTest;

/**
 * 递归实现逆向输出链表元素
 * @author wangyanlong
 *
 */
public class PrintListReverse {
	public static void printListReverse(Node head){
		if(head == null){
			return;
		}
		if (head.next != null) {
			printListReverse(head.next);
		}
		System.out.println(head.val);
	}
}
