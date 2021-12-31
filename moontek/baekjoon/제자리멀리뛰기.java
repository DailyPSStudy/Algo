package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 제자리멀리뛰기 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int d = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] array = new int[n+2];
		for(int i=1;i<=n;i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		array[n+1] = d;
		Arrays.sort(array);
		int low = 0; int high = d;
		int mid;
		int finalans = 0;
		while(low<=high) {
			mid = (low+high)/2;
			int gapct=0;
			int nown = 0;
			for(int i=1;i<=n+1;i++) {
				if(array[i]-array[nown]<mid) gapct++;	
				else {
				nown = i;
			}
			}
		
			if(gapct>m) { 
				high = mid-1;
			
			}
			else {
			low = mid+1; 	
			finalans = mid;
			}
			
		}
		
		System.out.println(finalans);
	}
}
