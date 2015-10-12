/*Question:
Given two strings S and T, determine if they are both one edit distance apart.*/

import java.lang.*;
import java.util.*;
class OneEditDistance{
	public static void main(String[] args) {
  		
 		System.out.println("Result: " + oneDifferentSpace("abcde","abcdeX"));
  	}
	public static boolean oneDifferentSpace(String a,String b){
		int diffLength = a.length() - b.length();
		if(Math.abs(diffLength) >1) return false;
		else if(diffLength == 0) return sameLengthCompare(a,b);
		else if(diffLength > 0) return diffLengthCompare(a,b);
		else{	//diffLength <0
			return diffLengthCompare(b,a);
		}
		
	}
	private static boolean sameLengthCompare(String a,String b){
		//1 loops, get out of one char of each one.
		for(int i=0;i<a.length();i++){
			String newA = a.substring(0,i) + a.substring(i+1,a.length());
			String newB = b.substring(0,i) + b.substring(i+1,b.length());
			if(newA.equals(newB)){
// 				System.out.println(newA);
				return true;
			}
		}
		return false;
	}
	private static boolean diffLengthCompare(String s1,String s2){
		//remove 1 char from s1. then compare the left
		for(int i=0;i<s1.length();i++){
			String newS1 = s1.substring(0,i) + s1.substring(i+1,s1.length());
// 			System.out.println(newS1);
			if(newS1.equals(s2)) return true;
		}
		return false;
	}
}