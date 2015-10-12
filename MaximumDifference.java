/*Given an array of integers, a, return the maximum difference of any pair of numbers 
such that the larger integer in the pair occurs at a higher index (in the array) 
than the smaller integer type of question...

find max(large-small)   and index(large) > index(small).
*/

import java.lang.*;
import java.util.*;
class MaximumDifference{
 	
 	public static void main(String[] args) {
		int[] arr={150,-100,12,-130,80,110,-50,120};
		System.out.println(findMaxDifference(arr));
	}
	static int findMaxDifference(int[] arr){
		int min=arr[0];	//initialize.
		int max=min;
		int lastAmount = 0;
		boolean ifHigher=false;
		for(int i=1;i<arr.length;i++){
			if(arr[i]<min){
				if(max-min > lastAmount)
					lastAmount = max-min;
				min=arr[i];
				max=min;	//reset.
				ifHigher=false;
			}else{	//arr[i] >= min
				if(arr[i] >= max){
					max=arr[i];
					ifHigher=true;
				}
			}
		}
// 		System.out.println("Make sure the index is higher: ifHigher ="+ifHigher);
		if(ifHigher)
			return max-min;
		else 
			return lastAmount;
	}
	
}