package programmers;

import java.util.ArrayList;

public class programmers_level2_maximumOperation {
  static char[] prior = { '+', '-', '*' };
  static boolean[] visited = new boolean[3];
  static ArrayList<Long> nums = new ArrayList<Long>();
  static ArrayList<Character> ops = new ArrayList<Character>();
  static long answer;

  public long solution(String expression) {
    answer = 0;
    String num = "";

    for (int i = 0; i < expression.length(); i++) {
      if (expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
        num += expression.charAt(i);
      } else {
        nums.add(Long.parseLong(num));
        num = "";
        ops.add(expression.charAt(i));
      }
    }
    nums.add(Long.parseLong(num));
    dfs(0, new char[3]);

    return answer;
  }

  public static Long calc(Long num1, Long num2, char op) {
    long num = 0;
    switch (op) {
      case '+': {
        return num1 + num2;
      }
      case '-': {
        return num1 - num2;
      }
      case '*': {
        return num1 * num2;
      }
    }
    return num;
  }

  public static void dfs(int count, char[] perm) {
    if (count == 3) {
      ArrayList<Long> cNums = new ArrayList<>(nums);
      ArrayList<Character> cOps = new ArrayList<Character>(ops);

      for (int i = 0; i < perm.length; i++) {
        for (int j = 0; j < cOps.size(); j++) {
          if (perm[i] == cOps.get(j)) {
            Long res = calc(cNums.remove(j), cNums.remove(j), perm[i]);
            cNums.add(j, res);
            cOps.remove(j);
            j--;
          }
        }
      }
      answer = Math.max(answer, Math.abs(cNums.get(0)));
      return;
    }

    for (int i = 0; i < 3; i++) {
      if (!visited[i]) {
        visited[i] = true;
        perm[count] = prior[i];
        dfs(count + 1, perm);
        visited[i] = false;
      }
    }
  }
}
