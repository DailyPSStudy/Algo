package backJoon_11404_Floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 일    시: 2022-03-02 18:25~19:40
 * 작 성 자: 유 소 연
 * https://www.acmicpc.net/problem/11404
 * 플로이드와샬 알고리즘
 * */
public class Main {
	static final int INF = Integer.MAX_VALUE;
	static int n, m;
	static long[][] costs;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// 각 도시마다 다른 도시로 가는 최소비용을 출력하라
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// n 도시의 개수
		n = Integer.parseInt(br.readLine());
		// m 버스의 개수
		m = Integer.parseInt(br.readLine());
		costs = new long[n+1][n+1];
		for (int i = 0; i < n+1; i++) {
			for (int j = 0; j < n+1; j++) {
				if(i == j) continue; // 자기자신으로 가는 비용은 0
				costs[i][j] = INF;
			}
		}
		// 버스의 정보 (from, to, cost)
		StringTokenizer st;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
//			costs[from][to] = cost; // 그냥 이렇게 해주면 입력될 때 같은 from->to 이더라도 cost가 다른 경우가 있으므로 최소값이 들어가지 않게 된다.
			costs[from][to] = Math.min(costs[from][to], cost);
		}
		// end of input
		
		// print for test
//		for (int i = 1; i <= n; i++) {
//			for (int j = 1; j <= n; j++) {
//				System.out.print(costs[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		// Math.min(a->b, a->k->b)
		floydWarshall();
		
		// 출력
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if(costs[i][j] >= INF) sb.append(0).append(" ");
				else sb.append(costs[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
	
	
	private static void floydWarshall() {
		
		// k,i,j 순서 바뀌면 값 다르게 나옴
		for (int k = 1; k <= n; k++) { // 거쳐가는 도시 기준으로
			for (int i = 1; i <= n; i++) { // from
				for (int j = 1; j <= n; j++) { // to
					costs[i][j] = Math.min(costs[i][j], costs[i][k]+costs[k][j]);
				}
			}
		}
		
	} // end of floydWarshall
	
}
