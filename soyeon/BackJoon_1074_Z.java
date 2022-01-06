package backJoon_1074_Z;

import java.util.Scanner;

/**
 * 일    시: 2022-01-05
 * 작 성 자: 유 소 연
 * https://www.acmicpc.net/problem/1074
 * */
public class BackJoon_1074_Z {
	static int N, size;
	static int y, x, count;
	
	public static void main(String[] args) {
		
		// N,r,c
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		init();
		y = sc.nextInt();
		x = sc.nextInt();
		
		// N에서부터 *1/2 해가며 N==1일때 1,2,3,4분면으로 넣어준다.
		dfs(0,0,size);
//		printMap();
		// y,x 좌표의 값(map[y][x]) 을 찾음
		System.out.println(count);
	} // end of main

	
	private static void dfs(int a, int b, int n) {
		if(a==y && b==x) {
			System.out.println(count);
			System.exit(0);
		}
		
		// 범위내에 있으면 dfs로 더 타고들어감
		if(inRange(a,b,n)) {
//			System.out.printf("(%d,%d) 범위내에 있습니다.\n", a,b);
			dfs(a, b, n/2);
			dfs(a, b+n/2, n/2);
			dfs(a+n/2, b, n/2);
			dfs(a+n/2, b+n/2, n/2);
		}else {
			// 범위내에 없으면 앞에거 카운트.
			count += n*n;
//			System.out.printf("(%d,%d) 범위내에 없습니다 => count: %d\n", a,b,count);
		}
	}
	

	/** y,x가 해당 범위내에 있는지 리턴 */
	private static boolean inRange(int a, int b, int size) {
		return y>=a && x>=b && y<a+size && x<b+size;
	}


	/** 객체 초기화 */
	private static void init() {
		size = (int)Math.pow(2, N);
	}
	
} // end of class
