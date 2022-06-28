import java.util.*;
import java.io.*;
public class 쉬운계단수2 {
	
	static int n;
	final static long mod = 1000000000;
	static long[][] dp;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		dp = new long[n+1][10];
		
		for(int i=1;i<10;i++) { // 한자리수는 무조건 계단수임
			dp[1][i] = 1;
		}
		
		for(int i=2;i<=n;i++) {
			for(int j=0;j<10;j++) {
				
				//case 0 -> 10
				if(j==0) {
					dp[i][0] = dp[i-1][1] %  mod;
				}
				//case 9 -> 89
				else if(j==9) {
					dp[i][9] = dp[i-1][8]% mod;
				}
				// case 1~8
				else {
					dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1])% mod;
								
				}
			}
		}
		
		
		long answer = 0;
		for(int i=0;i<10;i++) { // 한자리수는 무조건 계단수임
			answer += dp[n][i];
		}
		System.out.println(answer %  mod);
		
	}

}
