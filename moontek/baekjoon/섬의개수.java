package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 섬의개수 {

	static class island {
		int h;
		int w;
		public island(int h, int w) {
			this.h = h;
			this.w = w;
		}
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int[] dh = new int[] {1,-1, 0, 0,-1,-1, 1, 1};
		int[] dw = new int[] {0, 0, 1,-1,-1, 1,-1, 1};
 		while (true) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			if(w==0 && h==0) {
				break;
			}
			int[][] array = new int[h][w];
			boolean[][] visited= new boolean[h][w];
			for(int i=0;i<h;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<w;j++) {
					array[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			Queue<island> q = new LinkedList<>();
			int count=0;
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					if(!visited[i][j] && array[i][j]==1) {
						visited[i][j] = true;
						q.add(new island(i,j));
						
						while(!q.isEmpty()) {
							island current = q.poll();
							for(int u=0;u<8;u++) {
								int nw = current.w+dw[u];
								int nh = current.h+dh[u];
								
								if(nw>=0 && nw<w && nh>=0 && nh<h) {
									if(!visited[nh][nw] && array[nh][nw]==1) {
										visited[nh][nw] = true;
										q.add(new island(nh,nw));
									}
								}
								
							}
						}
						
						count++;
					}
				}
			}
			
			
			sb.append(count).append("\n");
		}
		System.out.println(sb);
	}

}
