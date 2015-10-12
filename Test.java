import java.util.*;

class Test{
	public static void main(String[] args) {
		String s="012345";
		char c='x';
		StringBuilder b =new StringBuilder(s.substring(0,2)+c+s.substring(2,s.length()-1));
		System.out.println(b.toString());
	}

}
