import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;
public class 저울 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] choo = new int[tc];
		for(int i=0;i<tc;i++) {
			int cur = Integer.parseInt(st.nextToken());
			choo[i] = cur;
		}
	}

}
