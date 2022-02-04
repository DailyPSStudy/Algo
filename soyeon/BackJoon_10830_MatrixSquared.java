package backJoon_10830_MatrixSquared;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ��    ��: 2022-02-04
 * �� �� ��: �� �� ��
 * https://www.acmicpc.net/problem/10830
 * */
public class BackJoon_10830_MatrixSquared {
	static long[][] A;
	
	public static void main(String[] args) throws IOException {
		
		// ¦���� : 1/2
		// Ȧ���� : ¦��(Ȧ-1)�� �ŵ������� ������ A�� �ѹ� �� ������
		
		// N, B
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		// A (N���� ���� ����)
		A = new long[N][N]; // N*N ���
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				A[i][j] = Long.parseLong(st.nextToken());
			}
		}
		
		long[][] ans = half(B, A);
		// %1000
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(ans[i][j]%1000).append(" "); // ����� ������ %1000�� ����� ��Ʋ��. ����... ���Ҷ� �ؼ� �ִµ�;
			}
			sb.append("\n");
		}
		System.out.print(sb);
	} // end of main
	
	
	/** 
	 * ����Լ�
	 * b = 1 �� �� ������ b/2 �ϸ� ��͸� �ݺ�
	 *  */
	private static long[][] half(long b, long[][] matrix) {
		if(b == 1) {
			return matrix;
		}
		
		// b�� 1�� �ɶ����� �������� �ɰ�
		long[][] res = half(b/2, matrix);
		res = squared(res, res);
		if(b%2 == 1) {
			res = squared(res, A);
		}
		
		return res;
	}

	
	/**  
	 * res ���� ��ȯ
	 * */
	private static long[][] squared(long[][] matrix, long[][] matrix2) {
		long[][] res = new long[matrix.length][matrix.length];
		
		for (int r = 0; r < matrix.length; r++) { // row
			for (int y = 0; y < matrix.length; y++) { // x�Ͱ��ϴ� ���� target
				for (int x = 0; x < matrix.length; x++) { // row �ϳ��ϳ��� ����
					res[r][y] += matrix[r][x] * matrix2[x][y];
					res[r][y] %= 1000;
				}
			}
		}
		
		return res;
	}
	
} // end of class
