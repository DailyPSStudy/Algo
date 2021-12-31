package backJoon_1916_FindTheMiniumCost;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 일    시: 2021-12-31
 * 작 성 자: 유 소 연
 * https://www.acmicpc.net/problem/1916
 * */
public class BackJoon_1916_FindTheMiniumCost {
	static boolean[] visited;
	
	public static class Info implements Comparable<Info> {
		int from;
		int to;
		int cost;
		public Info(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		public int compareTo(Info o) {
			return this.cost-o.cost;
		}
	} // end of Info
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// A->B 최소비용을 구하라
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// numberOfCity
		int numberOfCity = Integer.parseInt(br.readLine());
		// numberOfBus
		int numberOfBus = Integer.parseInt(br.readLine());
		// 각 줄에 버스정보가 주어짐 (from, to, cost)
		List<List<int[]>> list = new ArrayList<>();
		visited = new boolean[numberOfCity+1];
		initList(list, numberOfCity);
		StringTokenizer st;
		for (int no = 1; no <= numberOfBus; no++) {
			st = new StringTokenizer(br.readLine(), " ");
			// 이중리스트에 담음
			list.get(Integer.parseInt(st.nextToken())).add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		}
		
//		printList(list);
		
		// 출발점의 도시번호, 도착점의 도시번호
		st = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(st.nextToken());
		int dest = Integer.parseInt(st.nextToken());
		// 우선순위큐에 출발점의 리스트를 담음
		PriorityQueue<Info> q = new PriorityQueue<>();
		List<int[]> info = list.get(start);
		visited[start] = true;
		for (int i = 0; i < info.size(); i++) {
			int[] cur = info.get(i);
			q.add(new Info(start, cur[0], cur[1]));
		}
		// end of input
		
		int answer = findMinCost(q, list, start, dest);
		System.out.println(answer);
	} // end of main


	/** start->dest 까지의 최소비용을 구함 */
	private static int findMinCost(PriorityQueue<Info> q, List<List<int[]>> list, int start, int dest) {
		// 꺼내서 이어나가며 큐에 담음 (꺼내는족족 현재위치가 도착지인지 확인함)
		// 만약 꺼냈는데 현재위치가 도착지면 바로 리턴
		int minCost = 0;
		while(q.size()!=0) {
			Info cur = q.poll();
//			System.out.printf("%d -> %d : %d\n", cur.from, cur.to, cur.cost);
			
			if(cur.to == dest) {
				minCost = cur.cost;
				break;
			}
			List<int[]> info = list.get(cur.to);
			int size = info.size();
			for (int i = 0; i < size; i++) {
				if(visited[info.get(i)[0]]) continue;
				visited[cur.to] = true;
				q.add(new Info(cur.to, info.get(i)[0], cur.cost+info.get(i)[1]));
			}
			
		} // end of while
		
		return minCost;
	} // end of findMinCost

	private static void initList(List<List<int[]>> list, int numberOfCity) {
		for (int i = 0; i <= numberOfCity; i++) {
			list.add(new ArrayList<>());
		}
	} // end of initList
	
	private static void printList(List<List<int[]>> list) {
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.get(i).size(); j++) {
				System.out.println(Arrays.toString(list.get(i).get(j)));
			}
		}
	}
	
} // end of class
