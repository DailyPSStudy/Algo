package programmers_1844_ShortestDistanceOnGameMap;

import java.util.PriorityQueue;

/**
 * ��    ��: 2022-01-12
 * �� �� ��: �� �� ��
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
        
        // (0,0) -> (size,size) ������ �ִܰŸ��� ���϶�
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
            len = cur.len; // �̰��� ��ġ������.... len �����������ķ� �ǽð����� �ٲ�⶧����, �ݵ�� ����len���� 1�� ũ�ٴ� ������ ����
            if(cur.y==map.length-1 && cur.x==map[0].length-1) {
                isFind = true;
                break;
            }
            
            // len = cur.len; // return�� �ƴ� break�� �ҰŸ� ���⿡ �θ� �ȵ�
            for(int d = 0; d < 4; d++) {
                int ny = cur.y+dy[d];
                int nx = cur.x+dx[d];
                if(!inRange(ny,nx,map.length,map[0].length) || visited[ny][nx] || map[ny][nx]==0) {
                    // System.out.printf("(%d,%d) -> ������ ����ų� �湮�߰ų� ��\n",ny,nx);
                    continue;
                }
                // System.out.printf("(%d,%d) -> ť�� ����\n",ny,nx);
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
