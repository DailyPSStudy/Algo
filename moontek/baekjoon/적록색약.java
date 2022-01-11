package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 적록색약 {

	static int dx[] = new int[]{ 0 , 0 , -1 , 1};
	static int dy[] = new int[]{ 1 ,-1 ,  0 , 0};
	static char array1[][];
	static char array2[][];
	static boolean visited[][];
	static boolean visited2[][];
	static int N;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count =0;
		int count2 = 0;
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		array1 = new char[N][N];
		array2 = new char[N][N];
		visited = new boolean[N][N];
		visited2 = new boolean[N][N];
		for(int i=0;i<N;i++) {
			String line = br.readLine();
			for(int j=0;j<N;j++) {
				char el = line.charAt(j);
				if(el!='B') {
					array1[i][j] = 'R';
				}
				else {
					array1[i][j] = 'B';
				}
				array2[i][j]=el;
			}
		}

		
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j]) {
					visited[i][j] = true;
					dfs(i,j,array1[i][j]);
					count++;
				}
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visited2[i][j]) {
					visited2[i][j] = true;
					dfs2(i,j,array2[i][j]);
					count2++;
				}
			}
		}
		
		
		
		System.out.println(count2 + " " + count);
	}
	private static void dfs(int r, int c, char v) {
		// TODO Auto-generated method stub
		for(int i=0;i<4;i++) {
			int nx = r+dx[i];
			int ny = c+dy[i];
			
			
			if(nx<0 || nx >=N || ny <0 || ny >=N) {
				continue;
			}
			if(!visited[nx][ny] && array1[nx][ny]==v) {
				visited[nx][ny] = true;
				dfs(nx,ny,v);
			}
		}
	}
	private static void dfs2(int r, int c, char v) {
		// TODO Auto-generated method stub
		for(int i=0;i<4;i++) {
			int nx = r+dx[i];
			int ny = c+dy[i];
			
			if(nx<0 || nx >=N || ny <0 || ny >=N) {
				continue;
			}
			if(!visited2[nx][ny] && array2[nx][ny]==v) {
				
				visited2[nx][ny] = true;
				dfs2(nx,ny,v);
			}
		}
	}
}
