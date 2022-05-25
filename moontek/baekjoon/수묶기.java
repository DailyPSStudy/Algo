import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class 수묶기 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		
		int sum = 0;
		int[] narray = new int[k];
		
		
		
		for(int i=0;i<k;i++) {
			narray[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(narray);
		int aend = 0;
		// 음수 구간은 역정렬 해줘야함 
		int start = k;
		int end = -1;
		for(int i=0;i<k;i++) {
			if(narray[i]<0) {
				end = Math.max(end, i);
				start = Math.min(start, i);
			}
		}
		
		// -5 -4 -3 -2  
		
		if(end!=start && end != -1 && start !=k) { //음수구간이 있는경우
		int count = end-start; // 갯수
		
		while(start<=end) {
			if(start<=end-1) {
				sum += narray[start] * narray[start+1];
				start=start+2;
				continue;
			}
			break;
		}

		// -6 -5                       //  [ -3 1 0 3 ] 
		// 갯수가 홀수이면 셋트로 짝지어서 더해주고  +1 까지 끝지점 넣어주기
		aend = start;
		// 갯수가 짝수이면 먼저 지들끼리 더하고 끝지점 정하기
		}
		
		k--;
		
		while(k>=aend) {
			if(k>=aend+1) {
				int nmul = narray[k] * narray[k-1];
				int nsum = narray[k] + narray[k-1];
				
				if(nmul>=nsum) {
					sum+= nmul;
					k=k-2;
					continue;
				}
			}
			sum += narray[k];
			k--;
		}

		System.out.println(sum);

		
	}

}
