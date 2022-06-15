import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;
import java.io.*;

public class 두수의합 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int c = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] a = new int[c];
		for(int i=0;i<c;i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		int limit = Integer.parseInt(br.readLine());
		Arrays.sort(a);
		
		int left=0;
		int right=c-1;
		int answer= 0;
		while(left<right) { // 양쪽에서 당겨오는 투포인터가 서로 만나기전까지
			int sum = a[left] +a[right];
			if(limit==sum) { //정답
				answer++;
				left++;
			}
			else if(limit<sum) { // 값이 더커서 오른쪽 한칸 당겨오기
				right--;
			}
			else { //값이 작아서  왼쪽에서 한칸 다가가기
				left++;
			}
		}
		System.out.println(answer);
	}

}
