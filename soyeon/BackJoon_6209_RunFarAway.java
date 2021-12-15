package backJoon_6209_RunFarAway;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 일    시: 2021-12-14
 * 작 성 자: 유 소 연
 * https://www.acmicpc.net/problem/6209
 * */
public class BackJoon_6209_RunFarAway {
	static int d, n, m;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		// 작은 돌섬 m개를 제거후, 점프하는 최소거리의 최댓값을 구하라
		// 돌섬의 수가 5만까지이므로 조합... 안될거같은데;;; 그래서 골2구나..ㅎㅎ
		// m을 돌다리사이의 최소거리라 두고, 돌들을 탐색하며 이 최소거리로 건너뛸 수 있는 돌의개수를 체크
		// 즉 문제를 거꾸로 푼다.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// 돌섬으로부터 탈출구까지의 거리 d, 작은돌섬의 수 n, 제거할수있는 돌섬의수 m
		d = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n+2];
		// n개의 돌섬들
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		// end of input
		
		arr[n+1] = d;
		Arrays.sort(arr); // 이분탐색을 위해 정렬
		int left = 0;
		int right = d;
		int ans = 0;
		while(left <= right) {
			int mid = (left+right)/2;
			int pos = 0, cnt = 0;
			for (int i = 1; i <= n+1; i++) {
				if(arr[i] - arr[pos] < mid) {
					cnt++;
				} else {
					pos = i;
				}
			}
			
			if(cnt > m) {
				// cnt가 제거할수있는 돌섬 수보다 많다면
				right = mid-1;
			} else {
				// cnt가 제거할수있는 돌섬 수보다 적거나 같으면
				left = mid+1;
				ans = mid;
			}
		} // end of while
		System.out.println(ans);
	} // end of main
} // end of class
