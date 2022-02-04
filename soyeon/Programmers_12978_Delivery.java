package programmers_12978_Delivery;
import java.util.*;
/**
 * ��    ��: 2022-02-03 3:30~4:40
 * �� �� ��: �� �� ��
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
        // �ʱ�ȭ
        List<List<Village>> relation = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            relation.add(new ArrayList<>());
        }
        
        // priorityQueue�� ���� ������ �ּҺ������� visited�� ���� ����
        PriorityQueue<Village> village = new PriorityQueue<>();
        
        // ����Ʈ�� ������ ���踦 ����
        for(int i = 0; i < R.length; i++) {
            int a = R[i][0];
            int b = R[i][1];
            relation.get(a).add(new Village(b, R[i][2]));
            relation.get(b).add(new Village(a, R[i][2]));
            // 1�� ����� �������� ó�� ť�� ����. �ʱ⼼������.
            if(a==1) {
                village.add(new Village(b, R[i][2]));
            }
            if(b==1) {
                village.add(new Village(a, R[i][2]));
            }
        }
        
        // Queue�� Node ��������. ������ ���üũ���ְ�. K���ϸ� �湮üũ���ְ�.
        int ans = 1; // 1�� ������ ����
        boolean[] visited = new boolean[N+1];
        visited[1] = true;
        while(village.size()!=0) {
            Village v = village.poll();
            
            // System.out.printf("n: %d, c: %d\n", v.n, v.c);
            
            if(v.c > K || visited[v.n]) continue;
            
            // System.out.println(v.n+" �湮");
            
            ans++;
            visited[v.n] = true;
            for(int i = 0; i < relation.get(v.n).size(); i++) {
                village.add(new Village(relation.get(v.n).get(i).n, v.c+relation.get(v.n).get(i).c));
            }
            
        } // end of while
        
        return ans;
    } // end of solution
} // end of class