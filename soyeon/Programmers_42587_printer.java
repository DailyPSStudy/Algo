package programmers_42587_printer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * ��    ��: 2022-01-05
 * �� �� ��: �� �� ��
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
		
		// ������ ���ĺ� �빮�ڷ� �̸� �Űܼ� printer�� �ֱ�
		out = new char[priorities.length];
		ArrayList<Print> print = new ArrayList<>();
		print = readInput(priorities);
		char loc = (char)('A'+location);
		
		// ArrayList�� ��ü�� Ž���ϸ鼭, �ļ����� �� ū ��ġ��������� �ǵڷκ����� ��
		// �ļ����� ��ū ��ġ�������� ���
		printing(print);
		
		// out���� loc�� ã�� ���°���� ����
		int ans = findLoc(loc);
		
		return ans;
	} // end of solution

	


	/** print���� ������ ���� ��� */
	private static void printing(ArrayList<Print> print) {
		// ArrayList�� ��ü�� Ž���ϸ鼭, �ļ����� �� ū ��ġ��������� �ǵڷκ����� ��
		// �ļ����� ��ū ��ġ�������� ���
		int no = 0;
		while(print.size()!=0) {
			
			Print cur = print.get(0);
			if(isPrint(cur, print)) {
				System.out.printf("%c(%d)���� ū ��ġ�� �������� �ʽ��ϴ�.\n", cur.id, cur.prior);
				out[no++] = cur.id;
				System.out.println("��� : "+Arrays.toString(out));
				print.remove(0);
			}else {
				System.out.printf("%c(%d)���� ū ��ġ�� �����մϴ�.\n", cur.id, cur.prior);
				print.remove(0);
				print.add(cur);
			}
		} // end of while
	}


	/** 1~print.size()-1 ���� cur���� ū��ġ�� ������ true, ������ false */
	private static boolean isPrint(Print cur, ArrayList<Print> print) {
		for (int i = 1; i < print.size(); i++) {
			if(cur.prior < print.get(i).prior) {
				return false;
			}
		}
		return true;
	}
	

	/** ��µ� ������� �� loc�� ��ġ�� ã�� ���� */
	private static int findLoc(char loc) {
		for (int i = 0; i < out.length; i++) {
			if(out[i] == loc) {
				return i+1;
			}
		}
		return -1; // ã�� ����
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
