package backJoon_1074_Z;

import java.util.Scanner;

/**
 * ��    ��: 2022-01-05
 * �� �� ��: �� �� ��
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
		
		// N�������� *1/2 �ذ��� N==1�϶� 1,2,3,4�и����� �־��ش�.
		dfs(0,0,size);
//		printMap();
		// y,x ��ǥ�� ��(map[y][x]) �� ã��
		System.out.println(count);
	} // end of main

	
	private static void dfs(int a, int b, int n) {
		if(a==y && b==x) {
			System.out.println(count);
			System.exit(0);
		}
		
		// �������� ������ dfs�� �� Ÿ���
		if(inRange(a,b,n)) {
//			System.out.printf("(%d,%d) �������� �ֽ��ϴ�.\n", a,b);
			dfs(a, b, n/2);
			dfs(a, b+n/2, n/2);
			dfs(a+n/2, b, n/2);
			dfs(a+n/2, b+n/2, n/2);
		}else {
			// �������� ������ �տ��� ī��Ʈ.
			count += n*n;
//			System.out.printf("(%d,%d) �������� �����ϴ� => count: %d\n", a,b,count);
		}
	}
	

	/** y,x�� �ش� �������� �ִ��� ���� */
	private static boolean inRange(int a, int b, int size) {
		return y>=a && x>=b && y<a+size && x<b+size;
	}


	/** ��ü �ʱ�ȭ */
	private static void init() {
		size = (int)Math.pow(2, N);
	}
	
} // end of class
