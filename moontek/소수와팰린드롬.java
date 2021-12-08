package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 소수와팰린드롬 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int start = Integer.parseInt(br.readLine());
		
		boolean[] tos = new boolean[1004001]; 
		
		tos[0] = true;
		tos[1] = true;
		for(int i=2;i*i<=1004000;i++) {
			if(!tos[i]) {
			for(int j=i*i;j<=1004000;j=j+i) {
				tos[j] = true;
			}
			}
		}
		
		
		for(int i=start;i<=1004000;i++) {
			if(!tos[i]) {
				String p = Integer.toString(i);
				if(check(p))
				{
					System.out.println(p);
					break;
				}
			}
		}
	}
	
	static boolean check(String p) {
		for(int j=0;j<p.length();j++) {
			int k = p.length()-1-j;
			char left = p.charAt(j);
			char right = p.charAt(k);
			if(k<=j) {
				break;
			}
			else if(left!=right) {
				return false;
			}
		}
		return true;
	}

}
