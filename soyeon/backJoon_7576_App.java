package backJoon_7576_App;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 일    시: 2022-02-28
 * 작 성 자: 유 소 연
 * https://www.acmicpc.net/problem/7579
 * */
public class backJoon_7576_App {
	public static void main(String[] args) throws IOException {
		
		// 재활성화하는데 드는 비용 c를 최소화하여 M바이트 메모리를 확보하자
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
		long[][] dp = new long[N][10001]; // dp[i][j] = i번째 앱까지 사용했을 때 j의 비용으로 얻을 수 있는 '최대' 메모리
		for (int i = 0; i < N; i++) {
			int memory = memories[i];
			int cost = costs[i];
			
			for (int j = 0; j < 10001; j++) {
				if(i==0) {
					if(j>=cost) dp[i][j] = memory; // 최소한 현재 cost와 같아져야 memory 확보가능
				} else {
					if(j<cost) {
						dp[i][j] = dp[i-1][j];
					} else {
						dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-cost] + memory);
					}
				}
				
				// 구해야 하는 메모리를 만족하면서도 가장 최소인 비용 저장
				if(dp[i][j]>=M) {
					ans = Math.min(ans, j);
				}
			}
		} // end of for
		
		System.out.println(ans);
		
	} // end of main
} // end of class
