import java.lang.*;
import java.util.*;
class ThreeSumV2{
 	public static void main(String[] args) {
//  		int[] nums = {7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};	//{-4,-3,0,3,4,5}
		int[] nums = {13,-11,-14,4,-9,-10,-11,7,-14,-9,14,0,-5,-7,6,-9,11,6,-14,-12,-10,9,-8,-7,5,6,8,-12,-1,-4,14,-3,0,7,9,7,12,13,-9,13,11,-10,-10,-9,-10,12,-10,8,-5,13,11,-8,7,-12,0,-11,2,-14,-8,8,-3,13,-9,5,5,7,-11,-6,5,-13,-7,1,14,-10,-1,-11,-13,4,12,-11,2,0,-4,-14,4,4,-10,13,-3,-10,6,1,-12,4,-9,1,-4,-13,10,8,-11,10,-14,-12,-14,1,-8,10,-10,11,-15,0,-3,-12,1,-14,-1,-1,6,11,-4,-3,-2,-1,-13};
 		System.out.println(threeSum(nums));
	}
	public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums.length <3) return result;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>(nums.length);  //index,value.
        map.put(0,nums[0]);
        for(int i=1;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int targetValue = -1*(nums[i]+nums[j]);
                if(map.containsValue((Integer)targetValue)){    //only search the value that is passed.
                    ArrayList<Integer> list = new ArrayList<Integer>(3);
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(targetValue);//this one must be a value that's passed.
                    result.add(list);
                }
            }
            map.put(i,nums[i]);
        }
        return result;
    }
}