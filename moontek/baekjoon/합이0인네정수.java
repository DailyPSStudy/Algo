import java.io.*;
import java.util.*;
public class 합이0인네정수 {
	public static long[] cds;
	public static void main(String[] args)  throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int k = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		long answer = 0;
		long[] A= new long[k];
		long[] B= new long[k];
		long[] C= new long[k];
		long[] D= new long[k];
		
		long[] abs = new long[k*k];
		cds = new long[k*k];
		for(int i=0;i<k;i++) {
			st = new StringTokenizer(br.readLine());
			
			A[i] = Long.parseLong(st.nextToken());
			B[i] = Long.parseLong(st.nextToken());
			C[i] = Long.parseLong(st.nextToken());
			D[i] = Long.parseLong(st.nextToken());
			
		}

		int index=0;
		for(int i=0;i<k;i++) {
			for(int j=0;j<k;j++) {
				long absum = A[i]+B[j];
				long cdsum = C[i]+D[j];
				
				abs[index] = absum;
				cds[index] = cdsum;
				index++;
			}
		}

		Arrays.sort(abs);
		Arrays.sort(cds);
		
		
		for(long cur : abs) {
			long start = stpoint(-cur);
			long end = edpoint(-cur);
			
			answer += (end-start) ;
		}
		
		System.out.println(answer);
		
	}
	
	public static long stpoint(long sum) { //합이 0보다 작은수중에 가장큰인덱스
		long start =0;
		long end = cds.length;
		
		while(start<end) {
			long mid = (start+end)/2;
			long cursum = cds[(int) mid];
			
			
			if(cursum<sum) { // 
				start = mid+1;
			}
			else {
				end = mid;
			}
			
		}

		return end;
	}
	public static long edpoint(long sum) {
		long start =0;
		long end = cds.length;

		while(start<end) {
			long mid = (start+end)/2;
			long cursum = cds[(int) mid];
			
			
			if(cursum<=sum) { // 
				start = mid+1;
			}
			else {
				end = mid;
			}
			
		}
		return end;
	}

}
