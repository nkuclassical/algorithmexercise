package linkedlist;

public class IntersectionofTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA==null||headB==null)return null;
		ListNode la = headA;
		int countA = 1, countB = 1;
		while (la.next != null) {
			la = la.next;
			countA++;
		}
		ListNode lb = headB;
		while (lb.next != null) {
			lb = lb.next;
			countB++;
		}
		int diff = Math.abs(countA - countB);
		ListNode fast = headA;
		ListNode slow = headB;
		if (countA < countB) {
			fast = headB;
			slow = headA;
		}
		for (int i = 0; i < diff; i++) {
			fast = fast.next;
		}
		while (fast != null && fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}
		return fast;

	}

	public static void main(String[] args) {
		IntersectionofTwoLinkedLists test = new IntersectionofTwoLinkedLists();
		ListNode a1 = new ListNode(1);
		// ListNode a3=new ListNode(3);
		// ListNode a5=new ListNode(5);
		// ListNode a7=new ListNode(7);
		// ListNode a9=new ListNode(9);
		// ListNode a11=new ListNode(11);
		// a1.next=a3;
		// a3.next=a5;
		// a5.next=a7;
		// a7.next=a9;
		// a9.next=a11;
		ListNode a2 = new ListNode(2);
		// ListNode a4=new ListNode(4);
		// ListNode a6=new ListNode(6);
		a2.next = a1;
		// a4.next=a6;
		// a6.next=a7;
		ListNode result = test.getIntersectionNode(a1, a2);
		System.out.println(result.val);
	}
}
