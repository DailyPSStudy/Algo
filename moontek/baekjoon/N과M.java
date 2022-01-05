package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M {

	static int M,N;
	static boolean visited[];
	static int numbers[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N  = Integer.parseInt(st.nextToken());
		M  = Integer.parseInt(st.nextToken());
		visited = new boolean[N+1];
		numbers = new int[M];
		start(0);
		System.out.println(sb);
	}
	private static void start(int c) {
		// TODO Auto-generated method stub

		if(c==M) {
			for(int k=0;k<M;k++) {
				sb.append(numbers[k] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int k=1;k<=N;k++) {
			if(!visited[k]) {
				visited[k] = true;
				numbers[c] = k;
				start(c+1);
				visited[k] = false;
			}
		}
	}

}
