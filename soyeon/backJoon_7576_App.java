package backJoon_7576_App;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ��    ��: 2022-02-28
 * �� �� ��: �� �� ��
 * https://www.acmicpc.net/problem/7579
 * */
public class backJoon_7576_App {
	public static void main(String[] args) throws IOException {
		
		// ��Ȱ��ȭ�ϴµ� ��� ��� c�� �ּ�ȭ�Ͽ� M����Ʈ �޸𸮸� Ȯ������
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] memories = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			memories[i] = Integer.parseInt(st.nextToken());
		}
		int[] costs = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			costs[i] = Integer.parseInt(st.nextToken());
		}
		// end of input
		
		long ans = 10001;
		long[][] dp = new long[N][10001]; // dp[i][j] = i��° �۱��� ������� �� j�� ������� ���� �� �ִ� '�ִ�' �޸�
		for (int i = 0; i < N; i++) {
			int memory = memories[i];
			int cost = costs[i];
			
			for (int j = 0; j < 10001; j++) {
				if(i==0) {
					if(j>=cost) dp[i][j] = memory; // �ּ��� ���� cost�� �������� memory Ȯ������
				} else {
					if(j<cost) {
						dp[i][j] = dp[i-1][j];
					} else {
						dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-cost] + memory);
					}
				}
				
				// ���ؾ� �ϴ� �޸𸮸� �����ϸ鼭�� ���� �ּ��� ��� ����
				if(dp[i][j]>=M) {
					ans = Math.min(ans, j);
				}
			}
		} // end of for
		
		System.out.println(ans);
		
	} // end of main
} // end of class
