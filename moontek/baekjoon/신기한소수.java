import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 신기한소수 {

	static int[] array;
	static StringBuilder sb;
	public static int N;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N= Integer.parseInt(br.readLine());
		int range = (int) (Math.pow(10, N)-1);
		int start = (int) (Math.pow(10, (N-1)));
		sb = new StringBuilder();
		
		if(N<6) {
			array = new int[range+1];
			array[1] = 1;
			make(range);
			for(int i=start;i<range;i++) {
				if(array[i]==0) {
					if(check(i)) {
						sb.append(i).append("\n");
					}
				}
			}
			
		}
		
		else{
			array = new int[100000]; //4MB 제한이므로 10만까지만쓰자 
			array[1] = 1;
			make(99999);
			for(int i=10000;i<100000;i++) {
				if(array[i]==0) {
					if(check(i)) {
						backt(i,5);
					}
				}
			}
			
		}

		System.out.println(sb);
	}

	public static void backt(int now, int len) {
		if(len==N) {
			sb.append(now).append("\n");
			return;
		}
		for(int i=0;i<10;i++) {
			
			int newnum = now*10+i;
			if(pnum(newnum)) backt(newnum,len+1);
		}
		
	}
	
	
	public static boolean pnum(int cur) {
		
		for(int i=2;i*i<=cur;i++) {
			if(cur%i==0) return false;
		}
		return true;
	}
	
	public static void make(int range) {
		
		//소수이면 0 아니면 1로 표시
		
		for(int i=2;i<=range;i++) {
			if(array[i]==0) { // 소수라면 그수를 제외한 배수를 소수가아님 처리
				for(int j=i+i;j<=range;j=j+i){
					array[j] =1;
				}
			}
		}
	}
	public static boolean check(int num) {

		int a = num;
		while(a>0) {
			
			a=a/10;
			if(array[a]==1) return false;
		}
		
		return true;
	}
}
