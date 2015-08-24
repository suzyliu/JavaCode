/*
Given an array of integers, find if the array contains any duplicates. 
Your function should return true if any value appears at least twice 
 in the array, and it should return false if every element is distinct.
 
 consider 1 to 9999
*/
import java.util.*;
import java.lang.Object.*;

public class ContainDuplicate {
	public static boolean containsDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<Integer>();		
		for(int i=0;i< nums.length;i++){
			if(set.contains((Integer)(nums[i]))){
				return true;
			}else{
				
				set.add((Integer)(nums[i]));	//Object put(Object key, Object value)
			}
		}
        return false;
	}
	
	
	
	/* ****** Exceed time limit ******/
    public static boolean containsDuplicateV1(int[] nums) {
        Integer[] numsInteger = new Integer[nums.length];
        for(int i=0; i< nums.length;i++){
        	numsInteger[i]=Integer.valueOf(nums[i]);
        }

        for(int i=0; i<numsInteger.length;i++){
			List<Integer> list = new LinkedList<Integer>(Arrays.asList(numsInteger));
        	list.remove((Integer)(nums[i]));
        	
        	if(list.contains(nums[i])){
// 				System.out.println("Return true here");
        		return true;
			}
        }
        return false;
    }
    public static void main(String[] args){
    	int[] sample = {-1,2,3,1,10,-9};
    	boolean b =containsDuplicate(sample);   	
		System.out.println(b);
    }
    
    
}
