import java.lang.*;
import java.util.*;
public class StrobogrammaticIII {

	public static void main(String[] args) {
		System.out.println(strobogrammaticInRange("5","100"));
	}

	public static int strobogrammaticInRange(String low, String high) {
//         List<String> list = new ArrayList<String>();
        int nH=high.length();    //how many digits.
        int nL=low.length();    //at least how many digits.
        int total=0;
        int lowNum =Integer.parseInt(low);
        Long highNum=Long.parseLong(high);
        for(int i=nL;i<=nH;i++){
            List<String> newList = addChar(new ArrayList<String>(),"",i);
            total += newList.size();
            System.out.println("current total: "+total);
            if(i==nL){
                for(String s:newList){
                    Long num = Long.parseLong(s);
                    if(num<lowNum){
                        total--;
                    }
                }
            }
            if(i==nH){
                for(String s:newList){
                    Long num = Long.parseLong(s);
//                     System.out.println("find num: "+num);
                    if(num >highNum){
//                         System.out.println("minus num: "+num);
                        total--;
                    }
                }
            }
            
        }
        return total;
    }
    static List<String> addChar(List<String> list, String s,int n){
        if(n==1){
             list.add("1");
             list.add("0");
             list.add("8");
             return list;
        }
        if(n%2==1){ //odd numbers that's >=3 
            addChar(list,"1",n-1); 
            addChar(list,"8",n-1);
            addChar(list,"0",n-1);
        }else if(n==0){
            return list;
        }else if(n==2){
            //last 2 positions
            list.add("1"+s+"1");
            list.add("6"+s+"9");
            list.add("9"+s+"6");
            list.add("8"+s+"8");
        }else{
            addChar(list,"1"+s+"1",n-2); 
            addChar(list,"6"+s+"9",n-2); 
            addChar(list,"8"+s+"8",n-2); 
            addChar(list,"9"+s+"6",n-2);
            addChar(list,"0"+s+"0",n-2); 
        }
        return list;
    }
    
    
    }