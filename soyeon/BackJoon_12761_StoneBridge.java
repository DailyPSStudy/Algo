package backJoon_12761_StoneBridge;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * ��    ��: 2021-12-12
 * �� �� ��: �� �� ��
 * https://www.acmicpc.net/problem/12761
 * */
public class BackJoon_12761_StoneBridge {
	static int A,B,N,M;
	static int min = Integer.MAX_VALUE;
	static boolean[] visited = new boolean[100001];
	
	public static void main(String[] args) {
		// ���԰� �ֹ̿��� �����ϱ����� �ּ��� �̵�Ƚ���� ���ض�
		// A,B,N,M
		Scanner sc = new Scanner(System.in);
		A = sc.nextInt(); // ������1
		B = sc.nextInt(); // ������2
		N = sc.nextInt(); // ������ġ
		M = sc.nextInt(); // �ֹ���ġ
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
