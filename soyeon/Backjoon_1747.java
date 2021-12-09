package backJoon_1747_PrimeNumberAndPelindrome;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * ��    ��: 2021-12-09
 * �� �� ��: �� �� ��
 * https://www.acmicpc.net/problem/1747
 * */
public class Backjoon_1747 {
	static boolean[] isNotPN = new boolean[2000000];
	
	public static void main(String[] args) {
		// �����佺�׳׽��� ä�� �Ҽ� �ɷ�����
		// �� �߿��� �Ӹ���� �ɷ���
		// N���� ũ�ų� ����, �Ҽ��̸鼭 �Ӹ������ �� �߿��� '���� ����' �� ã��
		
		// 1 ~ 100������ �Ҽ��ɷ�����
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
		// set�� �Ҽ� �Űܴ�� , set�� ���������� �ȵż� �ȵȴ�!!!!�Ф�
		List<String> list = new ArrayList<>();
		for (int i = N; i < isNotPN.length-1; i++) {
			if(!isNotPN[i]) {
				list.add(Integer.toString(i));
			}
		}
//		System.out.println(list.get(list.size()-1));
//		System.out.println("pn �����Ϸ�");
		// set���� �Ӹ���� ã�ڸ��� �����ϱ�(���ϻ���ã�� �Ӹ������ �������� ���ϱ�)
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
