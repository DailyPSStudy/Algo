import java.util.*;
import java.io.*;
public class 경비원 {

	static class map {
		int d;
		int p;
		public map(int d, int p) {
			this.d = d;
			this.p = p;
		}
		
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int c = Integer.parseInt(br.readLine());
		map[] a = new map[c];
		for(int i=0;i<c;i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			a[i] = new map(d,p);
			
		}
		st = new StringTokenizer(br.readLine());
		int nd = Integer.parseInt(st.nextToken());
		int np = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<c;i++) {
			map cur = a[i];
			
			if(cur.d+nd%2==0) { //서로 마주보고있거나 같은 디렉션에있는경우
				
			}
			else { // 옆사이드에 있는경우 
				
			}
			
		}
		
	}

}
