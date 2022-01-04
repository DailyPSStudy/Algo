package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class z {

	static int N,r,c;
	static int number = -1;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N  = Integer.parseInt(st.nextToken());
		r  = Integer.parseInt(st.nextToken());
		c  = Integer.parseInt(st.nextToken());
		int limit = (int) Math.pow(2, N);


		int res = fill(0,0,limit);
		System.out.println(res);
		
	}
	private static int fill(int nr, int nc, int size) {
		// TODO Auto-generated method stub
	if(size==1) {
		return 0;
	}
	else {
		int nsize = size/2;
		if(r<nr +nsize && c < nc+nsize) {
			return fill(nr,nc,nsize);
		}
		else if(r<nr+nsize && c< nc+size) //2사분면
		{
			return fill(nr,nc+nsize,nsize)+ (int)Math.pow(nsize, 2);
		}
		else if(r<nr+size && c< nc+nsize) //3사분면
		{
			return fill(nr+nsize,nc,nsize)+ (int)Math.pow(nsize, 2)*2;
		}
		else //2사분면
		{
			return fill(nr+nsize,nc+nsize,nsize)+ (int)Math.pow(nsize, 2)*3;
		}
	}
	
	}

}
