package linkedlist;

public class SwapNodesinPairs {
	public ListNode swapPairs(ListNode head) {
		if (head == null)
			return head;
		ListNode ret = new ListNode(-1);
		ret.next = head;
		ListNode before = ret;
		ListNode cur = head;
		ListNode curnext = cur.next;
		while (curnext != null) {
			ListNode temp = curnext.next;
			before.next = curnext;
			curnext.next = cur;
			cur.next = temp;
			before = cur;
			cur = cur.next;
			if (cur != null)
				curnext = cur.next;
			else
				break;
		}
		return ret.next;
	}
	public static void main(String[]args){
		ListNode a1=new ListNode(1);
		ListNode a2=new ListNode(2);
		ListNode a3=new ListNode(3);
//		ListNode a4=new ListNode(4);
		a1.next=a2;
		a2.next=a3;
//		a3.next=a4;
		SwapNodesinPairs test=new SwapNodesinPairs();
		ListNode result=test.swapPairs(a1);
		while(result!=null){
			System.out.println(result.val);
			result=result.next;
		}
	}
}
