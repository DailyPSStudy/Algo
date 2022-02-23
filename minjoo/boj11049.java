package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// boj 11049 행렬 곱셈 순서(dp)
// 252ms
public class boj11049 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N = Integer.parseInt(br.readLine());    // 행렬의 개수. 1 ~ 500
    int max = 123_456_789;

    int[] arr = new int[N+1];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      arr[i] = Integer.parseInt(st.nextToken());      // r, c 1~500사이의 수
      arr[i + 1] = Integer.parseInt(st.nextToken());
    }
    
    int[][] dp = new int[N][N]; // 앞뒤로 한 번씩 곱한거 저장하기

    for (int i = 2; i < N + 1; i++) {
      // Bottom-Up 방식
      for (int j = 0; j < N - i + 1; j++) {
        dp[j][j + i - 1] = max;
        for (int k = j; k < j + i - 1; k++) {
          int val = dp[j][k] + dp[k + 1][j + i - 1] + (arr[j] * arr[k + 1] * arr[j + i]);
          dp[j][j + i - 1] = Math.min(dp[j][j + i - 1], val);
        }
      }
    }

    System.out.println(dp[0][N-1]);
  }
}
