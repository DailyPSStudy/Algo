package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

// boj 4134 다음 소수 (BigInteger의 소수찾기 메소드 사용: 밀러-라빈 소수판별법)
// https://ko.wikipedia.org/wiki/%EB%B0%80%EB%9F%AC-%EB%9D%BC%EB%B9%88_%EC%86%8C%EC%88%98%ED%8C%90%EB%B3%84%EB%B2%95
// 868ms
public class boj4134 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());
    for (int tc = 1; tc <= T; tc++) {
      // N보다 크거나 같은 소수 중 가장 작은 소수를 찾아야 한다.
      long N = Long.parseLong(br.readLine());    // 0 ≤ n ≤ 4*(10)^9
      BigInteger answer = new BigInteger(String.valueOf(N));

      if (answer.isProbablePrime(10)) {
        sb.append(answer).append("\n");
      } else {
        sb.append(answer.nextProbablePrime()).append("\n");
      }
    }
    
    System.out.print(sb.toString());
  }
}
