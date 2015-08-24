/**
Smaller Biggest Problem another solution.
*/
class SmallerBiggestPramp {
   
   public static void main(String[] args) {
      String pramp = "Practice Makes Perfect";
      System.out.println(pramp);
      
      traverse(root, 19, -1);
   }
   
   public static Node traverse(Node root, int value, int n) {
      
      if (root == null) {         
         return;
      }
      if (root.key < value && root.key > n ) {
         n = root.key;
      }
      if (value < root.key) {
         traverse(root.left, value, n);
      }
      else {
         traverse(root.right, value, n);
      }
      

   }
   
}
 
   