package Programmers;

import java.util.Arrays;
import java.util.HashMap;

public class 전화번호부 {
	
	  public static boolean solution(String[] phone_book) {
	        boolean answer = true;

	        int pl = phone_book.length;
	        Arrays.sort(phone_book);
	        for(int i=0;i<pl-1;i++) {
	        	if(phone_book[i+1].startsWith(phone_book[i])) {
	        		return false;
	        	}
	        }
	        
	        return answer;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a = new String[] {
				"119", "97674223", "1195524421"
		};
		System.out.println(solution(a));
	}

}
