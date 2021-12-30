package backJoon_1922_NetworkConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * ��    ��: 2021-12-29
 * �� �� ��: �� �� ��
 * https://www.acmicpc.net/problem/1922
 * */
public class BackJoon_1922_NetworkConnection {
	static PriorityQueue<Computer> computers = new PriorityQueue<>();
	static int numberOfCom, numberOfLine, minCost;
	static boolean[] visited;
	static int[] com;
	
	static class Computer implements Comparable<Computer> {
		int from;
		int to;
		int cost;
		public Computer(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		@Override
		public int compareTo(Computer o) {
			return this.cost-o.cost;
		}
	} // end of Computer
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// ��ǻ���� �� numberOfCom
		// �����Ҽ��ִ� ���� �� numberOfLine
		// numberOfLine��ŭ�� from,to,cost
		numberOfCom = Integer.parseInt(br.readLine());
		numberOfLine = Integer.parseInt(br.readLine());
		com = new int[numberOfCom+1]; // 1~numberOfCom
		initCom();
		StringTokenizer st;
		for (int i = 0; i < numberOfLine; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			computers.add(new Computer(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		// end of input
		
		// �ϴ� ������ �������� ����
		// visited üũ�ϸ鼭 ����
		visited = new boolean[numberOfCom+1];
		connecting();
		System.out.println(minCost);
	} // end of main

	private static void connecting() {
		// visited true�� �׳� ť���� ���鼭, ť �� �����ɶ����� ����
		while(computers.size() != 0) {
			Computer computer = computers.poll();
			// ��Ʈ��尡 Ʋ���� ��ġ��, ������ ��ġ������
			int aRoot = find(computer.from);
			int bRoot = find(computer.to);
			if(aRoot!=bRoot) {
				union(aRoot,bRoot);
				minCost += computer.cost;
			}
		} // end of while
	} // end of connecting
	
	private static void initCom() {
		for (int i = 0; i < com.length; i++) {
			com[i] = i;
		}
	}
	
	private static int find(int x) {
		if(x == com[x]) return x;
		return find(com[x]);
	}
	
	private static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot!=bRoot) {
			com[bRoot] = aRoot;
		}
	}
} // end of class
