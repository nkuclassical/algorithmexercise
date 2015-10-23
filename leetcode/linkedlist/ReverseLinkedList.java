package linkedlist;

import java.util.ArrayList;
import java.util.Stack;

public class ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
		Stack<Integer>listnode=new Stack();
		while(head!=null){
			listnode.push(head.val);
			head=head.next;
		}
		ListNode newlist=new ListNode(-1);
		ListNode cur=newlist;
		while(!listnode.isEmpty()){
			ListNode temp=new ListNode(listnode.pop());
			cur.next=temp;
			cur=cur.next;
		}
		return newlist.next;
	}
	
	public ListNode reverseList2(ListNode head){
        if(head==null)return null;
        if(head.next==null)return head;
        if(head.next.next==null){
            ListNode node=head.next;
        	node.next=head;
            node.next.next=null;
            return node;
        }
        
        ListNode pre=head;
        ListNode cur=head.next;
        ListNode last=head.next.next;
        pre.next=null;
        while(last!=null){
            cur.next=pre;
            pre=cur;
            cur=last;
            last=last.next;
        }
        cur.next=pre;
        return cur;
	}
	
	
}
