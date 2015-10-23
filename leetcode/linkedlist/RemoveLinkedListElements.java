package linkedlist;

public class RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int val) {
		ListNode newhead=new ListNode(-1);
		newhead.next=head;
		ListNode cur=newhead;
		while(cur.next!=null){
			if(cur.next.val==val){
				cur.next=cur.next.next;
			}else{
				cur=cur.next;
			}
		}
		return newhead.next;
	}
}
