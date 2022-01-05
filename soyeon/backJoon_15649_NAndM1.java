package backJoon_15649_NAndM1;

import java.util.Scanner;

/**
 * 일    시: 2022-01-05
 * 작 성 자: 유 소 연
 * https://www.acmicpc.net/problem/15649
 * */
public class backJoon_15649_NAndM1 {
	static StringBuilder sb;
	static int[] arr;
	static boolean[] visited;
	
	public static void main(String[] args) {
		
		// 1~N 까지 자연수 중, 중복없이 M개를 고른 수열
		// (사전순으로 증가하는 순서대로 출력)
		// => 그냥 순열아닌가
		
		// 자연수 N, M (둘다 1~8 까지의 길이)
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		init(N, M);
		permutation(0,N,M);
		
		System.out.print(sb);
		
	} // end of main

	
	/** 1~N까지의 자연수 중 M개 나열 */
	private static void permutation(int depth, int N, int M) {
		if(depth==M) {
			putInSb(); // arr을 sb에 넣음
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
	
	
	/** 출력을 위해 arr을 sb에 넣음 */
	private static void putInSb() {
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]).append(" ");
		}
		sb.append("\n");
	}
	
	/** 객체초기화 */
	private static void init(int N, int M) {
		sb = new StringBuilder();
		arr = new int[M];
		visited = new boolean[N+1];
	}
} // end of class
