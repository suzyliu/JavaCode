/*Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]*/
import java.util.*;

public class PascalTriangle {
    public static List<List<Integer>> generate(int numRows) {
    	//List is a abstract class, cannot be instantiated
        List<List<Integer>> finalList = new ArrayList<List<Integer>>();
        
        if (numRows <1){
        	return finalList;
        }
        List<Integer> lastList = new ArrayList<Integer>();
        lastList.add(1);
		finalList.add(lastList);
        System.out.println("Numbers in list: "+lastList.size());

        for(int i=2; i< numRows+1 ; i++){	//i is the array size.
        	List<Integer> listInARow = new ArrayList<Integer>();
        	for(int j=0;j<i;j++)
        	{
        		if (j==0 || j==i-1){	//(1,1) for i =2; 
        			listInARow.add(lastList.get(0));
        			System.out.println("Added value to the list: "+listInARow.get(j));

        		}else{
        			listInARow.add(lastList.get(j-1)+lastList.get(j));
        			System.out.println("Added value to the list: "+listInARow.get(j));
        		}
    		}
        	System.out.println("Numbers in list: "+listInARow.size());
			finalList.add(listInARow);
			lastList = listInARow;
        }
        for(int i=0;i<finalList.size();i++){
        
        	System.out.println("finalList: "+finalList.get(i));

        }
        return finalList;
    }
    public static void main(String[] args){
    	generate(3);
    }
}