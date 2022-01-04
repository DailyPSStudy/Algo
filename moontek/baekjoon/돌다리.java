package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 돌다리 {

	static class stone{
		int number;
		int count;
		public stone(int number, int count) {
			this.number = number;
			this.count = count;
		}
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] visited = new int[100001];
		int[] array = new int[]{ A, B , 1, -A, -1, -B};
		visited[N]=0;
		Queue<stone> q = new LinkedList<>();
		q.add(new stone(N,0)); 
		
		
		while(!q.isEmpty()) {
			stone current = q.poll();
			int number = current.number;
			int count = current.count;
			if(current.number==M) {
				System.out.println(count);
				break;
			}
			for(int i=0;i<6;i++) {
				int nnumber = number+array[i];
				if(nnumber<0 || nnumber>100000) {
					continue;
				}
				if(visited[nnumber]==0) {
				q.offer(new stone(nnumber,count+1));
				visited[nnumber] = count+1;
				}
			}
			for(int i=0;i<2;i++) {
				int nnumber = number * array[i];
				if(nnumber<0 || nnumber>100000) {
					continue;
				}
				if(visited[nnumber]==0) {
					q.offer(new stone(nnumber,count+1));
					visited[nnumber] = count+1;
					}
			}
		}
	}
}
