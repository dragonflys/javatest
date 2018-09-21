package OnlineTest;
/**
 * 求链表倒数第k个元素
 * @author wangyanlong
 *
 */
public class FindKthToTail {
	public static Node findKthToTail(Node head,int k){
		if (head == null || k <= 0) {
			return null;
		}
		Node temp = head;
		for(int i = 1;i < k;i++){
			if(temp.next != null){
				temp = temp.next;
			}else {//当k大于链表的长度，temp向后移动k为null，直接返回null
				return null;
			}
		}
		while (temp.next != null) {
			temp = temp.next;
			head = head.next;
		}
		return head;
	}
}
