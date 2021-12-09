package backJoon_1747_PrimeNumberAndPelindrome;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * 일    시: 2021-12-09
 * 작 성 자: 유 소 연
 * https://www.acmicpc.net/problem/1747
 * */
public class Backjoon_1747 {
	static boolean[] isNotPN = new boolean[2000000];
	
	public static void main(String[] args) {
		// 에라토스테네스의 채로 소수 걸러내고
		// 그 중에서 팰린드롬 걸러냄
		// N보다 크거나 같고, 소수이면서 팰린드롬인 수 중에서 '가장 작은' 수 찾기
		
		// 1 ~ 100만까지 소수걸러내기
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		isNotPN[0] = isNotPN[1] = true;
		for (int i = 2; i*i <= isNotPN.length-1; i++) {
			if(!isNotPN[i]) {
				for (int j = i*i; j <= isNotPN.length-1; j+=i) {
					isNotPN[j] = true;
				}
			}
		} // end of for i
		// set에 소수 옮겨담기 , set은 순서보장이 안돼서 안된다!!!!ㅠㅠ
		List<String> list = new ArrayList<>();
		for (int i = N; i < isNotPN.length-1; i++) {
			if(!isNotPN[i]) {
				list.add(Integer.toString(i));
			}
		}
//		System.out.println(list.get(list.size()-1));
//		System.out.println("pn 선별완료");
		// set에서 팰린드롬 찾자마자 리턴하기(제일빨리찾는 팰린드롬이 제일작은 수니까)
		for(int j = 0; j < list.size(); j++) {
			String num = list.get(j);
			String temp = "";
			for (int i = num.length()-1; i >= 0; i--) {
				temp += num.charAt(i);
			}
			if(num.equals(temp)) {
				System.out.println(num);
				break;
			}
		} // end of while
	} // end of main
} // end of class
