package programmers_42577_PhoneNumberList;
import java.util.*;
/**
 * ��    ��: 2022-01-07
 * �� �� ��: �� �� ��
 * https://programmers.co.kr/learn/courses/30/lessons/42577
 * */
class Programmers_42577_PhoneNumberList {
 
	 public boolean solution(String[] phone_book) {
	     // ���ڿ� ������ ������ ������ ũ�� ��Һ񱳰� �ƴ� ���������� ���ĵȴ�.
	     Arrays.sort(phone_book);
	     // System.out.println(Arrays.toString(phone_book));
	     
	     for(int i = 0; i < phone_book.length-1; i++) {
	         String replaced = phone_book[i+1].replace(phone_book[i], "A");
	         // System.out.printf("%s, %s => %s\n", phone_book[i], phone_book[i+1], replaced);
	         if(replaced.charAt(0)=='A') {
	             return false;
	         }
	     }
	     
	     return true;
	 } // end of solution
 
} // end of class