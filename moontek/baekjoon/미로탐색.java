import java.util.*;
import java.io.*;

public class 미로탐색 {
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = new int[] {0,0,1,-1};
	static int[] dy = new int[] {1,-1,0,0};
	static int sum=0;
	static int N;
	static int M;
	static class move{
		int x;
		int y;
		int count;
		
		public move(int x, int y, int count) {
			this.x=x;
			this.y=y;
			this.count= count;
		}
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		 N = Integer.parseInt(st.nextToken());
		 M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		for(int i=0;i<N;i++) {
			String line = br.readLine();
			
			for(int j=0;j<M;j++) {
				map[i][j] = line.charAt(j)-'0';
			}
		}
		int answer = bfs();
		System.out.println(answer);

	}
	static int bfs() {
		Queue<move> q = new LinkedList<>();
		q.add(new move(0,0,1));
		visited[0][0]= true;
		while(!q.isEmpty()) {
			move cur = q.poll();
			if(cur.x==N-1 && cur.y==M-1) {
				return cur.count;
			}
			
			for(int i=0;i<4;i++) {
				int nx = cur.x+dx[i];
				int ny = cur.y+dy[i];
				int nc = cur.count+1;
				if(nx<0 || nx >=N || ny<0 || ny>=M) continue;
				if(!visited[nx][ny] && map[nx][ny]==1) {
					visited[nx][ny]= true;
					q.add(new move(nx,ny,nc));

				}
			}
		}
		return -1;
	}

}
