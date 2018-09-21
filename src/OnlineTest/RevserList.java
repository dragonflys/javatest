package OnlineTest;
/**
 * 反转链表
 * @author wangyanlong
 *
 */
public class RevserList {
	public static Node reverse(Node head){
		if (head == null) {
			return null;
		}
		Node current = head;
		Node pPre = null;
		Node pNext = null;
		while (current != null) {
			pNext = current.next;
			if (pNext.next == null) {
				head = current;
			}
			current.next = pPre;
			pPre = current;
			current = pNext;
					
		}
		return head;
	}
}
