package OnlineTest;
/**
 * 使用递归合并两个链表
 * @author wangyanlong
 *
 */
public class MergeList {
	
	
	public static Node merge(Node head1,Node head2){
		if(head1 == null){
			return head2;
		}else if (head2 == null) {
			return head1;
		}
		Node head = null;
		if (head1.val < head2.val) {
			head = head1;
			head.next = merge(head.next, head2);
		}else if (head1.val < head2.val) {
			head = head2;
			head.next = merge(head1, head2.next);
		}
		return head;
	}
	
}
