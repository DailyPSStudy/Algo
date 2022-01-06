package backJoon_15649_NAndM1;

import java.util.Scanner;

/**
 * ��    ��: 2022-01-05
 * �� �� ��: �� �� ��
 * https://www.acmicpc.net/problem/15649
 * */
public class backJoon_15649_NAndM1 {
	static StringBuilder sb;
	static int[] arr;
	static boolean[] visited;
	
	public static void main(String[] args) {
		
		// 1~N ���� �ڿ��� ��, �ߺ����� M���� �� ����
		// (���������� �����ϴ� ������� ���)
		// => �׳� �����ƴѰ�
		
		// �ڿ��� N, M (�Ѵ� 1~8 ������ ����)
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		init(N, M);
		permutation(0,N,M);
		
		System.out.print(sb);
		
	} // end of main

	
	/** 1~N������ �ڿ��� �� M�� ���� */
	private static void permutation(int depth, int N, int M) {
		if(depth==M) {
			putInSb(); // arr�� sb�� ����
			return;
		}
		for (int i = 1; i <= N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			arr[depth] = i;
			permutation(depth+1, N, M);
			visited[i] = false;
		}
	}
	
	
	/** ����� ���� arr�� sb�� ���� */
	private static void putInSb() {
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]).append(" ");
		}
		sb.append("\n");
	}
	
	/** ��ü�ʱ�ȭ */
	private static void init(int N, int M) {
		sb = new StringBuilder();
		arr = new int[M];
		visited = new boolean[N+1];
	}
} // end of class
