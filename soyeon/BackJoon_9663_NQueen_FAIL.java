package backJoon_9663_NQueen;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ��    ��: 2022-01-07 2:00 ~
 * �� �� ��: �� �� ��
 * https://www.acmicpc.net/problem/9663
 * isPossible�� ����ġ�⸦ ���ְ��մµ� �� ����..?��
 * */
public class BackJoon_9663_NQueen_FAIL {
	static int numberOfQueen, numberOfWay;
	static int[][] map;
	static List<int[]> queen = new ArrayList<>();
	
	public static void main(String[] args) {
		
		// ���� ���� �۰��� �� ������ ���� ����� ���� ���϶�
		// ���� ������ �� ���� �δ°� ����..?
		// �� �ڽ��� �������� ���μ��� �밢���������� �ƹ��͵� ���������� �ȵ�
		init();
		
		setQueen(0,0,0);
		System.out.println(numberOfWay);
		
	} // end of main
	
	
	/** map���� queen�� �ϳ��� �д� */
	private static void setQueen(int settedQueen, int cy, int cx) {
		if(settedQueen==numberOfQueen) {
			numberOfWay++;
			return;
		}
		for (int y = cy; y < numberOfQueen; y++) {
			for (int x = 0; x < numberOfQueen; x++) {
				if(!isPossible(y,x)) continue;
				queen.add(new int[] {y,x});
//				System.out.printf("%d,%d ����\n", y,x);
				setQueen(settedQueen+1, y, x);
				if(queen.size()!=0) queen.remove(queen.size()-1); // �ֱٿ�� ����
			}
		}
	}


	/** y,x�� ���� �� �� �ִ��� �Ǻ� */
	private static boolean isPossible(int y, int x) {
//		System.out.println("isPossible start: "+queen.size());
		for (int i = 0; i < queen.size(); i++) {
			int[] cur = queen.get(i);
//			System.out.printf("(%d,%d) vs (%d,%d)\n", cur[0], cur[1], y,x);
			// ���� �˻�
			if(cur[0]==y) return false;
			// ���� �˻�
			if(cur[1]==x) return false;
			// �밢�� �˻�
			if(Math.abs(cur[0]-y) == Math.abs(cur[1]-x)) {
				return false;
			}
		}
		return true;
	}


	/** ��ü �ʱ�ȭ */
	private static void init() {
		Scanner sc = new Scanner(System.in);
		numberOfQueen = sc.nextInt(); // number of queen
		map = new int[numberOfQueen][numberOfQueen]; // N*N ü����
	}
	
} // end of class
