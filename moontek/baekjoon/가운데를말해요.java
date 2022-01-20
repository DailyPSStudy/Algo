
import java.util.*;
import java.io.*;
public class 가운데를말해요 {

	static class max implements Comparable<max>{
		int x;
		public int compareTo(max o) {
			return o.x-this.x;
		}
		public max(int x) {
			this.x=x;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<max> maxq = new PriorityQueue<>();
		PriorityQueue<Integer> minq = new PriorityQueue<>();
		
		StringBuilder sb = new StringBuilder();

		for(int i=0;i<N;i++) { // max || min 으로 구성  
			int c = Integer.parseInt(br.readLine());

			int maxsize = maxq.size();
			int minsize = minq.size();
			
			if(maxsize==minsize) {
			maxq.add(new max(c));
			}
			else {
				minq.add(c);
			}
			if(i==0) {
				sb.append(maxq.peek().x).append("\n");
				continue;
			}
			if(maxq.peek().x>minq.peek()) {
				int maxn = maxq.poll().x;
				int minn = minq.poll();
				
				maxq.add(new max(minn));
				minq.add(maxn);
			}
			


			sb.append(maxq.peek().x).append("\n");
			
			}
		System.out.println(sb);
		}
	}