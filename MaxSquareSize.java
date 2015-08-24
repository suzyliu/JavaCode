import java.lang.*;
import java.util.*;
class MaxSquareSize{
 	
 	public static void main(String[] args) {
 	
 		int[][] matrix = {
 		{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},
 		{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
 		
 		System.out.println(maxSquare(matrix));
 	}
 	static int maxSquare(int[][] matrix) {
        // write your code here
        int maxSize = 0;
        int testSize = 1;
        int x = 0;
        int y = 0;
        while((x + testSize < matrix.length) && (y + testSize < matrix[0].length)){
            //System.out.println("testSize for this time:"+testSize+" x="+x+" y="+y);
            if( ifFitAll(matrix,x,y,testSize) ){
                testSize++;
                if(testSize > maxSize){ 
                    maxSize = testSize;
                }
            }else{
                if(y+testSize+1 >= matrix[0].length){
                    x++;
                    y=0;    //from head.
                }else y++;
            }
        }
        return maxSize*maxSize;
    }
    static boolean ifFitAll(int[][] matrix, int x, int y, int size){
        for(int i=x; i<x+size;i++){
            for(int j=y; j<y+size;j++){
                if(matrix[i][j] == 0) return false;
            }
        }
        return true;    //has gone through all the values in the range.
    }
    
    }