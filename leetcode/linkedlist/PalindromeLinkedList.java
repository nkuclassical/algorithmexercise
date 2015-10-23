package linkedlist;

public class PalindromeLinkedList {
	public boolean isPalindrome(ListNode head) {
		if (head == null)
			return false;
		int len = 0;
		ListNode cur = head;
		while (cur != null) {
			cur = cur.next;
			len++;
		}
		ListNode next = null;
		ListNode pre = null;
		cur = head;
		for (int i = 0; i < len / 2; i++) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		
		if (len % 2 == 1)
			cur = cur.next;
		while (cur != null) {
			if(cur.val==pre.val){
				cur=cur.next;
				pre=pre.next;
			}else{
				return false;
			}
		}
		return true;
	}
	public boolean isPalindrome2(ListNode head) {
        if(head==null)return true;
        ListNode slow=head, fast=head;
        while(fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode mid=slow;
        slow=slow.next;
        mid.next=null;
        ListNode prev=null, next=slow;
        while(slow!=null){
            next=slow.next;
            slow.next=prev;
            prev=slow;
            slow=next;
        }
        // mid.next=prev;
        slow=head;
        fast=prev;
        while(slow!=null&&fast!=null){
            if(slow.val==fast.val){
                slow=slow.next;
                fast=fast.next;
            }else return false;
        }
        return true;
    }
	public static void main(String[]args){
		
		PalindromeLinkedList test=new PalindromeLinkedList();
		ListNode a11=new ListNode(1);
//		ListNode a31=new ListNode(3);
//		ListNode a21=new ListNode(2);
//		ListNode a41=new ListNode(4);
//		ListNode a51=new ListNode(4);
//		ListNode a22=new ListNode(2);
//		ListNode a32=new ListNode(3);
//		ListNode a12=new ListNode(1);
//		a11.next=a31;
//		a31.next=a21;
//		a21.next=a41;
//		a41.next=a51;
//		a51.next=a22;
//		a22.next=a32;
//		a32.next=a12;
		System.out.println(test.isPalindrome2(a11));
		
	}
	
}
