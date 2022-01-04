package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;



public class 연결요소의개수 {

	static int N;
	static boolean[] visited;
	static LinkedList<Integer>[] array;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		array = new LinkedList[N+1];
		for(int i=0;i<=N;i++) {
			array[i] = new LinkedList<>();
		}
		visited = new boolean[N+1];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			array[start].add(end);
			array[end].add(start);
		}
		int count=0;
		for(int i=1;i<=N;i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(i);
				count++;
			}
		}
		System.out.println(count);
		
	}
	private static void dfs(int i) {
		// TODO Auto-generated method stub
		for(int k : array[i]) {
			if(!visited[k]) {
				visited[k] = true;
				dfs(k);
			}
		}
	}

}
