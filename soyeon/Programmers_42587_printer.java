package programmers_42587_printer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 일    시: 2022-01-05
 * 작 성 자: 유 소 연
 * https://programmers.co.kr/learn/courses/30/lessons/42587
 * */
public class Programmers_42587_printer {
	static char[] out;
	
	static class Print {
		char id;
		int prior;
		public Print(char id, int prior) {
			this.id = id;
			this.prior = prior;
		}
	} // end of Print
	
	public static void main(String[] args) {
//		int ans = solution(new int[] {2,1,3,2}, 2);
		int ans = solution(new int[] {1, 1, 9, 1, 1, 1}, 0);
		System.out.println(ans);
	}
	
	
	public static int solution(int[] priorities, int location) {
		
		// 문서에 알파벳 대문자로 이름 매겨서 printer로 넣기
		out = new char[priorities.length];
		ArrayList<Print> print = new ArrayList<>();
		print = readInput(priorities);
		char loc = (char)('A'+location);
		
		// ArrayList로 전체를 탐색하면서, 후순열에 더 큰 가치가있을경우 맨뒤로보내는 식
		// 후순열에 더큰 가치가없으면 출력
		printing(print);
		
		// out에서 loc를 찾아 몇번째인지 리턴
		int ans = findLoc(loc);
		
		return ans;
	} // end of solution

	


	/** print에서 문서를 꺼내 출력 */
	private static void printing(ArrayList<Print> print) {
		// ArrayList로 전체를 탐색하면서, 후순열에 더 큰 가치가있을경우 맨뒤로보내는 식
		// 후순열에 더큰 가치가없으면 출력
		int no = 0;
		while(print.size()!=0) {
			
			Print cur = print.get(0);
			if(isPrint(cur, print)) {
				System.out.printf("%c(%d)보다 큰 가치가 존재하지 않습니다.\n", cur.id, cur.prior);
				out[no++] = cur.id;
				System.out.println("출력 : "+Arrays.toString(out));
				print.remove(0);
			}else {
				System.out.printf("%c(%d)보다 큰 가치가 존재합니다.\n", cur.id, cur.prior);
				print.remove(0);
				print.add(cur);
			}
		} // end of while
	}


	/** 1~print.size()-1 까지 cur보다 큰가치가 없으면 true, 있으면 false */
	private static boolean isPrint(Print cur, ArrayList<Print> print) {
		for (int i = 1; i < print.size(); i++) {
			if(cur.prior < print.get(i).prior) {
				return false;
			}
		}
		return true;
	}
	

	/** 출력된 결과물들 중 loc의 위치를 찾아 리턴 */
	private static int findLoc(char loc) {
		for (int i = 0; i < out.length; i++) {
			if(out[i] == loc) {
				return i+1;
			}
		}
		return -1; // 찾지 못함
	}

	/** priorities,location => print */
	private static ArrayList<Print> readInput(int[] priorities) {
		ArrayList<Print> res = new ArrayList<>();
		
		for (int i = 0; i < priorities.length; i++) {
			res.add(new Print((char)('A'+i), priorities[i]));
		}
		
		return res;
	}
	
} // end of class
