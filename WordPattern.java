/*
Unsolved problem

2015/8/6
*/
import java.util.*;
import org.apache.commons.lang3.StringUtils;
class WordPattern{
 	
 	public static void main(String[] args) {

		System.out.println(wordpattern("abba","REDBLUEBLUERED"));
	}
   static int wordpattern(String pattern, String input) {
   			char[] arrPattern = pattern.toCharArray();
   			
        	HashMap<Char,String> hashMap= new HashMap<Char,String>();
   			StringBuilder s=new StringBuilder(input);
   			int partLength=1;
   			int pointer=0;
   			int index=0;
   			StringBuilder lastpart=new StringBuilder();
   			StringBuilder part=new StringBuilder(input);
   			boolean doesntMatter = false;
   			while((pointer+partLength < input.length()) && (index < arrPattern.length)){
   				lastpart=part;
   				part=s.substring(pointer,pointer+partLength);
   				int countInput = StringUtils.countMatches(s,part);
   				int countPattern = StringUtils.countMatches(pattern,arrPattern[index]);
   				
   				if(countInput==1){	//doesn't matter.
   					doesntMatter=true;
   					index++;
   					pointer++;	//but could need to add more than 1.
   				}else if((partLength==1)&&(countInput < countPattern)){
   					//first char but no match.
   					if(doesntMatter) pointer++;
   				}else if(countInput>=countPattern){	//possible answer 
   					partLength++;	//try other possibility.
   				}else{
   					if(StringUtils.countMatches(s,lastpart)==countPattern){
   						hashMap.put(index,lastpart.toString());	//put the possible part of it
   						index++;
   						partLength=1;	//return to 1
   						//pointer should be ready already lol
   					}else{
   						//there is some problems
   						System.out.println("no match");
   						return 0;
   					}
   				}
   			}
   			StringBuilder check=new StringBuilder("");
   			for(int i=0;i<arrPattern.length;i++){
   				
   				System.out.println(hashMap.get(i));
   				check.append(hashMap.get(i));
   			}
   			if(check.toString() == input)
	   			return 1;
	   		else return 0;
   		}
        /*char[] arrPattern = pattern.toCharArray();
        String[] tempPattern = new String[arrPattern.length];
        int start=0;
        HashMap<Char,String> hashMap= new HashMap<Char,String>();
       
        

    }
    static void analysisInput(String input){
        //find is there is duplicate pattern
        //StringBuilder s=new StringBuilder(input);
        
        String s=input;
        int pointer=0;
        int counter=1;
        HashMap<String,Integer> map= new HashMap<String,Integer>();
        int testLength=1;   //initially.
        
        while(s.length()>0||testLength>s.length()){
        	String origin=tmp;
            String tmp=s.subString(pointer,testLength-1);
            if(s.subString(testLength+1,s.length()-1).contains(tmp))	//rest:contain tmp.
            { 
            	counter = StringUtils.countMatches(s,tmp);
            	testLength++;
            }else{		//restOfIt doesnt contain
            	map.put(origin,counter);
            	counter=0;
            	//should cut s
            	s.replace(origin,"");	//new string left
            	pointer=0;
            	//pointer+=(testLength-1);	//add 1 more after that
            	testLength=1;
            	counter=1;
            }
        }*/
    }