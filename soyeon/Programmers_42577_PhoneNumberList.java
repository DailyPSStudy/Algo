package programmers_42577_PhoneNumberList;
import java.util.*;
/**
 * 일    시: 2022-01-07
 * 작 성 자: 유 소 연
 * https://programmers.co.kr/learn/courses/30/lessons/42577
 * */
class Programmers_42577_PhoneNumberList {
 
	 public boolean solution(String[] phone_book) {
	     // 문자열 숫자의 정렬은 숫자의 크기 대소비교가 아닌 사전순으로 정렬된다.
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