package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 트리와쿼리 {


	static ArrayList<Integer>[] tree,list;
	static int size[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		size = new int[N+1];
		tree = new ArrayList[N+1];
		list = new ArrayList[N+1];
		
		for(int i=0;i<=N;i++) {
			tree[i] = new ArrayList<>();
			list[i] = new ArrayList<>();
		}
				
		for(int i=1;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list[start].add(end);
			list[end].add(start);
		}
		
		createTree(R,-1);
		countsubtree(R);
		for(int i=0;i<Q;i++) {
			int query = Integer.parseInt(br.readLine());
			sb.append(size[query]).append("\n");
		}
		System.out.println(sb);
	}
	private static void countsubtree(int current) {
		// TODO Auto-generated method stub
		size[current]=1;
		
		for(int k : tree[current]) {
			
			countsubtree(k);
			size[current]+= size[k];
		}
	}
	public static void createTree(int current, int Parent) {
		// TODO Auto-generated method stub
		for(int k: list[current]) {
			if(k!=Parent) {
				tree[current].add(k);
				createTree(k,current);
			}
		}
	}

}
