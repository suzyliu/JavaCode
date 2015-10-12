import java.lang.*;
import java.util.*;
class ThreeSumSmaller{
	public static void main(String[] args) {
  		int[] nums = {0,-2,1,3};
  		
 		System.out.println(threeSumSmaller(nums,2));
  	}
	public static int threeSumSmaller(int[] nums, int target) {
        if(nums.length <3) return 0;
        Arrays.sort(nums);
        int counter=0;
        int range=nums.length;
        //fine with same value set if the "index" are diff.
        for(int i=0;i<range;i++){
//             System.out.println(counter);
            for(int j=i+1;j<range;j++){
                int k=range-1;
                while(k>j && nums[i]+nums[j]+nums[k] >= target){
                    k--;
                }
                //now the k is the biggest one that match.
                if(k>j) counter+=(k-j);
                
            }
        }
        return counter;
    }
    
}