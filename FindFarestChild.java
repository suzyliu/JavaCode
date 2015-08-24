/*
Try to use the same approach in the last question to count the continuous
 descendant in a tree. (Not just a binary tree, can be multiple branch.)*/
import java.util.*;
public class FindFarestChild{
	public static void main(String[] args){
		TreeNode root = new TreeNode(13);
		root =buildUpATree(root);
		int depth=1;
		System.out.println(searchTree(root,depth));
	}
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

	static int searchTree(TreeNode n,int depth){
		if(n==null) return depth;
		if(n.children == null) return depth;
		//System.out.println("n.children.length="+n.children.length);

		int max=depth;
		for(int i=0;i<n.children.length;i++){
		
		//for(TreeNode child: n.children){
			if(n.children[i]==null) System.out.println("NULL value in i="+i);
			//else	System.out.println("Current child: " +n.children[i].val);

			if((n.children[i].val-n.val)==1){
				int num = searchTree(n.children[i],depth+1);
				if(num>max) max=num;
			}else{
				int num = searchTree(n.children[i],1);
				if(num>max) max=num;
			}
		}
		return max;
	}
}