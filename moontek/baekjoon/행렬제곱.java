package NewWeek2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 행렬제곱 {

	static long B;
	static int N;
	static int[][] array;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N= Integer.parseInt(st.nextToken());
		B =Long.parseLong(st.nextToken());
		StringBuilder sb = new StringBuilder();
		
		
		
		array = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				array[i][j] = Integer.parseInt(st.nextToken())%1000;
			}
		}
		

		
		int[][] narray = typedivide(array,B);
		
		

		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				sb.append(narray[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static int[][] typedivide(int[][] now, long mulc) {
		// TODO Auto-generated method stub
		
		if(mulc==1L) return now;
		
		int[][] res = typedivide(now,mulc/2); // 쪼개서 들어가기 3/2 ==> 1 로 혹은 2/2==>1로
		
		//res 의 담긴것은 결국 array^1값
		int[][] mres = mul(res,res);

		if(mulc%2==1L) { // 홀수의 경우 3 => res * res * res 이고 2이면 res * res이다..
		mres = mul(mres,array);	
		}
		
		return mres;
	}

	private static int[][] mul(int[][] res, int[][] res2) {
		// TODO Auto-generated method stub
		int[][] result = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < N; k++) {
					
					result[i][j] += res[i][k] * res2[k][j];
					result[i][j] %= 1000;	// 행렬 원소 연산이 끝나면 MOD로 나머지연산
				}
			}
		}
		return result;
	}

}
