package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 로고 {

	
	static class square{
		int x1,x2,y1,y2;

		public square(int x1, int y1, int x2, int y2) {
			this.x1 = x1;
			this.x2 = x2;
			this.y1 = y1;
			this.y2 = y2;
		}
		
	}
	
	static square[] map;
	static boolean visited[];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int count = Integer.parseInt(br.readLine());
		int total=0;
		map = new square[count+1];
		visited = new boolean[count+1];
		Queue<Integer> q = new LinkedList<>();
		
		map[0] = new square(0,0,0,0);
		for(int i=1;i<=count;i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			map[i] = new square(x1,y1,x2,y2);
		}
		
		for(int i=0;i<=count;i++) {
			if(visited[i]) continue;
			visited[i] = true;
			
			q.add(i);
			
			while(!q.isEmpty()) {
				int current = q.poll();
				for(int j=0;j<=count;j++) {
					if(j==current || visited[j] || checked(current,j)) continue;
					visited[j] = true;
					q.add(j);
				}
			}
			total++;
		}
		System.out.println(total-1);
		
	}
	private static boolean checked(int current, int next) {
		// TODO Auto-generated method stub
		
		//겹치지않음
		square c = map[current];
		square n = map[next];
		
		   if((c.x1 < n.x1 && n.x2 < c.x2 && c.y1 < n.y1 && n.y2 < c.y2)
	                || (c.x1 > n.x1 && n.x2 > c.x2 && c.y1 > n.y1 && n.y2 > c.y2) 
	                || c.x2 < n.x1 || c.x1 > n.x2 || c.y2 < n.y1 || c.y1 > n.y2 ){
			return false;
		}
		return true;
	}

}
