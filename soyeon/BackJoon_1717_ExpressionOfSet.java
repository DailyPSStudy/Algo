package backJoon_1717_ExpressionOfSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 일    시: 2021-12-28
 * 작 성 자: 유 소 연
 * https://www.acmicpc.net/problem/1717
 * union find 문제
 * */
public class BackJoon_1717_ExpressionOfSet {
	static int number, numberOfOper;
	static int[] set;
	
	public static void main(String[] args) throws IOException {
		// 어떻게 했더라..ㅋㅋ
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// number, numberOfOper
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		number = Integer.parseInt(st.nextToken());
		numberOfOper = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		
		initSet();
		
		for (int i = 0; i < numberOfOper; i++) {
			// numberOfOper 개수만큼 연산이 주어짐 => 0 a b:합집합, 1 a b:같은집합에 포함돼있는지
			st = new StringTokenizer(br.readLine(), " ");
			int op = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(op==0) {
				// a,b의 집합을 합치기
				union(a,b);
			}else {
				// a,b가 같은집합안에 있는지 확인
				if(findSet(a)==findSet(b)) {
					sb.append("YES").append("\n");
				}else {
					sb.append("NO").append("\n");
				}
			}
		} // end of for numberOfOper
		
		System.out.print(sb);
	} // end of main

	// 0~number까지 자기자신으로 초기화
	private static void initSet() {
		set = new int[number+1];
		for (int i = 0; i <= number; i++) {
			set[i] = i;
		}
	} // end of initSet
	
	// a,b의 집합을 합치기
	private static void union(int a, int b) {
		/** a,b의 우두머리로 연산을 해야한다는 점 잊지말자ㅠㅠㅠ */
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot != bRoot) {
			set[bRoot] = aRoot;
		}
	} // end of union
	
	// a,b의 우두머리 찾기
	private static int findSet(int x) {
		if(x == set[x]) return x;
		return set[x] = findSet(set[x]);
	} // end of find
} // end of class
