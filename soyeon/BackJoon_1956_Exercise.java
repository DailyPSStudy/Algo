package backJoon_1956_Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 일    시: 2022-03-14
 * 작 성 자: 유 소 연
 * https://www.acmicpc.net/problem/1956
 * 1:N 최단경로 문제는 다익스트라
 * 음수사이클은 벨만-포드
 * N:N 최단경로 문제는 플로이드 와샬
 * */
public class BackJoon_1956_Exercise {
	static int V, E;
	static long dis[][];
	static final long INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		dis = new long[V+1][V+1];
		for (int i = 0; i < dis.length; i++) {
			for (int j = 0; j < dis.length; j++) {
				dis[i][j] = INF;
			}
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			dis[a][b] = Math.min(dis[a][b], cost);
		}
		
		floydWarshall();
		
		// 가장 작은 경로비용 구하기
		long ans = INF;
		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++) {
				if(i==j) continue;
				
				// 사이클 유무 판별
				if(dis[i][j]!=INF && dis[j][i]!=INF) {
					ans = Math.min(ans, dis[i][j]+dis[j][i]);
				}
			}
		}
		
		ans = (ans == INF) ? -1 : ans;
		System.out.println(ans);
		
	} // end of main

	
	/**
	 * 플로이드-와샬
	 * */
	private static void floydWarshall() {
		for (int k = 1; k <= V; k++) { // 중간지점 기준
			for (int i = 1; i <= V; i++) { // 출발지
				for (int j = 1; j <= V; j++) { // 도착지
					if(i==j) continue;
					if(dis[i][j] > dis[i][k] + dis[k][j]) {
						dis[i][j] = dis[i][k] + dis[k][j];
					}
				}
			}
		}
	}
	
} // end of class
