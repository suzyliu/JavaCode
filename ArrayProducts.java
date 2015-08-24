/*Given an array of integers arr, write a function that returns another array at 
the same length where the value at each index i is the product of all array values 
except arr[i].
Solve without using division and analyze the runtime and space complexity

Example: given the array [2, 7, 3, 4]
your function would return: [84, 24, 56, 42] 
(by calculating: [7*3*4, 2*3*4, 2*7*4, 2*7*3])
*/


import java.util.*;
class ArrayProducts  {
 	public static void main(String[] args) {
 		int arr[]={2, 7, 3, 4};
		for(int item:calculateProducts(arr))
			System.out.printf(item+" ");
		System.out.println();
	}
	static int[] calculateProducts(int[] arr){
		//brute-force.
		int[] newArray=new int[arr.length];
		Arrays.fill(newArray,1);
		int product=1;
		for(int i=0;i<arr.length;i++){
			newArray[i] *=product;
			product*= arr[i];	//*i for i+1
		}
		//System.out.println("newArray[3]="+newArray[3]);
		product=1;
		for(int i=arr.length-1;i>=0;i--){
			newArray[i] *=product;
			product*= arr[i];	//*i for i+1
		}
		return newArray;
	}
}

