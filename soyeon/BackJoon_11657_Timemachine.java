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
 * ��    ��: 2022-03-02 8:50~
 * �� �� ��: �� �� ��
 * https://www.acmicpc.net/problem/11657
 * �������� �˰���
 * ���� ����ġ�� ���ٸ� BFS�� Ǯ �� ������, �׷��� ���� ���� �������� �˰����� ����Ѵ�.
 * */
public class BackJoon_11657_Timemachine {
	static final int INF = Integer.MAX_VALUE;
	static int N, M;
	static List<Route> routes = new ArrayList<>();
	static long[] costs; // int�� �ƴ� long���� �����ؾ� ����ʰ� ������ ���� ����
	
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
		// 1�� ���ÿ��� ����� ������ ���÷� ���� ���� ���� �ð��� ���϶�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// N(������ ����), M(�����뼱 ����)
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		costs = new long[N+1]; // �ش� ���÷� ���µ� �ɸ��� ���
		Arrays.fill(costs, INF);
		// �����뼱 ���� A,B,C(from,to,cost)
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
		
		for (int i = 0; i < N+1; i++) { // ���� ����ŭ ��ȸ
			for (int j = 0; j < M; j++) {
				int from = routes.get(j).from;
				int to = routes.get(j).to;
				int cost = routes.get(j).cost;
				
				// ������ �ִܰ�ΰ� ���Ѵ밡 �ƴ� ���
				// ������ �ִܰ��+���������� ����ġ�� ������ �ִܰ�κ��� ���� �� ������Ʈ
				if(costs[from] != INF && costs[from]+cost < costs[to]) {
					costs[to] = costs[from] + cost;
					if(i==N) cycle = true;
				}
			}
		}
		
		return cycle;
	}
	
}
