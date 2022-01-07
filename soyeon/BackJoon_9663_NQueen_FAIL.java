package backJoon_9663_NQueen;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 일    시: 2022-01-07 2:00 ~
 * 작 성 자: 유 소 연
 * https://www.acmicpc.net/problem/9663
 * isPossible로 가지치기를 해주고잇는데 왜 멤초..?ㅠ
 * */
public class BackJoon_9663_NQueen_FAIL {
	static int numberOfQueen, numberOfWay;
	static int[][] map;
	static List<int[]> queen = new ArrayList<>();
	
	public static void main(String[] args) {
		
		// 퀸을 서로 송격할 수 없도록 놓는 경우의 수를 구하라
		// 서로 공격할 수 없게 두는게 뭔데..?
		// 퀸 자신을 기준으로 가로세로 대각선방향으로 아무것도 놓여있으면 안됨
		init();
		
		setQueen(0,0,0);
		System.out.println(numberOfWay);
		
	} // end of main
	
	
	/** map위에 queen을 하나씩 둔다 */
	private static void setQueen(int settedQueen, int cy, int cx) {
		if(settedQueen==numberOfQueen) {
			numberOfWay++;
			return;
		}
		for (int y = cy; y < numberOfQueen; y++) {
			for (int x = 0; x < numberOfQueen; x++) {
				if(!isPossible(y,x)) continue;
				queen.add(new int[] {y,x});
//				System.out.printf("%d,%d 대입\n", y,x);
				setQueen(settedQueen+1, y, x);
				if(queen.size()!=0) queen.remove(queen.size()-1); // 최근요소 제거
			}
		}
	}


	/** y,x에 퀸을 둘 수 있는지 판별 */
	private static boolean isPossible(int y, int x) {
//		System.out.println("isPossible start: "+queen.size());
		for (int i = 0; i < queen.size(); i++) {
			int[] cur = queen.get(i);
//			System.out.printf("(%d,%d) vs (%d,%d)\n", cur[0], cur[1], y,x);
			// 세로 검사
			if(cur[0]==y) return false;
			// 가로 검사
			if(cur[1]==x) return false;
			// 대각선 검사
			if(Math.abs(cur[0]-y) == Math.abs(cur[1]-x)) {
				return false;
			}
		}
		return true;
	}


	/** 객체 초기화 */
	private static void init() {
		Scanner sc = new Scanner(System.in);
		numberOfQueen = sc.nextInt(); // number of queen
		map = new int[numberOfQueen][numberOfQueen]; // N*N 체스판
	}
	
} // end of class
