package programmers_1829_KakaoFriendsColoringBook;

import java.util.*;
/**
* 일    시: 2021-12-13
* 작 성 자: 유 소 연
* https://programmers.co.kr/learn/courses/30/lessons/1829
*/
class Programmers_1829_KakaoFriendsColoringBook {
    static boolean[][] visited;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int cnt = 1;
    static int[] ans = new int[2];
    static List<int[]> list;
    
    public int[] solution(int m, int n, int[][] map) {
        // 이중반복문으로 전체맵을 탐색하며 0이아닌 원소 발견시 dfs로 탐색
        // dfs로 탐색하며 visited 체크
        visited = new boolean[m][n];
        ans = new int[2]; // ans[0]:색코드, ans[1]:영역개수
        list = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j]==0 || visited[i][j]) continue;
                visited[i][j] = true;
                dfs(i,j,map);
                list.add(new int[]{map[i][j], cnt});
                cnt = 1;
            }
        }
        // 내림차순 정렬
        Collections.sort(list, new Comparator<int[]>(){
           @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1]-o1[1];
            }
        });
        ans[0] = list.size();
        if(list.size()==0) {
            ans[1] = 0;
        } else {
            ans[1] = list.get(0)[1];   
        }
        return ans;
    } // end of solution
    
    public void dfs(int y, int x, int[][] map) {
        for(int d = 0; d < 4; d++) {
            int ny = y+dy[d];
            int nx = x+dx[d];
            if(!inRange(ny,nx,map) || map[ny][nx]!=map[y][x] || visited[ny][nx]) {
                continue;
            }
            visited[ny][nx] = true;
            cnt++;
            dfs(ny,nx,map);
        }
    } // end of dfs
    
    public boolean inRange(int ny, int nx, int[][] map) {
        return ny >= 0 && nx >= 0 && ny < map.length && nx < map[0].length;
    } // end of inRange
} // end of class