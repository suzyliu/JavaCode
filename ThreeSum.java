import java.lang.*;
import java.util.*;
class ThreeSum {
 	public static void main(String[] args) {
 		// int[] nums = {1,0,-1};
 		int[] nums = {7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};	//{-4,-3,0,3,4,5}
 		System.out.println(threeSum(nums));
	}
	static List<List<Integer>> threeSum(int[] nums) {
         List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums.length <3) return result;
        Arrays.sort(nums);

        for(int i=0;i<nums.length-2;i++){ //find nums[i]+nums[start]+nums[end] =0
            if(i>0 && (nums[i-1]==nums[i])) continue;
            int target= -1*nums[i];
            int num1[] = Arrays.copyOfRange(nums,i+1,nums.length);
            ArrayList<int[]> foundIndex =twoSum(num1,target);
            for(int j=0;j<foundIndex.size();j++){
            	int[] index = foundIndex.get(j);
            	List<Integer> list = new ArrayList<Integer>();
            	list.add(nums[i]);
            	list.add(nums[i+1+index[0]]);
                list.add(nums[i+1+index[1]]);
                result.add(list);
            }
            
        }
        return result;
    }
    static ArrayList<int[]> twoSum(int[] nums, int target) {
    	ArrayList<int[]> listOfInts = new ArrayList<int[]>();
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();  //key is the left value, value is index.
        for(int i=0;i<nums.length;i++){
        	if(i>0 && (nums[i-1]==nums[i])) continue;
            if(map.containsKey(new Integer(nums[i]))){
                int[] index=new int[2];
                index[0]=map.get(nums[i]).intValue();
                index[1]=i;
                listOfInts.add(index);
            }else if(!map.containsKey(new Integer(target-nums[i]))){ //not saved yet.
                map.put(target-nums[i],i);    //1 : put -1, 2: put -2
            }
        }
        return listOfInts;
    }
}
/****** version 3
        for(int i=0;i<nums.length-2;i++){ //find nums[i]+nums[start]+nums[end] =0
            int negative= -1*nums[i];
            int start = i+1;
            int end = nums.length-1;
            while(start < end){//keep search if there are fit start and end
                if(nums[start] + nums[end] == negative){//save the nums[i],nums[start],nums[end]
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[start]);
                    list.add(nums[end]);
                    result.add(list);
                    if(nums[start]==nums[start+1]) start++;
                    else if(nums[end]==nums[end-1]) end--;
                    else break;
                }else if(nums[start] + nums[end] > negative){   //value is too large.(too close to right)
                    end--;
                }else if(nums[start] + nums[end] < negative){
                    start++;
                }
            }
            //O(n^2)
        }
        return result;
    }
}
        /*** version 2       
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums.length <3) return result;
        Arrays.sort(nums);
        HashMap<Integer,Integer> left = new HashMap<Integer,Integer>(nums.length);
        for(int i=0;i<nums.length;i++){
        	left.put(i,nums[i]);
        }
        int i=0,j=1; //index for other values.
        while((i<j)&&(j<nums.length-1)){
        	int leftValue = 0-(nums[i]+nums[j]);
        	boolean isFound=false;
        	if(left.containsValue(new Integer(leftValue))){
        		Integer key=0;
        		for (Map.Entry<Integer, Integer> e : left.entrySet()) {
    				if(e.getValue().intValue() ==leftValue){
    					key = e.getKey();
    					isFound=true;
    					if((key!=i)&&(key !=j)){
							List<Integer> newlist = new ArrayList<Integer> (3);
							newlist.add(0,new Integer(nums[i]));
							newlist.add(1,new Integer(nums[j]));
							newlist.add(2,leftValue);
							result.add(newlist);
							break;
						}//else keep searching
					}
				}
        	}
        	if(isFound || (j+2 >= nums.length)){
        	    i++;
    			j=i+1;
    		}else{	
        		j++;
        	}
        }//end of while loop
        return result;
    //}
/*********** version 1 ***********
        Arrays.sort(nums);//ascending
        List<Integer> list = new ArrayList<Integer>(3);		//list for value
        int index0=0,index1=1,index2=2;
        list.add(nums[index0]);
        list.add(nums[index1]);
        list.add(nums[index2]);
        while((index0<index1)&&(index1<index2)&&(index2<nums.length)){
            boolean isFound=false;
            if(sumOfValues(list.get(0),list.get(1),list.get(2))==0){
                //find the match
                List<Integer> newlist = new ArrayList<Integer> (list);	//to pass by value.
                result.add(newlist);
                //can try new values.
                isFound=true;
            }else if(sumOfValues(list.get(0),list.get(1),list.get(2))>0) return result; //no need to continue.
                //increase index.
            //not found.
            if((index2+1 >= nums.length) ||(isFound)){    //index2 full
                if((index1+2 >= nums.length)||(isFound)){    //index 1 full and leave a space for index2
                    if(index0+3 >= nums.length){ //totally full
                            return result;
                    }else{  //is isFound=true, goes here.
                        index0++;
                        index1=index0+1;
                        index2=index1+1;
                    }
                }else{
                    index1++;
                    index2=index1+1;    //reset
                }
            }else{
                index2++;
            }
            list.set(0,nums[index0]);
            list.set(1,nums[index1]);
            list.set(2,nums[index2]);
        }
        return result;
    }
    static int sumOfValues(Integer a,Integer b, Integer c){
    	int sum =a.intValue()+b.intValue()+c.intValue();
    	//System.out.println(sum);
        return sum;
    }*/
// }