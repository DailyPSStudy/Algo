package backJoon_11399_ATM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 일    시: 2022-01-04
 * 작 성 자: 유 소 연
 * https://www.acmicpc.net/problem/11399
 * */
public class BackJoon_11399_ATM {
	static int N;
	static int[] time;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// 각 사람이 돈을 인출하는데 필요한 시간 합의 '최솟값'을 구하라
		// N과 P의 범위가 1000까지라 순열로 절대 구할 수 없다.
		// 고로 time 오름차순 정렬해서 구해야함...ㅠㅠ
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// N : 사람의 수
		N = Integer.parseInt(br.readLine());
		init();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// time
		for (int i = 0; i < N; i++) {
			time[i] = Integer.parseInt(st.nextToken());
		}
		// end of input
		
		Arrays.sort(time);
//		System.out.println(Arrays.toString(time));
		int res = getTime();
		System.out.println(res);
		
	} // end of main
	

	/** order대로 시간을 누적해 더함 */
	private static int getTime() {
		int res = 0;
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += time[i];
			res += sum;
//			System.out.printf("sum: %d, res: %d\n", sum,res);
		}
		return res;
	}
	
	
	/** 객체 초기화 */
	private static void init() {
		time = new int[N];
	}
	
} // end of class
