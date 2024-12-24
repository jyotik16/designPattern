package t2;

import java.util.regex.Pattern;

public class Test2 {
	public static void main(String[] args) {		
		 System.out.println(Pattern.matches("[a-zA-Z0-9]{6}", "arun32333"));//false
		 System.out.println(Pattern.matches("[789]{1}[0-9]{9}", "6953038949"));//true
		 //password-8,a Z 0 9 &
	}

}
