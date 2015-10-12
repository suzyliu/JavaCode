import java.lang.*;
import java.util.*;
public class Strobogrammatic {

	public static void main(String[] args) {
		System.out.println(findStrobogrammatic(4));
	}
    public static List<String> findStrobogrammatic(int n) {
        List<String> list = new ArrayList<String>();
        
        return addChar(list,"",n);
    }
    static List<String> addChar(List<String> list, String s,int n){
        
        if(n==2){
            //last 2 positions
            list.add("1"+s+"1");
            list.add("6"+s+"9");
        }else{
            addChar(list,"1"+s+"1",n-2); 
            addChar(list,"6"+s+"9",n-2); 
        }
        return list;
    }
}