package sort;

import linkedlist.ListNode;

public class SortList {
//	public ListNode sortList(ListNode head) {
//		if(head==null||head.next==null)return head;
//		ListNode fast=head,slow=head,prev=head;
//		while(fast!=null&&fast.next!=null){
//			fast=fast.next.next;
//			prev=slow;
//			slow=slow.next;
//		}
//		prev.next=null;
//		
//		ListNode l1=sortList(head);
//		ListNode l2=sortList(slow);
//		
//		return merge(l1,l2); 
//	}
//	public ListNode merge(ListNode l1,ListNode l2){
//		if(l1==null)return l2;
//		if(l2==null)return l1;
//		ListNode ret=new ListNode(-1),p=ret;
//		while(l1!=null&&l2!=null){
//			if(l1.val<=l2.val){
//				p.next=l1;
//				l1=l1.next;
//			}else{
//				p.next=l2;
//				l2=l2.next;
//			}
//			p=p.next;
//		}
//		if(l1!=null)p.next=l1;
//		if(l2!=null)p.next=l2;
//		return ret.next;
//	}
	 public ListNode sortList(ListNode head) {
	        if(head==null)return null;
	        else if(head.next==null)return head;
	        else{
	            ListNode slow=head, fast=head;
	            while(fast.next!=null&&fast.next.next!=null){
	                fast=fast.next.next;
	                slow=slow.next;
	            }
	            
	            ListNode right=sortList(slow.next);
	            slow.next=null;
	            ListNode left=sortList(head);
	            return merge(left,right);
	        }
	    }
	    
	    public ListNode merge(ListNode l1, ListNode l2){
	        ListNode ret=new ListNode(-1);
	        ListNode cur=ret;
	        while(l1!=null&&l2!=null){
	            if(l1.val<=l2.val){
	                cur.next=l1;
	                l1=l1.next;
	            }else{
	                cur.next=l2;
	                l2=l2.next;
	            }
	            cur=cur.next;
	        }
	        if(l1!=null){
	            cur.next=l1;
	        }else{
	            cur.next=l2;
	        }
	        return ret.next;
	    }
	public static void main(String[]args){
		SortList test=new SortList();
		ListNode list=new ListNode(5);
		ListNode l=list;
		l.next=new ListNode(4);
		l=l.next;
		l.next=new ListNode(10);
		l=l.next;
		l.next=new ListNode(1);
		l=l.next;
		l.next=new ListNode(7);
		l=l.next;
		l.next=new ListNode(90);
		l=l.next;
		l.next=new ListNode(3);
		l=l.next;
		l.next=new ListNode(8);
		l=l.next;
		l=test.sortList(list);
		while(l!=null){
			System.out.println(l.val);
			l=l.next;
		}
	}
}
