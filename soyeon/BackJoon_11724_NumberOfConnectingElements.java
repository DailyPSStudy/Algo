package backJoon_11724_NumberOfConnectingElements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 일    시: 2021-12-22
 * 작 성 자: 유 소 연
 * https://www.acmicpc.net/problem/11724
 * */
public class BackJoon_11724_NumberOfConnectingElements {
	static int N, M, cnt;
	static List<List<Integer>> list = new ArrayList<>(); // 연결관계
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		// N: 정점의 개수, M: 간선의 개수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N+1]; // 1~N노드 체크
		// list 공간할당
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}
		// end of input
		
		// visited가 없는 노드만 타고들어간다. 빠져나오게 되면 cnt++
		for (int i = 1; i < list.size(); i++) {
//			System.out.printf("%d번 노드\n", i);
			if(visited[i]) continue;
			cnt++;
			visited[i] = true;
//			System.out.printf("[%d] %d번 노드 타고들어감\n", cnt, i);
			dfs(i); // i번 노드부터 시작
		}
		System.out.println(cnt);
	} // end of main

	private static void dfs(int cur) {
		List<Integer> next = list.get(cur);
//		System.out.printf("%d와 연결된 노드들: ", cur);
//		System.out.println(next);
		for (int i = 0; i < next.size(); i++) {
			if(visited[next.get(i)]) continue;
			visited[next.get(i)] = true;
			dfs(next.get(i));
		}
	} // end of dfs
} // end of class
