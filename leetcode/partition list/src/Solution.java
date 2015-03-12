class ListNode {
    int val;
    ListNode next;
    ListNode(int x){ 
    	val = x;
        next = null;
    }
}

public class Solution {
	
    public ListNode sortList(ListNode head) {	        
    	
    	return head;
    }
	    
	public static void main(String[]args)
    {
    	ListNode head=new ListNode(1);
    	ListNode cur=head;
    	cur.next=new ListNode(4);
    	cur=cur.next;
    	cur.next=new ListNode(3);
    	cur=cur.next;
    	cur.next=new ListNode(2);
    	cur=cur.next;
    	cur.next=new ListNode(5);
    	cur=cur.next;
    	Solution a=new Solution();
    	ListNode head2=a.partition(head, 3);
    	while(head2!=null)
    	{
    		System.out.println(head2.val);
    		head2=head2.next;
    	}
    	
    }
}