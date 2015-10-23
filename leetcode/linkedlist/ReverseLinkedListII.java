package linkedlist;

public class ReverseLinkedListII {
//	public ListNode reverseBetween(ListNode head, int m, int n) {
//		if(head==null||head.next==null)return head;
//		ListNode newlist=new ListNode(-1);
//		newlist.next=head;
//		ListNode cur=newlist;
//		for(int i=1;i<m;i++){
//			cur=cur.next;
//		}
//		ListNode left=cur;
//		ListNode left2=cur.next;
//		ListNode prev=null;
//		ListNode next=null;
//		cur=cur.next;
//		for(int i=m;i<=n;i++){
//			next=cur.next;
//			cur.next=prev;
//			prev=cur;
//			cur=next;
//		}
//		left.next=prev;
//		left2.next=cur;
//		return newlist.next;
//		
//	}
	
	
	public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m==n)return head;
        ListNode newhead=new ListNode(-1);
        newhead.next=head;
        head=newhead;
        ListNode cur=head, prev=null, next=null;
        for(int i=0;i<m-1;i++){
            cur=cur.next;
        }
        ListNode start=cur;
        cur=cur.next;
        ListNode end=cur;
        for(int i=m;i<=n;i++){
            next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        start.next=prev;
        end.next=cur;
        return head.next;
    }
	public static void main(String[]args){
		ListNode a1=new ListNode(1);
		ListNode a2=new ListNode(2);
		ListNode a3=new ListNode(3);
//		ListNode a4=new ListNode(4);
//		ListNode a5=new ListNode(5);
//		
		a1.next=a2;
		a2.next=a3;
//		a3.next=a4;
//		a4.next=a5;
		ReverseLinkedListII test=new ReverseLinkedListII();
		ListNode r=test.reverseBetween(a1, 1, 2);
		while(r!=null){
			System.out.println(r.val);
			r=r.next;
		}
	}
}
