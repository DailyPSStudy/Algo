package backJoon_1717_ExpressionOfSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ��    ��: 2021-12-28
 * �� �� ��: �� �� ��
 * https://www.acmicpc.net/problem/1717
 * union find ����
 * */
public class BackJoon_1717_ExpressionOfSet {
	static int number, numberOfOper;
	static int[] set;
	
	public static void main(String[] args) throws IOException {
		// ��� �ߴ���..����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// number, numberOfOper
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		number = Integer.parseInt(st.nextToken());
		numberOfOper = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		
		initSet();
		
		for (int i = 0; i < numberOfOper; i++) {
			// numberOfOper ������ŭ ������ �־��� => 0 a b:������, 1 a b:�������տ� ���Ե��ִ���
			st = new StringTokenizer(br.readLine(), " ");
			int op = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(op==0) {
				// a,b�� ������ ��ġ��
				union(a,b);
			}else {
				// a,b�� �������վȿ� �ִ��� Ȯ��
				if(findSet(a)==findSet(b)) {
					sb.append("YES").append("\n");
				}else {
					sb.append("NO").append("\n");
				}
			}
		} // end of for numberOfOper
		
		System.out.print(sb);
	} // end of main

	// 0~number���� �ڱ��ڽ����� �ʱ�ȭ
	private static void initSet() {
		set = new int[number+1];
		for (int i = 0; i <= number; i++) {
			set[i] = i;
		}
	} // end of initSet
	
	// a,b�� ������ ��ġ��
	private static void union(int a, int b) {
		/** a,b�� ��θӸ��� ������ �ؾ��Ѵٴ� �� �������ڤФФ� */
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot != bRoot) {
			set[bRoot] = aRoot;
		}
	} // end of union
	
	// a,b�� ��θӸ� ã��
	private static int findSet(int x) {
		if(x == set[x]) return x;
		return set[x] = findSet(set[x]);
	} // end of find
} // end of class
