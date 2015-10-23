package linkedlist;

public class RotateList {
	public ListNode rotateRight(ListNode head, int k) {
		if(head==null)return head;
		
		ListNode phead=head;
		int length=1;
		while(phead.next!=null){
			length++;
			phead=phead.next;
		}
		k%=length;
		if(k==0)return head;
		phead.next=head;
		phead=head;
		for(int i=1;i<length-k;i++){
			phead=phead.next;
		}
		head=phead.next;
		phead.next=null;
		return head;
	}
	public static void main(String[]args){
		RotateList test=new RotateList();
		ListNode a=new ListNode(5);
		ListNode b=new ListNode(4);
		ListNode c=new ListNode(3);
		ListNode d=new ListNode(2);
		ListNode e=new ListNode(1);
		b.next=a;
		c.next=b;
		d.next=c;
		e.next=d;
		ListNode ret=test.rotateRight(e, 24);
		while(ret!=null){
			System.out.println(ret.val);
			ret=ret.next;
		}
		
	}
}
