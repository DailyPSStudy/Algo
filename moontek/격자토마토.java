package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class tomato{
	int x;
	int y;
	int h;
	
	public tomato(int x, int y, int h) {
		super();
		this.x = x;
		this.y = y;
		this.h = h;
	}

}


public class 격자토마토 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
				
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		Queue<tomato> q = new LinkedList<>();
		int[][][] array = new int[N][M][H];
		int [][][] day = new int[N][M][H];
		for(int h = 0;h<H;h++) {		
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<M;j++) {
					int now = Integer.parseInt(st.nextToken());
					array[i][j][h] = now;
					if(now==1) {
						q.add(new tomato(i,j,h));
					}
				}
			}
		}

		int[] dx = new int[] {0,  0,  0,  0,  1, -1};
		int[] dy = new int[] {0,  0,  1, -1,  0,  0};
		int[] dh = new int[] {1, -1,  0,  0,  0,  0};
		while(!q.isEmpty()) {
			tomato current = q.poll();
			int cx = current.x;
			int cy = current.y;
			int ch = current.h;
			
			for(int i=0;i<6;i++) {
				int nx = cx+dx[i];
				int ny = cy+dy[i];
				int nh = ch+dh[i];

				if(nx>=0 && nx<N && ny >= 0 && ny<M && nh >=0 && nh <H) {
					
				
					if(array[nx][ny][nh]==0) {
						q.offer(new tomato(nx,ny,nh));
						array[nx][ny][nh] = array[cx][cy][ch]+1;
					}
				}
			}
			
		}
		

		System.out.println(endcheck(array,N,M,H));
	
		
	}
	public static int endcheck(int[][][] array,int N,int M, int H) {
		int answer = 0;
		for(int h = 0;h<H;h++) {		
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					int now = array[i][j][h];
					if(now==0) {
						return -1;
					}
					else {
						answer = Math.max(answer, now);
					}
				}
			}
		}
		return answer-1;

	}
	
}
