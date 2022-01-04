package Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
	int end;
	int weight;
	


	public Node(int end, int weight) {
		this.end = end;
		this.weight = weight;
	}



	public int compareTo(Node e) {
		if(this.weight>e.weight) return 1;
		return -1;
	}

}
public class 최소비용구하기 {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N= Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		LinkedList<Node>[] array = new LinkedList[N];
		StringTokenizer st ;
		int[] distance = new int[N];
		boolean[] visited = new boolean[N];
		for(int i=0;i<N;i++) {
			array[i] = new LinkedList<>();
			distance[i] = Integer.MAX_VALUE;
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken())-1;
			int e = Integer.parseInt(st.nextToken())-1;
			int w = Integer.parseInt(st.nextToken());
			array[s].add(new Node(e,w));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken())-1;
		int end = Integer.parseInt(st.nextToken())-1;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		distance[start] = 0;
		pq.add(new Node(start,0));
		
		while(!pq.isEmpty()) {
			Node current = pq.poll();
			if(visited[current.end]) continue;
			visited[current.end] =true;
			for(Node next: array[current.end]) {
				if(distance[next.end]>distance[current.end]+next.weight) {
					distance[next.end] = distance[current.end]+next.weight;
					pq.offer(new Node(next.end,distance[next.end]));
				}
			}
			
		}
		System.out.println(distance[end]);
	}

}
