import java.io.*;
import java.util.*;
public class 용액 {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long[] k = new long[tc];
		
		for(int i=0;i<tc;i++) {
			k[i] = Long.parseLong(st.nextToken());
		}

		// 어차피 오름차순으로 주어진다고하네요
		// Arrays.sort(k);
		String answer ="";

		int start = 0;
		int end = tc-1;
		long mid = k[start]+k[end];
		long diff = Long.MAX_VALUE;
		answer = k[start] + " " + k[end];
		while(start<end) {
			mid = k[start]+k[end];
			if(mid==0) {
				answer = k[start] + " " + k[end];
				break;
			}
			
			//값 최신화
			if(Math.abs(mid)<Math.abs(diff)) {
				answer = k[start] + " " + k[end];
				diff = mid;
			}
			
			if(mid>0) {
				//mid가 0보다 커  양수값이니까 음수전에 끊기 
				end = end-1;
			}
			else {
				//mid가 0보다 커  양수값이니까 음수전에 끊기 
				start = start+1;
			}
		}
		
		System.out.println(answer);
	}

}
