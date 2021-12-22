package programmers;

public class programmers_level2_124country_number {
  public static void main(String[] args) {
    System.out.println(solution(4));
  }

  public static String solution(int n) {
    // n은 5억 이하의 자연수. 이 때, 아래의 식은 시간복잡도는 O(N/3) 밖에 되지 않으므로, 괜찮음.
    // 제한 시간이 제시가 안 돼 있어서 O(N)으로 평범하게 생각하면 5초.... 이내에 통과하면 되는 것 같음.
    StringBuilder sb = new StringBuilder();

    int num = n;
    while (num != 0) {
      int front = num / 3;
      int back = num % 3;
      if (back == 0) {
        // 나머지가 0일 때,
        front = front - 1;
        back = 4;
      }

      num = front;
      sb.insert(0, back);
    }

    return sb.toString();
  }
}
