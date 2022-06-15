import java.io.*;
import java.util.*;


class animal implements Comparable<animal>{
	int x;
	int y;
	
	public animal(int x,int y) {
		this.x= x;
		this.y= y;
	}
	
	public int compareTo(animal o) {
		if(this.x==o.x) {
			return this.y-o.y;
		}
		else {
			return this.x-o.x;
		}
	}
}

public class 사냥꾼 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		
		
		int[] shooter = new int[M];
		
		for(int i=0;i<M;i++) {
			shooter[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(shooter);
		ArrayList<animal> alist = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int x =Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			alist.add(new animal(x,y));
			
		}
		
		Collections.sort(alist);
		
		int sum = 0;
		
		for(animal cur: alist) {
			
			int start = 0;
			int end = M;
			int mid = 0;
			boolean flag = false;
			while(start<=end) {
				
				mid = (start+end)/2;
				if(mid>=M) {
					break;
				}
				int l = Math.abs(shooter[mid]-cur.x)+cur.y;
				
				if(l<=L) { //동물잡은경우
					flag= true;
					break;
				}
				else { //못잡은경우  case 나눠주기
					// 동물의 위치가 지금 중간값보다 오른쪽에있으면
					if(cur.x > shooter[mid]) {
						start = mid+1;// 
					}
					else {
						end = mid-1;
					}
				}
			}
			if(flag) {
				sum++;
			}
		}
		
		System.out.println(sum);
		

			
			
		}


}
