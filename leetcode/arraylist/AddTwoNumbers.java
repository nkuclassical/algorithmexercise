package arraylist;

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode listnode = new ListNode(0);
		ListNode newlistnode = listnode;
		int inc = 0;
		while (l1 != null && l2 != null) {

			int temp = l1.val + l2.val + inc;
			inc = temp / 10;
			ListNode tempnode = new ListNode(temp % 10);
			listnode.next = tempnode;
			listnode = listnode.next;
			l1 = l1.next;
			l2 = l2.next;
		}
		while (l1 != null && l2 == null) {
			int temp = l1.val + inc;
			inc = temp / 10;
			ListNode tempnode = new ListNode(temp % 10);
			listnode.next = tempnode;
			listnode = listnode.next;
			l1 = l1.next;
		}
		while (l2 != null && l1 == null) {
			int temp = l2.val + inc;
			inc = temp / 10;
			ListNode tempnode = new ListNode(temp % 10);
			listnode.next = tempnode;
			listnode = listnode.next;
			l2 = l2.next;
		}

		if (inc > 0) {
			ListNode tempnode = new ListNode(inc);
			listnode.next = tempnode;
		}

		return newlistnode.next;
	}

	public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(-1);
		ListNode cur=head;
		int inc = 0;
		while ((l1 != null) && (l2 != null)) {
			int sum = l1.val + l2.val + inc;
			cur.next = new ListNode(sum % 10);
			inc = sum / 10;
			l1 = l1.next;
			l2 = l2.next;
			cur=cur.next;
		}
		
		while (l1 != null) {
			int sum = l1.val + inc;
			cur.next = new ListNode(sum % 10);
			inc = sum / 10;
			l1 = l1.next;
			cur=cur.next;
		}
		
		while (l2 != null) {
			int sum = l2.val + inc;
			cur.next = new ListNode(sum % 10);
			inc = sum / 10;
			l2 = l2.next;
			cur=cur.next;
		}

		return head.next;
	}

	public static void main(String[] args) {
		ListNode a = new ListNode(2);
		ListNode abak = a;
		a.next = new ListNode(4);
		a = a.next;
//		a.next = new ListNode(3);
//		a = a.next;

		ListNode b = new ListNode(5);
		ListNode bbak = b;
		b.next = new ListNode(6);
		b = b.next;
		b.next = new ListNode(4);
		b = b.next;

		AddTwoNumbers test = new AddTwoNumbers();
		ListNode newa = test.addTwoNumbers2(abak, bbak);
		while (newa != null) {
			System.out.println(newa.val);
			newa = newa.next;
		}
	}
}
