package linkedlist;

public class ReverseNodesinKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || head.next == null)
			return head;
		ListNode cur = head, next, prev, prevtail, nexthead, thistail, thishead, cur2 = head;
		ListNode newhead = new ListNode(-1);
		newhead.next = head;
		prevtail = newhead;
		int i = 0;
		while (cur2 != null) {
			i++;
			cur2 = cur2.next;
			if (i == k) {
				thistail = cur;
				prev = null;
				next = null;
				while (i > 0) {
					next = cur.next;
					cur.next = prev;
					prev = cur;
					cur = next;
					i--;
				}
				thistail.next = next;
				prevtail.next = prev;
				prevtail=thistail;

			}
		}

		return newhead.next;
	}
	
	public static void main(String[]args){
		ReverseNodesinKGroup test=new ReverseNodesinKGroup();
		ListNode a1=new ListNode(1);
		ListNode a2=new ListNode(2);
		ListNode a3=new ListNode(3);
		ListNode a4=new ListNode(4);
		ListNode a5=new ListNode(5);
		a1.next=a2;
		a2.next=a3;
		a3.next=a4;
		a4.next=a5;
		ListNode head=test.reverseKGroup(a1, 1);
		while(head!=null){
			System.out.println(head.val);
			head=head.next;
		}
	}
}
