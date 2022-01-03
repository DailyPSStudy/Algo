package backJoon_11399_ATM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * ��    ��: 2022-01-04
 * �� �� ��: �� �� ��
 * https://www.acmicpc.net/problem/11399
 * */
public class BackJoon_11399_ATM {
	static int N;
	static int[] time;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// �� ����� ���� �����ϴµ� �ʿ��� �ð� ���� '�ּڰ�'�� ���϶�
		// N�� P�� ������ 1000������ ������ ���� ���� �� ����.
		// ��� time �������� �����ؼ� ���ؾ���...�Ф�
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// N : ����� ��
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
	

	/** order��� �ð��� ������ ���� */
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
	
	
	/** ��ü �ʱ�ȭ */
	private static void init() {
		time = new int[N];
	}
	
} // end of class
