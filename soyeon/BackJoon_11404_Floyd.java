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
 * BFS
 * 시간초과
 * */
public class BackJoon_11404_Floyd {
	static final int INF = Integer.MAX_VALUE;
	static int n, m;
	static List<List<int[]>> info;
	static long[][] costs;
	static PriorityQueue<Info> pq;
	static boolean DEBUG = false;
	
	static class Info implements Comparable<Info> {
		int from;
		int to;
		int cost;
		public Info (int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		@Override
		public int compareTo(Info o) {
			return this.cost - o.cost;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// PriorityQueue로 풀어볼까...
		// 내 뇌내망상에 따르자면, 시간초과 나는게 정상
		// -> 내 뇌피셜이 맞았음 시간초과나옴ㅋㅋㅋ n*m*a = 최소 1억 넘어감
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// n (도시의 개수)
		n = Integer.parseInt(br.readLine());
		// m (버스의 개수)
		m = Integer.parseInt(br.readLine());
		costs = new long[n+1][n+1];
		for (int i = 0; i < n+1; i++) {
			for (int j = 0; j < n+1; j++) {
				if(i == j) continue;
				costs[i][j] = INF;
			}
		}
		pq = new PriorityQueue<Info>();
		// 버스의 정보
		info = new ArrayList<>();
		for (int i = 0; i < m+1; i++) {
			info.add(new ArrayList<int[]>());
		}
		StringTokenizer st;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			info.get(from).add(new int[] {to, cost});
		}
		// end of input
		
		for (int start = 1; start <= n; start++) { // 1~n 도시까지 최소비용 구하기
			
			if(DEBUG) System.out.printf("[ %d 조사 시작] \n", start);
			
			
			List<int[]> _info = info.get(start);
			for (int i = 0; i < _info.size(); i++) {
				pq.add(new Info(start, _info.get(i)[0], _info.get(i)[1]));
			}
			boolean[] visited = new boolean[n+1];
			while(pq.size() != 0) {
				
				Info cur = pq.poll();
				if(DEBUG) System.out.printf("%d -> %d 방문\n", cur.from, cur.to);
				
				visited[cur.from] = true; // 방문처리
				
				if(costs[start][cur.to] > cur.cost) {
					costs[start][cur.to] = cur.cost; // cost 갱신
				}
				
				List<int[]> __info = info.get(cur.to);
				if(DEBUG) System.out.printf("%d list size: %d\n", cur.to, __info.size());
				
				for (int i = 0; i < __info.size(); i++) {
					if(DEBUG) System.out.printf("%d -> %d: %d\n", cur.from, __info.get(i)[0], __info.get(i)[1]);
					if(visited[__info.get(i)[0]]) continue;
					pq.add(new Info(cur.to, __info.get(i)[0], cur.cost+__info.get(i)[1]));
				}
				
			} // end of while
			
		} // end of for (1~n 탐색)
		
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				sb.append(costs[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
