package backJoon_10830_MatrixSquared;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 일    시: 2022-02-04
 * 작 성 자: 유 소 연
 * https://www.acmicpc.net/problem/10830
 * */
public class BackJoon_10830_MatrixSquared {
	static long[][] A;
	
	public static void main(String[] args) throws IOException {
		
		// 짝수승 : 1/2
		// 홀수승 : 짝수(홀-1)의 거듭제곱에 기존의 A를 한번 더 곱해줌
		
		// N, B
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		// A (N개의 줄을 거쳐)
		A = new long[N][N]; // N*N 행렬
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
				sb.append(ans[i][j]%1000).append(" "); // 출력할 때에도 %1000을 해줘야 안틀림. 왜지... 곱할때 해서 넣는데;
			}
			sb.append("\n");
		}
		System.out.print(sb);
	} // end of main
	
	
	/** 
	 * 재귀함수
	 * b = 1 이 될 때까지 b/2 하며 재귀를 반복
	 *  */
	private static long[][] half(long b, long[][] matrix) {
		if(b == 1) {
			return matrix;
		}
		
		// b가 1이 될때까지 절반으로 쪼갬
		long[][] res = half(b/2, matrix);
		res = squared(res, res);
		if(b%2 == 1) {
			res = squared(res, A);
		}
		
		return res;
	}

	
	/**  
	 * res 제곱 반환
	 * */
	private static long[][] squared(long[][] matrix, long[][] matrix2) {
		long[][] res = new long[matrix.length][matrix.length];
		
		for (int r = 0; r < matrix.length; r++) { // row
			for (int y = 0; y < matrix.length; y++) { // x와곱하는 세로 target
				for (int x = 0; x < matrix.length; x++) { // row 하나하나의 원소
					res[r][y] += matrix[r][x] * matrix2[x][y];
					res[r][y] %= 1000;
				}
			}
		}
		
		return res;
	}
	
} // end of class
