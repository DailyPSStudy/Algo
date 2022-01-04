package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 안녕 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] L = new int[count];
		int[] J = new int[count];
		
		for(int i=0;i<count;i++) {
			L[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<count;i++) {
			J[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] K = new int[101];
		
		
		
		for(int i=0;i<count;i++) {
			for(int w=99;w>=L[i];w--) {
				K[w] = Math.max(K[w], J[i]+K[w-L[i]]);
			}
		}


		System.out.println(K[99]);
		
	}
}
