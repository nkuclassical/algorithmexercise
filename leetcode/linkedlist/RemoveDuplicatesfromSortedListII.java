package linkedlist;

public class RemoveDuplicatesfromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode newlist = new ListNode(-1);
		ListNode templist=new ListNode(-1);
		templist.next = head;
		ListNode cur = head;
		ListNode prev = newlist;
		while (cur != null) {
			if (cur.next != null && (cur.val == cur.next.val)) {
				while (cur.next != null && (cur.val == cur.next.val)) {
					cur.next = cur.next.next;
				}
				
			} else {
				prev.next = new ListNode(cur.val);
				prev=prev.next;
			}
			cur=cur.next;
		}
		return newlist.next;
	}
	
	public ListNode deleteDuplicates2(ListNode h) {  //better
        ListNode head=new ListNode(-1);
        head.next=h;
        ListNode cur=head;
        while(cur.next!=null&&cur.next.next!=null){
            if(cur.next.val==cur.next.next.val){
                int v=cur.next.val;
                while(cur.next!=null&&cur.next.val==v){
                    cur.next=cur.next.next;
                }
            }else{
                cur=cur.next;
            }
        }
        return head.next;
    }
	
	public static void main(String[]args){
		RemoveDuplicatesfromSortedListII test=new RemoveDuplicatesfromSortedListII();
//		ListNode a=new ListNode(3);
		ListNode a1=new ListNode(2);
//		a1.next=a;
		ListNode b1=new ListNode(2);
		b1.next=a1;
		ListNode a2=new ListNode(1);
		a2.next=b1;
//		ListNode a3=new ListNode(1);
//		a3.next=a2;
//		ListNode a4=new ListNode(1);
//		a4.next=a3;
		ListNode ret=test.deleteDuplicates(a2);
		while(ret!=null){
			System.out.println(ret.val);
			ret=ret.next;
		}
		
	}
}
