/*******************************************
*	Question:
The awards committee had planned to give n research grants this year, out of a its total yearly budget.
However, the budget was reduced to b dollars. The committee members has decided to affect the minimal number of highest grants, by applying a maximum cap c on all grants: every grant that was planned to be higher than c will now be c dollars.
Help the committee to choose the right value of c that would make the total sum of grants equal to the new budget.

Given an array of grants g and a new budget b, explain and code an efficient method to find the cap c.
Analyze the time and space complexity of your solution.
*
* Time Complexity: O(n)
* Space Complexity: O(n)
********************************************/
import java.util.*;
public class AwardBudgetCuts  {
    public static void main(String[] args) {
   		int b=2000;	//budget
    	int[] g={300,400,500,700,800};	//assume is sorted array.
		System.out.println(calculateC(g,b));	
		//print out C
    }   
    static int calculateC(int[] g,int b){
    	int avg = b/g.length;
    	int c=avg;	//a maximum cap 

    	int extraQuata = 0;
    	int exceedNumbers =0;
    	int[] newG = new int[g.length];
    	Arrays.fill(newG,0);
    	
    	for (int i=0;i<g.length;i++){
    		if(avg >= g[i]){
    		 	extraQuata += (avg-g[i]);
    		}else{	//avg <= g[i]
    			newG[i]=g[i]-avg;	//exceed value.
    			exceedNumbers++;
    		}
    	}
    	int currentStandardPoint=0;
    	for(int j=0;j<newG.length;j++){
    		if(newG[j] >currentStandardPoint){
    			if(extraQuata - (newG[j]*exceedNumbers) >0){
    				//enough for the left to share + has left.
    				c+=newG[j];
    				extraQuata -=(newG[j]*exceedNumbers);	//new extra value.
    				exceedNumbers--;
    				currentStandardPoint+=newG[j];
    				
    			}else{
    				//not enough to share.
    				c+=(extraQuata/exceedNumbers);
    				break;	//or will keep adding the left 3 values.
    			}		
    		}
    	}
    	
    	return c;
    }
   
}