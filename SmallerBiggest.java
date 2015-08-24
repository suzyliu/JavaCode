import java.util.*;
public class SmallerBiggest {
   
    public static void main(String[] args) {
		BinaryNode root = new BinaryNode(10);
		//should build a binary search tree
		
		
		
    	//root=TreeNode.buildUpATree(root);  	//if this has multiple children
    	searchTree(root, 19);
    }   
    static BinaryNode searchTree(BinaryNode root, int x) {
		//do the search of x
		BinaryNode xNode = new BinaryNode(x);
		//searchLast(xNode);
		
		BinaryNode n=root;	//start from root
		BinaryNode lastLeft=null;
		while(n!=null){
			if(n.val > xNode.val){
				n=n.left;
				if(n.left !=null) lastLeft=n.left;
				//else if n is x, there is no value smaller than x.
			}else if(n.val == xNode.val){
				return lastLeft;
			}else{	//then the x is on the right.(bigger)
				
				n=n.right;
				lastLeft=n;
			}
		}
		//if goes to this line, mean failed.
		return null;
   }
    /*static BinaryNode searchLast(BinaryNode xNode) {
 		if (x.left != null) return x.left;
// 		else ;//do the rest of the search.
		return xNode;
	}*/
}