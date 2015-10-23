package linkedlist;

import java.util.LinkedList;

import tree.TreeNode;

public class ConvertSortedListtoBinarySearchTree {
	public TreeNode sortedListToBST(ListNode head) { //wrong method!
		if (head == null)
			return null;

		ListNode fast = head;
		ListNode slow = head;
		ListNode temp = null;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			temp = slow;
			slow = slow.next;
		}
		ListNode right = slow.next;
		if (temp != null)
			temp.next = null;
		else
			head = null;
		TreeNode ret = new TreeNode(slow.val);
		ret.left = sortedListToBST(head);
		ret.right = sortedListToBST(slow.next);
		return ret;
	}

    public TreeNode sortedListToBST2(ListNode head) {//good!
        if(head==null)return null;
        if(head.next==null)return new TreeNode(head.val);
        if(head.next.next==null){
            TreeNode root=new TreeNode(head.val);
            root.right=new TreeNode(head.next.val);
            return root;
        }else{
            ListNode fast=head,slow=head, prev=null;
            while(fast.next!=null&&fast.next.next!=null){
                prev=slow;
                fast=fast.next.next;
                slow=slow.next;
            }
            TreeNode root=new TreeNode(slow.val);
            if(prev!=null)
                prev.next=null;
            else head=null;
            root.left=sortedListToBST(head);    
            root.right=sortedListToBST(slow.next);
            return root;
        }
    }
	public static void main(String[] args) {
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(2);
		ListNode a3 = new ListNode(3);
		ListNode a4 = new ListNode(4);
		ListNode a5 = new ListNode(5);
		ListNode a6 = new ListNode(6);
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;
		a5.next = a6;
		ConvertSortedListtoBinarySearchTree test = new ConvertSortedListtoBinarySearchTree();
		TreeNode result = test.sortedListToBST(a1);
		result.toString();
	}
}
