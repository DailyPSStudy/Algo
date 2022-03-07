import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
 
public class Main {
 
    static int N;
    static char[][] map;
    static PriorityQueue<Node> q = new PriorityQueue<>();
    static int sx,sy,ex,ey;
    static boolean[][][] visited;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int[] d1 = {3,2,1,0};
    static int[] d2 = {2,3,0,1};
    
    static int min;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[N][N][4];
        
        int idx = 0;
        for (int i = 0; i < N; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                map[i][j] = temp[j];
                if(temp[j] == '#') {
                    if(idx == 0) {
                        sx = i;
                        sy = j;
                    }
                    else {
                        ex = i;
                        ey = j;
                    }
                    idx++;
                }
            }
        }
        
        for (int i = 0; i < 4; i++) {
            q.add(new Node(sx, sy, i, 0));
        }
        
        while(!q.isEmpty()) {
            
            Node cur = q.poll();
            
            int x = cur.x;
            int y = cur.y;
            int d = cur.d;
            int c = cur.c;
            
            if(visited[x][y][d]) continue;
            
            visited[x][y][d] = true;
            
            if(cur.x == ex && cur.y == ey ) {
                min = cur.c;
                break;
            }
            
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            if(!isRange(nx, ny) || map[nx][ny] == '*')
                continue;
 
            if(map[nx][ny] == '!') {
                q.add(new Node(nx, ny, d1[d], c+1));
                q.add(new Node(nx, ny, d2[d], c+1));
            }
            q.add(new Node(nx, ny, d, c));
        }
        System.out.println(min);
    }
    
    static boolean isRange(int x, int y) {
        if(x < 0 || x >= N || y < 0 || y >= N) return false;
        return true;
    }
}
 
class Node implements Comparable<Node> {
    int x;
    int y;
    int d;
    int c;
    
    Node ( int x, int y , int d, int c) {
        this.x = x;
        this.y = y;
        this.d = d;
        this.c = c;
    }
    
    @Override
    public int compareTo(Node o) {
        return this.c - o.c;
    }
}