/////////////////////////////////////////////////////
// SUDOKU SOLUTION VALIDATOR
/////////////////////////////////////////////////////

/*
Task: write a function to determine if a given sudoku solution is valid.

A Sudoku is a 9x9 grid of numbers, divided into 9 smaller grids that are 3x3 each
In a valid solution, every row and column and each grid should have the numbers 1-9, without repeats

Notes: 

- write production quality code
- no need to worry about exact syntax
- pretend this is a collaborative exercise or pair programming session
- ask me if you have any questions at all, or need to look something up on google
- think out loud
- discuss all design choices

Example:
    5 3 4 | 6 7 8 | 9 1 2
    6 7 2 | 1 9 5 | 3 4 8
    1 9 8 | 3 4 2 | 5 6 7
    ---------------------
    8 5 9 | 7 6 1 | 4 2 3
    4 2 6 | 8 5 3 | 7 9 1
    7 1 3 | 9 2 4 | 8 5 6
    ---------------------
    9 6 1 | 5 3 7 | 2 8 4
    2 8 7 | 4 1 9 | 6 3 5
    3 4 5 | 2 8 6 | 1 7 9
*/
class SUDOKU{
public boolean isValid(int[][] arr){    //9x9


    int index1=0;
    boolean[] check = new boolean[9];
    while(index1<9){	//the new while loop goes 9 times only.
        
        //index1,index2 0,3,6 _>Block
        if(index1%3==0){
            for(int index2 =0;index2<7;index2+=3){   //check when index1 fixed. different blocks.	
            	for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    if(check[arr[index1+i][index2+j]]) return false;
                    else check[arr[index1+i][index2+j]]=true;
            
                }
            	}
            	Array.fill(check,false);    //reset.
            }	//this case is in O(n^3) --> but actual times is 3*3*3=27.
        }
        for(int i=0;i<9;i++){
            if(check[arr[index1][i]]) return false;
            else check[arr[index1]][i]=true;
        }
        Array.fill(check,false);
        
        for(int i=0;i<9;i++){
            if(check[i]][arr[index1]) return false;
            else check[i][arr[index1]]=true;
        }  
        Array.fill(check,false);  
        index1++;
    }
    return true;
}
}