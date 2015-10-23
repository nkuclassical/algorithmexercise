package linkedlist;

public class RemoveNthNodeFromEndofList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(head==null)return head;
		ListNode newhead=new ListNode(-1);
		newhead.next=head;
		ListNode first=newhead;
		ListNode second=newhead;
		for(int i=0;i<n;i++){
			first=first.next;
		}
		while(first.next!=null){
			first=first.next;
			second=second.next;
		}
		second.next=second.next.next;
		return newhead.next;
	}
	public static void main(String[]args){
		ListNode a1=new ListNode(1);
		ListNode a5=new ListNode(5);
		ListNode a4=new ListNode(4);
		
		ListNode a3=new ListNode(3);
		ListNode a2=new ListNode(2);
		a4.next=a5;
		a3.next=a4;
		a2.next=a3;
		a1.next=a2;
		RemoveNthNodeFromEndofList test=new RemoveNthNodeFromEndofList();
		ListNode ret=test.removeNthFromEnd(a1, 2);
		while(ret!=null){
			System.out.println(ret.val);
			ret=ret.next;
		}
		System.out.println("finished!");
	}
}
