import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Edge1 implements Comparable<Edge1> {
	int start;
	int end;
	int weight;
	
	public Edge1(int start,int end, int weight) {
		this.start = start;
		this.end= end;
		this.weight= weight;
	}
	public int compareTo(Edge1 o) {
		if(this.weight<o.weight) return 1;
		else return -1;
	}
}

public class 중량제한 {

	static int px[];
	static int rank[];
	static int N;
	static void make() {
		px  = new int[N+1];
		rank = new int[N+1];
		for(int i=1;i<=N;i++) {
			px[i] = i;
		}
	}
	static int findp(int index) {
		if(px[index]==index) return index;
		else {
			return px[index] = findp(px[index]);
		}
	}
	static void union(int a, int b) {
		int pa = findp(a);
		int pb = findp(b);
		
		if(pa != pb) {
			if(rank[pa]< rank[pb]) {
				px[pa] = pb;
			}
			else {
				px[pb] = pa;
				if(rank[pa]==rank[pb]) rank[pa]++;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N= Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Edge1[] Edgelist = new Edge1[M];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight= Integer.parseInt(st.nextToken());
			
			Edgelist[i] = new Edge1(start,end,weight);
		}
		
		
		st = new StringTokenizer(br.readLine());
		
		int reals = Integer.parseInt(st.nextToken());
		int reale = Integer.parseInt(st.nextToken());
		
		Arrays.sort(Edgelist);
		make();
		
		int count=0;
		int sum=0;
		for(Edge1 c : Edgelist) {

			
			union(c.start,c.end);
			if((findp(reals)==findp(reale))) {
				System.out.println(c.weight);
				break;
			}
		}
	}
}
