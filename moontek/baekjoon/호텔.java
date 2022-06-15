import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.*;
public class 호텔 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[] result;
		int[] weight = new int[N];
		int[] value = new int[N];
		if(C<=100) {
			result = new int[101];
		}
		else {
			result = new int[C];
		}
		for(int i=0;i<N;i++) {
		st = new StringTokenizer(br.readLine());
		weight[i] = Integer.parseInt(st.nextToken());
		value[i] = Integer.parseInt(st.nextToken());
		
		
		
		}

		
		for(int i=0;i<N;i++) {
			System.out.println("turn : " + i );
			for(int j=value[i];j<=C;j=j++) {

				// step1 배수의 값과 min값 비교 한번해주기  3 6 9 12 인데   4이면 올림해서 6으로 비교하는?
				
				// step2 4이면  1+3 이렇게 비교해버리기 
				
				result[j] = Math.min(result[j],  (weight[i]*(j/value[i])));
				
			}
			
			for(int j=1;j<=C;j++) {
				System.out.print(result[j]+ " ");
			}
			
			
			
		}
		
	}

}
