/*Shifted Array Search 

Question:

1. Find a given number num in a sorted array arr:
arr = [2, 4, 5, 9, 12, 17] 

2. If the sorted array arr is shifted left by an unknown offset and you don't have a pre-shifted copy of it, how would you modify your method to find a number in the shifted array?
shiftArr = [9, 12, 17, 2, 4, 5]

Explain and code an efficient solution and analyze its runtime complexity
if num doesn't exist in the array, return -1
*/
import java.lang.*;
import java.util.*;
class ShiftedArraySearch{
	public static void main(String[] args) {
		int[] shiftArr = {9, 12, 17, 31, 2, 4, 5, 7};
		System.out.println(searchInShiftedArray(shiftArr,3));
	}
	static int searchInShiftedArray(int[] arr, int num){
		
		//find the offset first
		int start =0;
		int end = arr.length-1;
		int index=0;
		int offset =-1;
		while(start <=end && offset==-1){
			index=(start+end)/2;
			if(arr[index+1] < arr[index] )	//find it!
				offset = index+1;
			else if(arr[index] < arr[start]){		//has line in the first half.
				end=index;
			}else if(arr[end] < arr[index]){
				start = index;
			}else{
				start++;
			}
		}
		// System.out.println("offset = "+offset);
		int[] beforeShift = new int[arr.length];
		System.arraycopy(arr, offset, beforeShift, 0, arr.length-offset);
		System.arraycopy(arr, 0, beforeShift, arr.length-offset, offset);
		// for(int element:beforeShift){
// 			System.out.println(element);
// 		}
		start=0;
		end = beforeShift.length;
		
		while(start <= end){
		
			index=(start+end)/2;
			if(num == beforeShift[index] )	
				return num;
			else if(beforeShift[index] > num){		
				end=index-1;
			}else if(beforeShift[index] < num){
				start = index+1;
			}
		}
		return -1;
	}
} 

