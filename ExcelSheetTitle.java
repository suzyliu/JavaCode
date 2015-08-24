/*
Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
*/
/*Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
    
    26*26*1 + 26*2 +3 -> ABC
    
    http://www.tutorialspoint.com/java/lang/character_tostring_char.htm
    https://en.wikipedia.org/wiki/List_of_Unicode_characters
    https://docs.oracle.com/javase/tutorial/i18n/text/characterClass.html
    http://stackoverflow.com/questions/8504615/get-unicode-value-of-character
*/
public class ExcelSheetTitle {
	public static int titleToNumber(String s) {
		char[] charArray = s.toCharArray();
		int totalColAmount=0;
		for(int i=0; i<charArray.length;i++){
			int intForEachChar=switchCharToInt(charArray[charArray.length-1-i]);
			System.out.println("current intForEachChar: "+intForEachChar);

			totalColAmount+= intForEachChar*((int)Math.pow(26,i));
			System.out.println("current totalColAmount: "+totalColAmount);
		}
        return totalColAmount;	
    }
	public static int switchCharToInt(char eachChar){
    	int unicodeNum = (int)eachChar;
    	return unicodeNum-64;
    }
    public static void main(String[] args){
    
    	System.out.println("while Z: "+titleToNumber("Z"));
        System.out.println("while ZZA: "+titleToNumber("ZZA"));
    	System.out.println("while AZ: "+titleToNumber("AZ"));

    	/*test for to title*/
//     	String result = convertToTitle(24568);
//     	System.out.println(result);


    }
    public static String convertToTitle(int n) {
           
        //see the string is 'x','xx' or more 'xxx'
        int lastDigit = n%26;
       //m=n%26 see last digit. transfer from Unicode.
       if (lastDigit==0){
       		lastDigit =26;
       }
        //this is for test.
        char character = switchIntToChar(lastDigit);        
        
        //x=n-m, while (x/26 >1) x=x/26 every time increase a digit = totalDigit
        double newN = n-lastDigit;
        int totalDigits = 1;	//at least one.
		while(newN > 0){
		    totalDigits ++;
			newN = newN-Math.pow(26,totalDigits);
		}
		        	
		System.out.println("totalDigits is "+totalDigits);

        int[] intArrayForDigit = new int[totalDigits];
        int temp = n-lastDigit;
        for(int i=0;i<totalDigits-1;i++){
        	int powNumber = (int)Math.pow(26,totalDigits-1-i);
        	System.out.println("powNumber is "+powNumber+" temp is "+temp);
        	intArrayForDigit[i] = temp/powNumber;
        	temp = temp-(intArrayForDigit[i]*powNumber);	
        }
        intArrayForDigit[totalDigits-1] = lastDigit; 
        
        //for i in totalDigit,  a=x/26^totalDigit. a is the first one of the string
        //b=x/26^(totalDigit-1). b is the second one of the string
       	char[] charForString = new char[totalDigits];
       	for(int i=0;i<totalDigits;i++){
       		charForString[i]= switchIntToChar(intArrayForDigit[i]);
       	}
       	String stringForN = new String(charForString);   //merge the char array to string.

        return stringForN;
    }
    public static char switchIntToChar(int number){
    	int unicodeNum = number+64;
    	char character = (char)unicodeNum;
    	return character;
    }
}