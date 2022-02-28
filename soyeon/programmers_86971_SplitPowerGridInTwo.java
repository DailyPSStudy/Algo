package programmers_86971_SplitPowerGridInTwo;
import java.util.*;
// 2022-02-28
class programmers_86971_SplitPowerGridInTwo {
    static List<List<Integer>> rel;
    static boolean[] visited;
    static int min;
    
    public int solution(int n, int[][] wires) {
        
        // 제거할 와이어 선정
        min = 100;
        for(int i = 0; i < wires.length; i++) {
            int[][] copyOfWires = copyArray(wires);
            visited = new boolean[n+1];
            copyOfWires[i] = null; // 해당 와이어 제거
            init(n, copyOfWires);
            
            // start 노드 정하기
            // start=1로 하되, 1이 잘린간선이면 맨끝노드를 start로
            int start = 1;
            if(wires[i][0]==1 || wires[i][1]==1) start = n;
            int num = dfs(start); int ex = n-num;
            int diff = Math.abs(num-ex);
            if(min > diff) min = diff;
        }
        
        return min;
    } // end of solution
    
    
    public int dfs(int start) {
        int cnt = 1;
        visited[start] = true;
        List<Integer> list = rel.get(start);
        for(int i = 0; i < list.size(); i++) {
            int dest = list.get(i);
            if(visited[dest]) continue;
            cnt += dfs(dest);
        }
        return cnt;
    }
    
    
    public int[][] copyArray(int[][] wires) {
        int[][] res = new int[wires.length][wires[0].length];
        for(int i = 0; i < wires.length; i++) {
            for(int j = 0; j < wires[i].length; j++) {
                res[i][j] = wires[i][j];
            }
        }
        return res;
    }
    
    
    public void init(int n, int[][] wires) {
        rel = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            rel.add(new ArrayList<>());
        }
        for(int i = 0; i < wires.length; i++) {
            if(wires[i] == null) continue;
            int a = wires[i][0];
            int b = wires[i][1];
            rel.get(a).add(b);
            rel.get(b).add(a);
        }
    }
    
} // end of class