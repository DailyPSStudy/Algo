package backJoon_15681_TreeAndQuery;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
/**
 * 일    시: 2022-01-10
 * 작 성 자: 유 소 연
 * https://www.acmicpc.net/problem/15681
 * */
public class BackJoon_15681_TreeAndQuery {
	static int numberOfNode, rootNode, numberOfQuery, cnt;
	static List<List<Integer>> list;
	static int[] visited;
	
	public static void main(String[] args) throws IOException {
		
		// 정점의 수, 루트번호, 쿼리의 수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		numberOfNode = Integer.parseInt(st.nextToken());
		rootNode = Integer.parseInt(st.nextToken());
		numberOfQuery = Integer.parseInt(st.nextToken());
		
		// a - b (numberOfNode-1줄)
		list = new ArrayList<>();
		for (int i = 0; i <= numberOfNode; i++) {
			list.add(new ArrayList<>());
		}
		
		for (int i = 0; i < numberOfNode-1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		// 미리 한번 노드들의 서브쿼리의 노드수를 한번에 구해둠
		visited = new int[numberOfNode+1];
		visited[rootNode] = 1;
		int res = getNumberOfSubQuery(rootNode);
		
		// query
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < numberOfQuery; i++) {
			int target = Integer.parseInt(br.readLine());
			sb.append(visited[target]).append("\n");
		}
		System.out.print(sb);
	} // end of main

	
	/** target의 자식노드 */
	private static int getNumberOfSubQuery(int node) {
		List<Integer> child = list.get(node);
		
//		System.out.printf("%dnode\n",node);
		
		for (int i = 0; i < child.size(); i++) {
			if(visited[child.get(i)]!=0) continue;
			visited[child.get(i)] = 1;
//			System.out.printf("go to %d node..\n", child.get(i));
			visited[node] += getNumberOfSubQuery(child.get(i));
//			System.out.printf("%d is after %d node..! visited => %d\n", node, child.get(i), visited[node]);
		}
		return visited[node];
	}
	
	
} // end of class
