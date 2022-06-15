import java.util.*;
import java.io.*;

public class 영역구하기 {

	static boolean[][] map;
	static boolean[][] visited;
	static int[] dx = new int[] {0,0,1,-1};
	static int[] dy = new int[] {1,-1,0,0};
	static int sum=0;
	static int N;
	static int M;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		 M = Integer.parseInt(st.nextToken());
		 N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		map = new boolean[N][M];
		visited = new boolean[N][M];
		ArrayList<Integer> answer = new ArrayList<>();
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			int ex = Integer.parseInt(st.nextToken());
			int ey = Integer.parseInt(st.nextToken());
			
			for(int j=sx;j<ex;j++) {
				for(int k=sy;k<ey;k++) {
					map[j][k]=true;
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(!map[i][j] && !visited[i][j]) {
					sum=0;
					dfs(i,j);
					answer.add(sum);
				}
			}
		}
		
		Collections.sort(answer);
		System.out.println(answer.size());
		for(int l : answer) System.out.print(l+" ");
		
		
	}
	
	static void dfs(int x, int y) {
		
		visited[x][y]=true;
		sum++;
		
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			// 유효성검사
			if(nx<0 || nx >= N || ny <0 || ny >= M) continue;
			if(!visited[nx][ny]&& !map[nx][ny]) {
				dfs(nx,ny);
			}
		}
		
	}

}
