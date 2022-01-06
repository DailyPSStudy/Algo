package backJoon_1074_Z;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 일    시: 2022-01-05
 * 작 성 자: 유 소 연
 * https://www.acmicpc.net/problem/1074
 * 멤초 (N의 범위가 13을 넘어가기 때문에)
 * */
public class BackJoon_1074_Z_TimeOut {
	static int N, num, size;
	static int[][] map;
	static int y, x;
	
	public static void main(String[] args) {
		
		// N,r,c
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		init();
		y = sc.nextInt();
		x = sc.nextInt();
		
		// N에서부터 *1/2 해가며 N==1일때 1,2,3,4분면으로 넣어준다.
		dfs(0,0,size,size,N);
//		printMap();
		// y,x 좌표의 값(map[y][x]) 을 찾음
		System.out.println(map[y][x]);
	} // end of main

	
	/** n-1 해가며 n==1일때 1,2,3,4분면으로 넣어줌 */
	private static void dfs(int a, int b, int c, int d, int n) {
		if(n==1) {
			setMap(a,b,c,d);
			return;
		}
		
		// 범위내에 있으면 dfs로 더 타고들어감
		int nSize = (int)Math.pow(2, n);
//		System.out.println("n: "+n);
//		System.out.println("1사분면");
		dfs(a, b, a+nSize/2, b+nSize/2, n-1);
		
//		System.out.println("2사분면");
		dfs(a, b+nSize/2, a+nSize/2, d, n-1);
		
//		System.out.println("3사분면");
		dfs(a+nSize/2, b, c, b+nSize/2, n-1);
		
//		System.out.println("4사분면");
		dfs(a+nSize/2, b+nSize/2, c, d, n-1);
	}
	

	/** (a,b)~(c,d) 에 해당하는 2*2 영역을 num을 증가시키며 넣음 */
	private static void setMap(int a, int b, int c, int d) {
//		System.out.println("==setMap==");
//		System.out.printf("a: %d, b: %d, c: %d, d: %d\n", a,b,c,d);
		
		for (int y = a; y < c; y++) {
			for (int x = b; x < d; x++) {
				map[y][x] = num;
				num++;
			}
		}
		printMap();
	}


	/** 객체 초기화 */
	private static void init() {
		num = 0;
		size = (int)Math.pow(2, N);
		map = new int[size][size];
	}
	
	
	/** print map */
	private static void printMap() {
		for (int y = 0; y < map.length; y++) {
			System.out.println(Arrays.toString(map[y]));
		}
	}
	
} // end of class
