/*
Getting a Different Number 

Question:

Given an array arr of n unique integers, how can you most efficiently find an integer that is not in the array?

Your solution should return such an integer or null if arr contains all possible integers.
Analyze the runtime and space complexity of your solution.

*/


import java.util.*;
public class GetAnotherNumber{
	public static void main(String[] args) {
		int[]a={-1*(Integer.MAX_VALUE-1),-3,-2,0,5,9,10};
		System.out.println(getNumber(a));
	}
	static int getNumber(int[] a){
		if(a.length == 2*Integer.MAX_VALUE) return -1;
		boolean[] checkedArray = new boolean[a.length+1];
		Arrays.fill(checkedArray,false);
		for(int i=0;i<a.length;i++){
			int num = a[i];
			if(num>=0) checkedArray[num%(checkedArray.length)]=true;	//only do the positive ones
			//make sure the range is 0-n.
		}
		for(int i=0;i<checkedArray.length;i++)
			if(checkedArray[i]==false) return i;
		
		return -1;
	}
}