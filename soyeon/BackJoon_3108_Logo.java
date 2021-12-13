package backJoon_3108_Logo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 일    시: 2021-12-12
 * 작 성 자: 유 소 연
 * https://www.acmicpc.net/problem/3108
 * */
public class BackJoon_3108_Logo {
	static int N;
	static Info[] map;
	static boolean[] visited;
	static Queue<Integer> q = new LinkedList<>();
	static int cnt;
	
	static class Info{
		int y1,x1,y2,x2;
		public Info(int y1, int x1, int y2,int x2) {
			this.y1 = y1;
			this.x1 = x1;
			this.y2 = y2;
			this.x2 = x2;
		}
	} // end of Info
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 직사각형을 그리는데 필요한 'PU' 명령어의 최솟값을 구하라
		// 즉, "펜을 떼는" PU 명령어의 최소 개수를 구하면 됨
		// => 접점이 없는 사각형들의 개수
		// 1. 한 직사각형 안에 완전히 내포되어 있지 않은 경우
		// 2. 상하좌우로 완전히 떨어져있는 경우
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new Info[N+1];
		visited = new boolean[N+1];
		map[0] = new Info(0,0,0,0); // 0,0에서부터 시작
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			map[i] = new Info(y1,x1,y2,x2);
		}
		
		for (int i = 0; i <= N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			q.add(i);
			while(q.size()!=0) {
				int cur = q.poll();
				for (int j = 0; j <= N; j++) {
					// 동일 직사각형이거나, 공유하는 부분이 없는 관계이거나, 이미 방문한적이 있으면 건너뛴다
					if(cur == j || !check(cur, j) || visited[j]) {
						continue;
					}
					visited[j] = true;
					q.add(j);
				} // end of for j
			} // end of while
			cnt++;
		} // end of for i
		System.out.println(cnt-1);
	} // end of main

	private static boolean check(int cur, int next) {
		Info c = map[cur];
		Info n = map[next];
		if(
			(c.x1<n.x1 && n.x2<c.x2 && c.y1<n.y1 && n.y2<c.y2) || // cur가 next를 내포하는 경우
			(c.x1>n.x1 && n.x2>c.x2 && c.y1>n.y1 && n.y2>c.y2) || // next가 cur를 내포하는 경우
			(c.x2<n.x1 || c.x1>n.x2 || c.y2<n.y1 || c.y1>n.y2) // 아예 서로 교차하지 않는경우
		) {
			return false;
		}
		return true;
	}
} // end of class
