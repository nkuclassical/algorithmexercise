package linkedlist;

public class CopyListwithRandomPointer {
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null)
			return head;
		RandomListNode old = head;
		while (old != null) {
			RandomListNode copyNode = new RandomListNode(old.label);
			copyNode.random = old.random;
			copyNode.next = old.next;
			old.next = copyNode;
			old = old.next.next;
		}
		old = head;
		while (old != null) {
			if (old.random != null) {
				old.next.random = old.random.next;
			}
			old = old.next.next;
		}
		RandomListNode phead = new RandomListNode(-1);
		phead.next = head;
		RandomListNode newlist = phead;
		old = head;
		while (old != null) {
			phead.next = old.next;
			old.next = old.next.next;
			phead = phead.next;
			old = old.next;
		}
		return newlist.next;

	}
}
