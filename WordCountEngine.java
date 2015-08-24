/*
Question:

Implement a document scanning engine that receives a text document doc and 
returns a list of all unique words in it and their number of occurrences, 
sorted by the number of occurrences in descending order.

Example:
for doc: "practice makes perfect. get perfect by practice. just practice!"
the engine returns the list: { practice: 3, perfect: 2,  makes: 1, get: 1, by: 1, just: 1 }.

The engine should ignore punctuation and white-spaces.
Find the minimal runtime complexity and analyze it.
*/
import java.lang.*;
import java.util.*;
class WordCountEngine{
 	
 	public static void main(String[] args) {
		countOfWords("practice makes perfect. get perfect by practice. just practice!");
		//System.out.println(countOfWords("practice makes perfect. get perfect by practice. just practice!"));
	}
	static String countOfWords(String input){
      String s=input.replaceAll("[^a-zA-Z]", " ").toLowerCase();
      
      Hashtable <String, Integer> table = new Hashtable <String, Integer>();
      /* method 2 */
      int rangeStart=0,rangeEnd=0;
      for(int i=0;i< s.length();i++){
        if(s.charAt(i)==' '){//new word.
        	if(s.charAt(i-1)!=' '){ 
        		String word=s.substring(rangeStart,rangeEnd);
				//System.out.println("word= "+word);
				if(table.containsKey(word)){
					//System.out.println("contains= "+word);
					Integer num=table.get(word);
				 	table.put(word,num.intValue()+1);
				}else table.put(word,1);
			
			}	//meanwhile if s.charAt(i-1)==' '
        	rangeStart=i+1;
        	rangeEnd=rangeStart;
        	
        }else{
        	rangeEnd++;
        }
      }
      sortValue(table);
      
      /*method 1
      String[] sArr = s.split(" ");
      for(int i=0;i<sArr.length;i++){
         if(table.containsKey(sArr[i])){
            int count = table.get(sArr[i]).intValue();
            table.put((sArr[i]),count+1);
         }else{
            table.put((sArr[i]),1);
         }
         
      }
      //ArrayList list = table.values();
      //Collection.sort(list);	//time complexity: O(n^2)
      sortValue(table);
      */
      return table.toString();
   }  

//http://stackoverflow.com/questions/5176771/sort-hashtable-by-values

	static void sortValue(Hashtable<String, Integer> t){

       //Transfer as List and sort it
       ArrayList<Map.Entry<String, Integer>> l = new ArrayList<Map.Entry<String, Integer>>(t.entrySet());
       Collections.sort(l, new Comparator<Map.Entry<String, Integer>>(){

         public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
            return o2.getValue().compareTo(o1.getValue());
        }});

       System.out.println(l);
    }
}