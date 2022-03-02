package backJoon_11657_Timemachine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 일    시: 2022-03-02 8:50~
 * 작 성 자: 유 소 연
 * https://www.acmicpc.net/problem/11657
 * 벨만포드 알고리즘
 * 음의 가중치가 없다면 BFS로 풀 수 있지만, 그렇지 않은 경우는 벨만포드 알고리즘을 사용한다.
 * */
public class BackJoon_11657_Timemachine {
	static final int INF = Integer.MAX_VALUE;
	static int N, M;
	static List<Route> routes = new ArrayList<>();
	static long[] costs; // int가 아닌 long으로 선언해야 출력초과 에러가 나지 않음
	
	static class Route {
		int from;
		int to;
		int cost;
		public Route(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// 1번 도시에서 출발해 나머지 도시로 가는 가장 빠른 시간을 구하라
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// N(도시의 개수), M(버스노선 개수)
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		costs = new long[N+1]; // 해당 도시로 가는데 걸리는 비용
		Arrays.fill(costs, INF);
		// 버스노선 정보 A,B,C(from,to,cost)
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			routes.add(new Route(A,B,C));
		}
		// end of input
		
		StringBuilder sb = new StringBuilder();
		if(bellmanford(1)) {
			sb.append(-1).append("\n");
		} else {
			for (int i = 2; i <= N; i++) {
				if(costs[i] == INF) {
					sb.append(-1).append("\n");
				} else {
					sb.append(costs[i]).append("\n");
				}
			}
		}
		sb.setLength(sb.length()-1);
		System.out.print(sb);
	}

	
	private static boolean bellmanford(int start) {
		boolean cycle = false;
		costs[start] = 0;
		
		for (int i = 0; i < N+1; i++) { // 간선 수만큼 순회
			for (int j = 0; j < M; j++) {
				int from = routes.get(j).from;
				int to = routes.get(j).to;
				int cost = routes.get(j).cost;
				
				// 시작점 최단경로가 무한대가 아닐 경우
				// 시작점 최단경로+목적지까지 가중치가 목적지 최단경로보다 작을 때 업데이트
				if(costs[from] != INF && costs[from]+cost < costs[to]) {
					costs[to] = costs[from] + cost;
					if(i==N) cycle = true;
				}
			}
		}
		
		return cycle;
	}
	
}
