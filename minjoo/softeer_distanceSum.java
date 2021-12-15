package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 다익스트라
// 답은 맞는 거 같은데 시간초과 나서 pq 탐색으로 바꿀 예정... 별3 어렵네요
public class softeer_distanceSum {
  static int[][] adj;
  static int[] dis;
  static boolean[] visited;
  static int N, answer;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());
    adj = new int[N][N];
    dis = new int[N];
    visited = new boolean[N];

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        adj[i][j] = Integer.MAX_VALUE;
      }
    }

    Arrays.fill(dis, Integer.MAX_VALUE);

    for (int i = 0; i < N - 1; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken()) - 1;
      int b = Integer.parseInt(st.nextToken()) - 1;
      int dist = Integer.parseInt(st.nextToken());

      adj[a][b] = dist;
      adj[b][a] = dist;
    }

    for (int i = 0; i < N; i++) {
      answer = 0;
      dijkstra(i);
      Arrays.fill(visited, false);
      Arrays.fill(dis, Integer.MAX_VALUE);
      sb.append(answer).append("\n");
    }

    System.out.print(sb.toString());
  }

  private static void dijkstra(int node) {
    // 시작 정점 초기화
    dis[node] = 0;
    visited[node] = true;

    // 연결 정점과의 거리 갱신
    for (int i = 0; i < N; i++) {
      if (!visited[i] && adj[node][i] != Integer.MAX_VALUE) {
        dis[i] = adj[node][i];
      }
    }

    // 정점이 N개 있을 때 반복수는 N-1번이면 된다.
    for (int i = 0; i < N - 1; i++) {
      int min = Integer.MAX_VALUE;
      int minIdx = -1;

      // 연결된 정점 중에서 최소 거리인 정점 찾기
      for (int j = 0; j < N; j++) {
        if (!visited[j] && dis[j] < min) {
          min = dis[j];
          minIdx = j;
        }
      }

      // 방문 체크
      visited[minIdx] = true;

      // 현재 선택한 정점을 통해 갈 수 있는 정점과의 거리 갱신
      for (int j = 0; j < N; j++) {

        // 아직 방문하지 않았으면서 연결되어있는 정점
        if (!visited[j] && adj[minIdx][j] != Integer.MAX_VALUE) {

          // 현재 선택한 정점을 통해 가는 거리가 바로 가는 거리보다 짧으면 갱신
          if (adj[minIdx][j] + dis[minIdx] < dis[j]) {
            dis[j] = adj[minIdx][j] + dis[minIdx];
          }
        }
      }
    }

    for (int i = 0; i < N; i++) {
      answer += dis[i];
    }
  }
}
