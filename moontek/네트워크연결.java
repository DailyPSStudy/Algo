package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
class Edge implements Comparable<Edge>{
	int start;
	int end;
	int weight;
	public Edge(int start, int end, int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		if(this.weight>o.weight) return 1;
		else {
			return -1;
		}
	}
}

public class 네트워크연결 {

	static int[] p;
	static int N;
	static int M;
	static void make() {
		p =  new int[N];
		for(int i=0;i<N;i++) {
			p[i] = i;
		}
	}
	
	static int find(int x) {
		if(p[x]==x) return x;
		return p[x] = find(p[x]);
	}
	static boolean union(int x, int y) {
		int sx = find(x);
		int sy = find(y);
		if(sx==sy) return false;
		p[sy] = sx;
		return true;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N= Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		StringTokenizer st;
		PriorityQueue<Edge> q = new PriorityQueue<>();
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			int weight= Integer.parseInt(st.nextToken());
			q.add(new Edge(start,end,weight));
		}
		make();
		int sum=0;
		int v = 0;
		while(!q.isEmpty()) {
			Edge c = q.poll();
			boolean flag = union(c.start,c.end);
			if(flag) {
				sum+= c.weight;
				v++;
			}
			if(v>= N-1) {
				break;
			}
		}
		System.out.println(sum);
	}

}
