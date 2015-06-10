import java.util.*;

public class Operation {
	
	public Operation(){
	
	}
	public static void main(String[] args){
		System.out.println(subtract(5,3));
		System.out.println(multiply(5,3));
		System.out.println(divide(-2400,3));

	}	
	
	//subtract
	public static int subtract(int number1, int number2){
	
		return number1+negate(number2);
	}
	public static int negate(int x){
		int negValue = 0;
		int one = x > 0 ? -1 : 1;
		while(x!=0){
			x = x+one;
			negValue = negValue + one;
		}
		return negValue;
	}
	
	//multiply: integar could be positive and negative.
	public static int multiply(int number1, int number2){
		int result = 0;
		while(number2 != 0) {
			
			result += number1;		//it's okay if number1 <0; negative+negative = negative
			if (number2 < 0){
				number2 = number2 +1; 
			}else{
				number2 = number2 +negate(1); 
			}
		}
		return result;
	}
		
	//Divide
	public static int divide(int number1, int number2){
		boolean isNegativeDivisor = false;
		boolean isNegativeDividend = false;
		int absNumber1 = number1;
		int absNumber2 = number2;

		if (number2 < 0){
			isNegativeDivisor = true;
			absNumber2 = negate(number2);
		}
		if (number1 < 0){
			isNegativeDividend = true;
			absNumber1 = negate(number1);
		}
		
		int result = 0;
		
		while(absNumber1 >= absNumber2) {		//in case absNumber1 < absNumber2, this works
			result += 1;		
			absNumber1 += negate(absNumber2);
			//absNumber1 will decrease absNumber2 per time.
		}
		
		//now deal with negative.
		if ( isNegativeDivisor != isNegativeDividend)
			return negate(result);
		else
			return result;
	}
	


}