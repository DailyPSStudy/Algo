package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽부수고이동하기 {
	static class Point{
		int x;
		int y;
		boolean status;
		int count;
		public Point(int x, int y, boolean status, int count) {
			this.x=x;
			this.y=y;
			this.status=status;
			this.count= count;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] dx = new int[] { 0, 0, 1,-1};
		int[] dy = new int[] { 1,-1, 0, 0};
		int[][] array = new int[N][M];
		boolean[][][] visited = new boolean[N][M][2];
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<M;j++) {
				array[i][j] = str.charAt(j)-'0';
			}
		}
		visited[0][0][0]= true;
		visited[0][0][1] = true;
		Queue<Point> q = new LinkedList<>();
		int answer = Integer.MAX_VALUE;
		q.add(new Point(0,0,true,1));
		while(!q.isEmpty()) {
			Point current = q.poll();
			int cx = current.x;
			int cy = current.y;
			boolean cs = current.status;
			int cc = current.count;
			if(cx==N-1 && cy == M-1) {
				answer = Math.min(answer, cc);
				break;
			}
			
			for(int i=0;i<4;i++) {
				int nx = cx+dx[i];
				int ny = cy+dy[i];
				
				if(nx<0 || nx>= N || ny <0 || ny >=M)  //범위초과
				{
					continue;
				}
				
				if(array[nx][ny]==1 && cs) //벽만낫을때
				{
					visited[nx][ny][1] = true;
					q.add(new Point(nx,ny,false,cc+1)); 
				}
				if(array[nx][ny]==0) { // 벽안만낫을때
					int nstatus = 0;
					if(!cs) nstatus++;
					if(!visited[nx][ny][nstatus]) {
						visited[nx][ny][nstatus] = true;
						q.add(new Point(nx,ny,cs,cc+1));
					}
					
				}
			}
			
			
		}
		
		if(answer == Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		else {
		System.out.println(answer);
		}
	}
}
