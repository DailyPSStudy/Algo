package programmers_86052_LightPathCycle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Programmers_86052_LightPathCycle {
	static char[][] map;
    static boolean[][][] visited;
    static List<Integer> paths;
    // 우하좌상
    static int[] dy = {0,1,0,-1};
    static int[] dx = {1,0,-1,0};
    
    public int[] solution(String[] grid) {
       
        init(grid);
        
        // dfs로 0,0에서 4방향으로 시작
        for(int y = 0; y < map.length; y++) {
            for(int x = 0; x < map[0].length; x++) {
                for(int d = 0; d < 4; d++) {
                    if(visited[y][x][d]) continue;
                    // System.out.println("탐색시작");
                    paths.add(shootLight(y,x,d)); // y,x,d,len
                }
            }
        }
        
        int[] ans = new int[paths.size()];
        for(int i = 0; i < paths.size(); i++) {
            ans[i] = paths.get(i);
        }
        Arrays.sort(ans);
        
        return ans;
    } // end of solution
    
    
    /** (y,x)에서 d방향으로 빛을 쏨 */
    public int shootLight(int y, int x, int d) {
        int len = 0;
         while(true) {
	         if(visited[y][x][d]) break;
	         visited[y][x][d] = true;
	         
	         int nextDir = getDir(map[y][x], d);
	         int ny = y+dy[nextDir];
	         int nx = x+dx[nextDir];
	         if(!inRange(ny,nx)) {
	             int[] opposide = getOpposide(y,x,nextDir);
	             ny = opposide[0];
	             nx = opposide[1];
	         }
	         y = ny;
	         x = nx;
	         d = nextDir;
	         len++;
	         
	     } // end of while
        
        return len;
    }
    
    
    /** 범위에서 벗어날 시, 해당방향 반대끝방향의 좌표 리턴 */
    public int[] getOpposide(int y, int x, int nextDir) {
        int[] res = new int[2];
        res[0] = y; res[1] = x;
        // 좌우방향일 시 x를 map.length()-1
        // 상하방향일 시 y를 map.length()-1
        // 우하좌상
        if(nextDir==0) {
            // 우 : x를 0으로
            res[1] = 0;
        }else if(nextDir==2) {
            // 좌 : x를 len-1으로
            res[1] = map[0].length-1;
        }else if(nextDir==1) {
            // 하 : y를 0으로
            res[0] = 0;
        }else {
            // 상 : y를 len-1으로
            res[0] = map.length-1;
        }
        
        return res;        
    }
    
    
    /** 다음으로 나아갈 방향을 알아냄 */
    public int getDir(int target, int d) {
        
        if(target == 'S') return d;
        else if(target == 'L') {
            // 우하좌상 -> 상우하좌
            if(d-1<0) return 3;
            else return d-1;
        } else {
            // 우하좌상 -> 하좌상우
            return (d+1)%4;
        }
        
    }
    
    
    /** grid -> map */
    public void init(String[] grid) {
        map = new char[grid.length][grid[0].length()];
        visited = new boolean[grid.length][grid[0].length()][4];
        paths = new ArrayList<>();
        
        for(int y = 0; y < grid.length; y++) {
            for(int x = 0; x < grid[y].length(); x++) {
                map[y][x] = grid[y].charAt(x);
            }
        }
        
    }
    
    
    /** 범위체크 */
    public boolean inRange(int ny, int nx) {
        return ny>=0 && nx>=0 && ny<map.length && nx<map[0].length;
    }
    
}
