/*This Class is a tree node for multiple children, not a binary one*/

public class TreeNode {
      int val;
      //TreeNode left;
      //TreeNode right;
      TreeNode[] children;
      TreeNode(int x) { val = x; }
      
     static TreeNode buildUpATree(TreeNode n){
		n.children = new TreeNode[3];
		int number =4;
		
		for(int i=0;i<n.children.length;i++){
			n.children[i]=new TreeNode(number);
			//System.out.println("Build a node with val: " +n.children[i].val);
			n.children[i].children = build4Children(n.children[i]);
			number+=10;
		}
		return n;
	}
	static TreeNode[] build4Children(TreeNode n){
		n.children = new TreeNode[4];
		int number =n.val;
		for(int i=0;i<n.children.length;i++){
			n.children[i]=new TreeNode(++number);
			//System.out.println("Build a node's child with val: " +n.children[i].val);
			n.children[i].children = new TreeNode[2];
			//test for one more layer.
			for(int j=0;j<2;j++)
				n.children[i].children[j]=new TreeNode(number+1);
		}
		return n.children;
	}

}