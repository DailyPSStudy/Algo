package simulation;

import java.io.*;
import java.util.*;

public class 시험감독 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] array = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {

			array[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		
		long result = 0;
		for(int i=0;i<n;i++) {
			int pc = array[i];
			
			//총감독
			pc-= a;
			result++;
			if(pc<=0) continue;
			//서브감독
			
			if(pc%b==0) { //딱떨어질떄
				result+= pc/b;
			}
			else {
				result+= pc/b+1;
			}

		}
					System.out.println(result);
	}

}
