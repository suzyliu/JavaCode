/***
Given a package with a weight limit and an array arr of item weights, how can you most efficiently find two items with sum of weights that equals the weight limit?

Your function should return 2 such indices of item weights or -1 if such pair doesn't exist.
What is the runtime and space complexity of your solution?*/

import java.util.*;
class MergingPackages {
 	public static void main(String[] args) {
   		int[] arr={2,3,6,7,9};
   		int[] result = findFitWeight(arr,10);
   		System.out.println("The result : "+result[0]+" "+result[1]);
    }   
    static int[] findFitWeight(int[] arr, int limit){
    	
    	HashMap<Integer,Integer> map= new HashMap<Integer,Integer>();
    	
    	for(int i=0;i<arr.length;i++){
    		int weight = limit - arr[i];
    		Integer index = map.get(weight);
			if(index != null){		//find the other half.
				return new int[]{i,index.intValue()};
			}
			else{
				map.put(arr[i],i);
			}
		}
		return new int[] {-1,-1};
	}
}