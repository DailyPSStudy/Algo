package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A를B로정답 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String parent = br.readLine();
		String child = br.readLine();
		

		int[] arr1 = new int[26];
		int[] arr2 = new int[26];
		
		int size = child.length();
		int cnt = 0;
		
		for(int i=0;i<size;i++) {
			arr1[parent.charAt(i)-'A']++;
			arr2[child.charAt(i)-'A']++;
		}
		boolean flag=false;
		for(int i=0;i<26;i++) {
			if(arr1[i] != arr2[i]) {
				flag =true;
				break;
			}
		}
		
		if(flag) {
			System.out.println(-1);
		}
		else {
			
			for(int i=size-1; i>=0;i--) {
				if(parent.charAt(i)==child.charAt(size-1-cnt)) {
					cnt++;
				}
			}
			
			System.out.println(size-cnt);
		}
	}

}
