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
 * ��    ��: 2022-03-02 18:25~19:40
 * �� �� ��: �� �� ��
 * https://www.acmicpc.net/problem/11404
 * �÷��̵�ͼ� �˰���
 * */
public class Main {
	static final int INF = Integer.MAX_VALUE;
	static int n, m;
	static long[][] costs;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// �� ���ø��� �ٸ� ���÷� ���� �ּҺ���� ����϶�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// n ������ ����
		n = Integer.parseInt(br.readLine());
		// m ������ ����
		m = Integer.parseInt(br.readLine());
		costs = new long[n+1][n+1];
		for (int i = 0; i < n+1; i++) {
			for (int j = 0; j < n+1; j++) {
				if(i == j) continue; // �ڱ��ڽ����� ���� ����� 0
				costs[i][j] = INF;
			}
		}
		// ������ ���� (from, to, cost)
		StringTokenizer st;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
//			costs[from][to] = cost; // �׳� �̷��� ���ָ� �Էµ� �� ���� from->to �̴��� cost�� �ٸ� ��찡 �����Ƿ� �ּҰ��� ���� �ʰ� �ȴ�.
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
		
		// ���
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
		
		// k,i,j ���� �ٲ�� �� �ٸ��� ����
		for (int k = 1; k <= n; k++) { // ���İ��� ���� ��������
			for (int i = 1; i <= n; i++) { // from
				for (int j = 1; j <= n; j++) { // to
					costs[i][j] = Math.min(costs[i][j], costs[i][k]+costs[k][j]);
				}
			}
		}
		
	} // end of floydWarshall
	
}
