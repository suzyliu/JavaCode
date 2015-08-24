/* Array Index & Element Equality 

Question:
Given an array of sorted distinct integers named arr, write a function that returns 
an index i in arr for which arr[i] = i or -1 if no such index exists.

Implement the most efficient solution possible, prove the correctness of your solution 
and analyze its runtime complexity (in terms of n - the length of arr).
*/
import java.util.*;
public class FindMatchIndex{
	public static void main(String[] args){
		int[] arr = {-8,-5,-1,0,1,5};
		System.out.println(findMatchedOne(arr));
	}
	static int findMatchedOne(int[] arr)
	{
	//binary search???
		//int r=arr.length/2;
		int begin = 0;
		int end = arr.length;
		
		while(begin<end)
		{
			int r =Math.round((begin+end)/2);
			if(arr[r]==r) return r;
			else if(arr[r]>r) end=r-1;	//left
			else begin =r+1;				//right
		//for(int i=0;i<arr.length;i++)
			System.out.println("Begin= "+begin+" ,End= "+end+" ,r= "+r);
		}
		return -1;
	}
}