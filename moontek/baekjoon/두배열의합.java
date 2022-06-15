import java.util.*;
import java.io.*;

class oror{
	oror h;
}

public class 두배열의합 {

	static int T;
	static ArrayList<Long> mlist;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] n = new int[N];
		for(int i=0;i<N;i++) {
			n[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		int[] m = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			m[i] = Integer.parseInt(st.nextToken());
		}
		
		ArrayList<Long> nlist = new ArrayList<>();
		mlist = new ArrayList<>();
		
		//부분합
		for(int i=0;i<N;i++) {
			long cur = n[i];
			nlist.add(cur);
			for(int j=i+1;j<N;j++) { 
				cur += n[j];
				nlist.add(cur);
			}
			
		}
		for(int i=0;i<M;i++) {
			long cur = m[i];
			mlist.add(cur);
			for(int j=i+1;j<M;j++) {
				cur += m[j];
				mlist.add(cur);
			}
			
		}
		
		Collections.sort(nlist);
		Collections.sort(mlist);
		
		
		// n 기준으로 이분탐색
		long sum=0;
		for(long k : nlist) {
			long start=-1;
			long end =0;
			
			end = upper(k);
			start = lower(k);
			sum += end-start;
		}
		System.out.println(sum);
	}
	
	
	public static long upper(long k) {
		long start = 0;
		long end = mlist.size();
		while(start<end) {
			long mid = (start+end) /2;
			long cur = mlist.get((int) mid);
			if(k+cur<=T) {
				start = mid+1;
			}
			else {
				end = mid;
			}
		}
		return start;
	}
	public static long lower(long k) {
		
		long start = 0;
		long end = mlist.size();
		while(start<end) {
			long mid = (start+end) /2;
			long cur = mlist.get((int) mid);
			if(k+cur<T) {                            
				start = mid+1;
			}
			else {
				end = mid;
			}
		}
		return start;
	}

}
