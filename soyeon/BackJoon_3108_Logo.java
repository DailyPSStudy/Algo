package backJoon_3108_Logo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * ��    ��: 2021-12-12
 * �� �� ��: �� �� ��
 * https://www.acmicpc.net/problem/3108
 * */
public class BackJoon_3108_Logo {
	static int N;
	static Info[] map;
	static boolean[] visited;
	static Queue<Integer> q = new LinkedList<>();
	static int cnt;
	
	static class Info{
		int y1,x1,y2,x2;
		public Info(int y1, int x1, int y2,int x2) {
			this.y1 = y1;
			this.x1 = x1;
			this.y2 = y2;
			this.x2 = x2;
		}
	} // end of Info
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// ���簢���� �׸��µ� �ʿ��� 'PU' ��ɾ��� �ּڰ��� ���϶�
		// ��, "���� ����" PU ��ɾ��� �ּ� ������ ���ϸ� ��
		// => ������ ���� �簢������ ����
		// 1. �� ���簢�� �ȿ� ������ �����Ǿ� ���� ���� ���
		// 2. �����¿�� ������ �������ִ� ���
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new Info[N+1];
		visited = new boolean[N+1];
		map[0] = new Info(0,0,0,0); // 0,0�������� ����
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			map[i] = new Info(y1,x1,y2,x2);
		}
		
		for (int i = 0; i <= N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			q.add(i);
			while(q.size()!=0) {
				int cur = q.poll();
				for (int j = 0; j <= N; j++) {
					// ���� ���簢���̰ų�, �����ϴ� �κ��� ���� �����̰ų�, �̹� �湮������ ������ �ǳʶڴ�
					if(cur == j || !check(cur, j) || visited[j]) {
						continue;
					}
					visited[j] = true;
					q.add(j);
				} // end of for j
			} // end of while
			cnt++;
		} // end of for i
		System.out.println(cnt-1);
	} // end of main

	private static boolean check(int cur, int next) {
		Info c = map[cur];
		Info n = map[next];
		if(
			(c.x1<n.x1 && n.x2<c.x2 && c.y1<n.y1 && n.y2<c.y2) || // cur�� next�� �����ϴ� ���
			(c.x1>n.x1 && n.x2>c.x2 && c.y1>n.y1 && n.y2>c.y2) || // next�� cur�� �����ϴ� ���
			(c.x2<n.x1 || c.x1>n.x2 || c.y2<n.y1 || c.y1>n.y2) // �ƿ� ���� �������� �ʴ°��
		) {
			return false;
		}
		return true;
	}
} // end of class
