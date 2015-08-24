/*Q3
testcase: 986561517416921217551395112859219257312
result: 36
*/

import java.util.*;
class EquaSumSubstring{
 	
 	public static void main(String[] args) {
 		System.out.println(getEqualSumSubstring("986561517416921217551395112859219257312"));	//should return 6
	}

static int getEqualSumSubstring(String s){
	char[] charArr = s.toCharArray();
	int[] arr = new int[charArr.length];
	for(int i =0; i<charArr.length;i++){
		arr[i]= charArr[i]-'0';
	}
	//now arr[] is ready for calculation.
	int N=0; //initial
	
	for(int i =1; i<arr.length;i++){
		for(int j=1;j<i+1 && (i+j+1)<arr.length;j++){	//j is the new range. N
			int sumLeft = sumUpAmongIndex(arr,i-j,i);
			int sumRight = sumUpAmongIndex(arr,i+1,i+j+1);
			if(sumLeft==sumRight) 
				if((j+1)*2>N) N=(j+1)*2;	//update N
		}
	}
	return N;
}
	static int sumUpAmongIndex(int[] arr, int from, int to){
		int sum=0;
		for(int i=from;i<=to;i++){
			sum+= arr[i];
		}
		//System.out.println("Sum up between: "+from +" - "+to+" is :"+sum);

		return sum;
	}
}