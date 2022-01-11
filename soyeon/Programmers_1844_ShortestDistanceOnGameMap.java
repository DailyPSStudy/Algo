package programmers_1844_ShortestDistanceOnGameMap;

import java.util.PriorityQueue;

/**
 * 일    시: 2022-01-12
 * 작 성 자: 유 소 연
 * https://programmers.co.kr/learn/courses/30/lessons/1844
 * */
public class Programmers_1844_ShortestDistanceOnGameMap {
	static boolean[][] visited;
    
    class Node implements Comparable<Node> {
        int y;
        int x;
        int len;
        public Node(int y, int x, int len) {
            this.y = y;
            this.x = x;
            this.len = len;
        }
        @Override
        public int compareTo(Node o) {
            return this.len-o.len;
        }
    } // end of Node
    
    public int solution(int[][] map) {
        int answer = 0;
        
        // (0,0) -> (size,size) 까지의 최단거리를 구하라
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(0,0,1));
        visited = new boolean[map.length][map[0].length];
        visited[0][0] = true;
        answer = go(q, map);
        
        return answer;
    } // end of solution
    
    
    public int go(PriorityQueue<Node> q, int[][] map) {
        int[] dy = {-1,1,0,0};
        int[] dx = {0,0,-1,1};
        int len = 0;
        boolean isFind = false;
        while(q.size()!=0) {
            
            Node cur = q.poll();
            // System.out.printf("(%d,%d) : %d\n", cur.y,cur.x,cur.len);
            len = cur.len; // 이거의 위치차이임.... len 오름차순정렬로 실시간으로 바뀌기때문에, 반드시 이전len보다 1만 크다는 보장이 없어
            if(cur.y==map.length-1 && cur.x==map[0].length-1) {
                isFind = true;
                break;
            }
            
            // len = cur.len; // return이 아닌 break로 할거면 여기에 두면 안됨
            for(int d = 0; d < 4; d++) {
                int ny = cur.y+dy[d];
                int nx = cur.x+dx[d];
                if(!inRange(ny,nx,map.length,map[0].length) || visited[ny][nx] || map[ny][nx]==0) {
                    // System.out.printf("(%d,%d) -> 범위를 벗어났거나 방문했거나 벽\n",ny,nx);
                    continue;
                }
                // System.out.printf("(%d,%d) -> 큐에 넣음\n",ny,nx);
                visited[ny][nx] = true;
                q.add(new Node(ny,nx,len+1));
            } // find the dir
            
        } // end of while
        
        if(isFind) return len;
        else return -1;
    }
    
    
    public boolean inRange(int ny, int nx, int Y, int X) {
        return ny>=0 && nx>=0 && ny<Y && nx<X;
    }
    
} // end of class
