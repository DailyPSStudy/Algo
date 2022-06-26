
import java.util.*;
import java.io.*;

public class 일학년 {

	static long[][] array;
	static int[] cur;
	public static void main(String[] args)  throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		
		array = new long[k+1][21];
		cur = new int[k+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		for(int i=0;i<k;i++) {
			cur[i+1] = Integer.parseInt(st.nextToken());
		}
		
		array[1][cur[1]] = 1;
		
		for(int i=2;i<k;i++) {
			for(int j=0;j<=20;j++) {
				if(array[i-1][j]!=0) {
					if(j+cur[i]<=20) {
						array[i][j+cur[i]]+= array[i-1][j];
					}
					if(j-cur[i]>=0) {
						array[i][j-cur[i]]+= array[i-1][j];
					}
					
				}
			}
		}
		System.out.println(array[k-1][cur[k]]);
	}

}
