/*Given a tree, find the largest value by calculating any combination of subtracting B from A, 
where A is the ancestor of B. For example:
Start coding here:
*/
public class Node {
	int value;
	Node left;
	Node right;
}
public class MaxDiff{

	public void main(){
	
	}
	public int getMaxDiff(Node root) {
		if(root ==null) return 0;
		return Math.max(getDiff(n.left, root.value),getDiff(n.right, root.value));
		
	}
	public int getDiff(Node n, int currentMax){
		
		if(n.value > currentMax) currentMax=n.value;
		int diff1 = currentMax-n.value;
		int diff2;
		if(n.left == null && n.right ==null) return diff1;
		else if(n.left ==null && n.right != null){
			diff2 = getDiff(n.right, currentMax);
		}else if(n.left !=null && n.right == null){
			diff2 = getDiff(n.left, currentMax);
		}else 
			diff2 = Math.max(getDiff(n.left, currentMax),getDiff(n.right, currentMax));
		return Math.max(diff1,diff2);
	}
}