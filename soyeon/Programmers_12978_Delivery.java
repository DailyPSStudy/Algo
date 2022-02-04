package programmers_12978_Delivery;
import java.util.*;
/**
 * 일    시: 2022-02-03 3:30~4:40
 * 작 성 자: 유 소 연
 * https://programmers.co.kr/learn/courses/30/lessons/12978
 * */
class Programmers_12978_Delivery {
    
    class Village implements Comparable<Village>{
        int n;
        int c;
        public Village(int n, int c) {
            this.n = n;
            this.c = c;
        }
        
        @Override
        public int compareTo(Village o) {
            return this.c - o.c;
        }
    }
    
    public int solution(int N, int[][] R, int K) {
        
        // BFS
        // 초기화
        List<List<Village>> relation = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            relation.add(new ArrayList<>());
        }
        
        // priorityQueue를 하지 않으면 최소비용순으로 visited가 되지 않음
        PriorityQueue<Village> village = new PriorityQueue<>();
        
        // 리스트에 마을간 관계를 넣음
        for(int i = 0; i < R.length; i++) {
            int a = R[i][0];
            int b = R[i][1];
            relation.get(a).add(new Village(b, R[i][2]));
            relation.get(b).add(new Village(a, R[i][2]));
            // 1과 연결된 마을들을 처음 큐에 넣음. 초기세팅해줌.
            if(a==1) {
                village.add(new Village(b, R[i][2]));
            }
            if(b==1) {
                village.add(new Village(a, R[i][2]));
            }
        }
        
        // Queue에 Node 넣은다음. 꺼내서 비용체크해주고. K이하면 방문체크해주고.
        int ans = 1; // 1은 무조건 포함
        boolean[] visited = new boolean[N+1];
        visited[1] = true;
        while(village.size()!=0) {
            Village v = village.poll();
            
            // System.out.printf("n: %d, c: %d\n", v.n, v.c);
            
            if(v.c > K || visited[v.n]) continue;
            
            // System.out.println(v.n+" 방문");
            
            ans++;
            visited[v.n] = true;
            for(int i = 0; i < relation.get(v.n).size(); i++) {
                village.add(new Village(relation.get(v.n).get(i).n, v.c+relation.get(v.n).get(i).c));
            }
            
        } // end of while
        
        return ans;
    } // end of solution
} // end of class