package backJoon_12761_StoneBridge;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 일    시: 2021-12-12
 * 작 성 자: 유 소 연
 * https://www.acmicpc.net/problem/12761
 * */
public class BackJoon_12761_StoneBridge {
	static int A,B,N,M;
	static int min = Integer.MAX_VALUE;
	static boolean[] visited = new boolean[100001];
	
	public static void main(String[] args) {
		// 동규가 주미에게 도달하기위한 최소한 이동횟수를 구해라
		// A,B,N,M
		Scanner sc = new Scanner(System.in);
		A = sc.nextInt(); // 콩콩이1
		B = sc.nextInt(); // 콩콩이2
		N = sc.nextInt(); // 동규위치
		M = sc.nextInt(); // 주미위치
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0,N}); // step, res
		visited[N] = true;
		bfs(q);
	} // end of main

	private static void bfs(Queue<int[]> q) {
		while(q.size()!=0) {
			int[] cur = q.poll();
			int step = cur[0];
			int res = cur[1];
			if(res == M) {
				if(min > step) min = step;
				System.out.printf("%d\n", step);
				return;
			}
			if(res+1<100001 && !visited[res+1]) {
				visited[res+1] = true;
				q.add(new int[] {step+1, res+1});
			}
			if(res-1>=0 && !visited[res-1]) {
				visited[res-1] = true;
				q.add(new int[] {step+1, res-1});
			}
			if(res+A<100001 && !visited[res+A]) {
				visited[res+A] = true;
				q.add(new int[] {step+1, res+A});
			}
			if(res-A>=0 && !visited[res-A]) {
				visited[res-A] = true;
				q.add(new int[] {step+1, res-A});
			}
			if(res+B<100001 && !visited[res+B]) {
				visited[res+B] = true;
				q.add(new int[] {step+1, res+B});
			}
			if(res-B>=0 && !visited[res-B]) {
				visited[res-B] = true;
				q.add(new int[] {step+1, res-B});
			}
			if(res*A<100001 && !visited[res*A]) {
				visited[res*A] = true;
				q.add(new int[] {step+1, res*A});
			}
			if(res*B<100001 && !visited[res*B]) {
				visited[res*B] = true;
				q.add(new int[] {step+1, res*B});
			}
		}
	} // end of bfs

} // end of class
