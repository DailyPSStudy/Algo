package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 코딩테스트세트 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<T;i++) {
			
			st = new StringTokenizer(br.readLine());
			
			int[] carray = new int[N];
			int[] darray = new int[N-1];
			
			for(int j=0;j<(2*N)-1;j++) {
				
				if(j%2==0) {
					carray[j/2] = Integer.parseInt(st.nextToken());
				}
				else {
					darray[(j/2)] = Integer.parseInt(st.nextToken());
					}
				}

			int maxset =0;
			while(true) {

				int minset = Integer.MAX_VALUE;
				int minindex = -1;
				
				
				//index가마짐작인경우는 다음 조커가없음
				if(minindex == N-1) {
					if(darray[minindex-1]==0) {
						maxset = minset;
						break;
					}
					else {
						carray[minindex]++;
						darray[minindex-1]--;
					}
				}
				else if(minindex == 0) {
					if(darray[minindex]==0) {
						maxset = minset;
						break;
					}
					else {
						carray[minindex]++;
						darray[minindex]--;
					}
				}
				else {
					int maxminindex = -1;
					if(darray[minindex]>darray[minindex-1]) {
						maxminindex  = minindex;
					}
					else {
						maxminindex = minindex-1;
					}
					
					
					if(darray[maxminindex]==0) {
						maxset = minset;
						break;
					}
					else {
						carray[minindex]++;
						darray[maxminindex]--;
					}
					
				}

				
			}
			

			
			sb.append(maxset).append("\n");
		}

		System.out.println(sb);
	}

}
