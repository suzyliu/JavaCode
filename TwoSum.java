import java.lang.*;
import java.util.*;
class TwoSum {
 	public static void main(String[] args) {
 		int[] numbers={2, 7, 11, 15};
 		int target=9;
 		int[] result=twoSum(numbers,target);
 		for(int num:result)
	 		System.out.println(num);
	}
	static int[] twoSum(int[] nums, int target) {
        int[] index=new int[2];
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();  //key is the left value, value is index.
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(new Integer(nums[i]))){
                index[0]=map.get(nums[i]).intValue()+1;
                index[1]=i+1;
                return index;
            }else if(!map.containsKey(new Integer(target-nums[i]))){ //not saved yet.
                map.put(target-nums[i],i);    //1 : put -1, 2: put -2
            }
        }
        return new int[]{0,0};
    }
}