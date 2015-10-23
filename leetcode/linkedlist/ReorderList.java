package linkedlist;

public class ReorderList {
	public void reorderList(ListNode head) {
		if(head==null||head.next==null)return;
		ListNode fast=head,slow=head;
		while(fast.next!=null&&fast.next.next!=null){
			fast=fast.next.next;
			slow=slow.next;
		}
		ListNode mid=slow.next;
		slow.next=null;
		ListNode rightHalf=reverseList(mid);
		slow=head;
		fast=rightHalf;
		while(fast!=null){
			ListNode nextslow=slow.next;
			ListNode nextfast=fast.next;
			slow.next=fast;
			fast.next=nextslow;
			slow=nextslow;
			fast=nextfast;
		}
		
	}
	public ListNode reverseList(ListNode head){
		ListNode cur=head,next=null,prev=null;
		while(cur.next!=null){
			next=cur.next;
			cur.next=prev;
			prev=cur;
			cur=next;
		}
		cur.next=prev;
		return cur;
	}
	
	public static void main(String[]args){
		ReorderList test=new ReorderList();
		ListNode a1=new ListNode(1);
		ListNode a2=new ListNode(2);
		ListNode a3=new ListNode(3);
//		ListNode a4=new ListNode(4);
//		ListNode a5=new ListNode(5);
//		ListNode a6=new ListNode(6);
		a1.next=a2;
		a2.next=a3;
//		a3.next=a4;
//		a4.next=a5;
		
//		a5.next=a6;
		
		test.reorderList(a1);
		ListNode result=a1;
		while(result!=null){
			System.out.println(result.val);
			result=result.next;
		}
	}
}
