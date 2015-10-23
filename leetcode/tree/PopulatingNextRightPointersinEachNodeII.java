package tree;

public class PopulatingNextRightPointersinEachNodeII {

	public void connect(TreeLinkNode parent) {
		if (parent == null)
			return;
		if (parent.next == null) {
			if (parent.right != null) {
				connect(parent.right);
			}
			if (parent.left != null) {
				parent.left.next = parent.right;
				connect(parent.left);
			}
		} else {
			if (parent.left != null || parent.right != null) {
				TreeLinkNode temp = parent.next;
				while (temp != null && temp.left == null && temp.right == null) {
					temp = temp.next;
				}
				if (temp != null) {
					if (parent.right != null) {
						if (temp.left != null)
							parent.right.next = temp.left;
						else
							parent.right.next = temp.right;
						connect(parent.right);
						if (parent.left != null) {
							parent.left.next = parent.right;
							connect(parent.left);
						}
					} else {
						if (temp.left != null)
							parent.left.next = temp.left;
						else
							parent.left.next = temp.right;

						connect(parent.left);
					}
				}else{
					connect(parent.right);
					if(parent.left!=null)
						parent.left.next=parent.right;
					connect(parent.left);
				}
			}
		}
	}
	
	public static void main(String[]args){
		TreeLinkNode a1=new TreeLinkNode(1);
		TreeLinkNode a2=new TreeLinkNode(2);
		TreeLinkNode a3=new TreeLinkNode(3);
		TreeLinkNode a4=new TreeLinkNode(4);
		TreeLinkNode a5=new TreeLinkNode(5);
		TreeLinkNode a6=new TreeLinkNode(6);
		TreeLinkNode a7=new TreeLinkNode(7);
		a1.left=a2;
		a1.right=a3;
		a3.left=a4;
		a3.right=a5;
		a4.right=a6;
		a6.left=a7;
		PopulatingNextRightPointersinEachNodeII test=new PopulatingNextRightPointersinEachNodeII();
		test.connect(a1);
		a1.toString();
	}
}
