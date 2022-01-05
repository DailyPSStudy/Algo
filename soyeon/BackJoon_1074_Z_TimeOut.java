package backJoon_1074_Z;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ��    ��: 2022-01-05
 * �� �� ��: �� �� ��
 * https://www.acmicpc.net/problem/1074
 * ���� (N�� ������ 13�� �Ѿ�� ������)
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
		
		// N�������� *1/2 �ذ��� N==1�϶� 1,2,3,4�и����� �־��ش�.
		dfs(0,0,size,size,N);
//		printMap();
		// y,x ��ǥ�� ��(map[y][x]) �� ã��
		System.out.println(map[y][x]);
	} // end of main

	
	/** n-1 �ذ��� n==1�϶� 1,2,3,4�и����� �־��� */
	private static void dfs(int a, int b, int c, int d, int n) {
		if(n==1) {
			setMap(a,b,c,d);
			return;
		}
		
		// �������� ������ dfs�� �� Ÿ���
		int nSize = (int)Math.pow(2, n);
//		System.out.println("n: "+n);
//		System.out.println("1��и�");
		dfs(a, b, a+nSize/2, b+nSize/2, n-1);
		
//		System.out.println("2��и�");
		dfs(a, b+nSize/2, a+nSize/2, d, n-1);
		
//		System.out.println("3��и�");
		dfs(a+nSize/2, b, c, b+nSize/2, n-1);
		
//		System.out.println("4��и�");
		dfs(a+nSize/2, b+nSize/2, c, d, n-1);
	}
	

	/** (a,b)~(c,d) �� �ش��ϴ� 2*2 ������ num�� ������Ű�� ���� */
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


	/** ��ü �ʱ�ȭ */
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
