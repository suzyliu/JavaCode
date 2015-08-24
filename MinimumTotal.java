import java.lang.*;
import java.util.*;
class MinimumTotal{
 	
 	public static void main(String[] args) {
 		ArrayList<ArrayList<Integer>> triangle =initializeList();
 		minimumTotal(triangle);
 	}
 	static ArrayList<ArrayList<Integer>> initializeList(){
 		ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
 		Integer[] a = {2}; // cannot use int[] here
		List<Integer> listA = Arrays.asList(a);
		Integer[] b = {3, 4}; // cannot use int[] here
		List<Integer> listB = Arrays.asList(b);
		Integer[] c = {6,5,7}; // cannot use int[] here
		List<Integer> listC = Arrays.asList(c);
		Integer[] d = {4,1,8,3}; // cannot use int[] here
		List<Integer> listD = Arrays.asList(d);
		resultList.add(listA);
		resultList.add(listB);
		resultList.add(listC);
		resultList.add(listD);

 	}
    static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        
        //4 rows: 4 result
        List<Integer> result = new ArrayList<Integer>(); 
        int indexOfRow=0;
        int min = Integer.MAX_VALUE;

        while(indexOfRow<triangle.size()){
            int size=triangle.get(indexOfRow).size();
            for(int i=0;i<size;i++){
                if(indexOfRow==0){
                    result.add(triangle.get(indexOfRow).get(i));    //add 4 the same values in
                }else{
                    int currentValue = triangle.get(indexOfRow).get(i).intValue();
                    int lastValue=0;    //update later
                    if(i==0){   //left most
                        lastValue = result.get(i).intValue();
                    }else if(i==size-1){    //right most
                        lastValue = result.get(i-1).intValue();
                        result.set(i,lastValue+currentValue);
                    }else{  //in the middle: compare 2 src.
                        int value1 =result.get(i-1).intValue();
                        int value2 =result.get(i).intValue();
                        lastValue=Math.min(value1,value2);
                    }
                    result.set(i,lastValue+currentValue);
                }
                if(indexOfRow==triangle.size()-1){
                    //last row here
                    if(result.get(i).intValue() < min) min=result.get(i).intValue();
                }
            }//result will have the new size
            indexOfRow++;
        }
        return min;
    }
}