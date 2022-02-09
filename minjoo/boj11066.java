package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// boj 11066 파일 합치기 (dp)
// 소설 장의 수가 500 이하, 파일의 크기는 1만 미만으로 시간 복잡도가 O(N^3) = 최악의 경우 125*1백만 = 1.25억회로 1초가 조금 넘게 걸린다.
// * 인접한 페이지를 더해야한다는 제한 조건을 꼭 생각하기
class boj11066 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());
    for (int tc = 0; tc < T; tc++) {
      int N = Integer.parseInt(br.readLine());
      String str[] = br.readLine().split(" ");
      int arr[] = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = Integer.parseInt(str[i]);
      }
      sb.append(function(arr)).append("\n");
    }

    System.out.print(sb.toString());
  }

  public static int function(int[] arr) {
    int dp[][] = new int[arr.length][arr.length];
    int s[] = new int[arr.length];
    s[0] = arr[0];
    for (int i = 1; i < arr.length; i++) {
      s[i] = s[i - 1] + arr[i];
    }
    for (int i = 0; i < arr.length - 1; i++) {
      dp[i][i + 1] = arr[i] + arr[i + 1];
    }
    for (int gap = 2; gap < arr.length; gap++) {
      for (int i = 0; i + gap < arr.length; i++) {
        int j = i + gap;
        dp[i][j] = 123_456_789;

        for (int k = i; k < j; k++) {
          dp[i][j] = Math.min(dp[i][k] + dp[k + 1][j]
            + i == 0 ? s[j] : s[j] - s[i-1], dp[i][j]);
        }
      }
    }
    return dp[0][arr.length - 1];
  }
}