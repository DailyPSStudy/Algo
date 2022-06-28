import java.util.*;
import java.io.*;
public class 데스노트 {

	static int n,m;
	static int[] name;
	static int[][] dp = new int[1000][1002];
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		name = new int[n];
		for(int i=0;i<n;i++) {
			name[i] = Integer.parseInt(br.readLine());
		}
		
		int idx = 1;
		int cnt = name[0] + 1 ;
		for(int i=0;i<dp.length;i++) {
			Arrays.fill(dp[i], -1); 
		}
		
		System.out.println(memo(idx,cnt));
		
		
	}
	private static int memo(int idx, int cnt) {
		// TODO Auto-generated method stub
		if(idx==n) return 0;
		int ans = dp[idx][cnt];
		if(ans != -1) return ans;
		
		int left = m -cnt +1;
		ans = memo(idx+1,name[idx]+1) + (left*left);
		
		if(cnt+name[idx]<=m) {
			ans = Math.min(memo(idx+1,cnt+name[idx]+1),ans);
		}
		dp[idx][cnt]  = ans;
		
		return ans;
	}

}
