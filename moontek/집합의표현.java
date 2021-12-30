package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 집합의표현 {

	
	static void make() {
		p = new int[n+1];
		for(int i=1;i<=n;i++) {
			p[i] = i;
		}
	}
	
	static int find(int x) {
		if(p[x]==x) return x;
		return p[x] = find(p[x]);
	}
	
	
	
	static void union(int x,int y) {
		int px = find(x);
		int py = find(y);
		if(px!=py) {
			p[py] = px;
		}
	}
	
	
	
	static int[] p;
	static int n;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		make();
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			if(type==0) {
				union(start,end);
			}
			else {
				if(find(start)==find(end)) {
					sb.append("YES").append("\n");
				}
				else {
					sb.append("NO").append("\n");
				}
			}
		}
		System.out.println(sb);
		
	}

}
