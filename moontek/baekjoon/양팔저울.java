package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 양팔저울 {

	static int[] array;
	static int N;
	static int[][] result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		array = new int[N];
		
		for(int i=0;i<N;i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		result = new int[N+1][55001];
		
		dp(0,0);
		int K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int j=0;j<K;j++) {
			if(result[N][Integer.parseInt(st.nextToken())]==1) {
				System.out.print("Y ");
			}
			else {
			System.out.print("N ");
			}
		}
		
	}
	private static void dp(int count, int value) {
		// TODO Auto-generated method stub
		if(count+1==N) {
			return;
		}
		if(result[count][value]!=0) return;
		result[count][value]=1;
		
		dp(count+1,value);
		dp(count+1,value+array[count]);
		dp(count+1,Math.abs(value-array[count]));
		
	}

}
