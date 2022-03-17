import java.util.*;
import java.io.*;
public class 돌그룹 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int first = Integer.parseInt(st.nextToken());
		int sec = Integer.parseInt(st.nextToken());
		int thi = Integer.parseInt(st.nextToken());
		
		
		if(first+sec+thi%3==0) {
			
			int[] arr = {first,sec,thi};
			Arrays.sort(arr);
			Queue<int[]> q=new LinkedList<>();
			HashSet<String> set = new HashSet<>();
			
			set.add(""+arr[0]+arr[1]+arr[2]);
			q.offer(arr);
			boolean flag = false;
			int narr[];
			while(!q.isEmpty()) {
				
				int[] cur = q.poll();
				if(cur[0]==cur[1] && cur[1]==cur[2]) {
					flag =true;
					break;
				}
				if(cur[0]!=cur[1]) {
					narr = new int[3];
					narr[0] = cur[0]+ cur[0];
					narr[1] = cur[1] - cur[0];
					narr[2] = cur[2];
					
					
					if(narr[1]>0) {
						Arrays.spliterator(narr);
						String temp = ""+narr[0] + narr[1] + narr[2];
						if(!set.contains(temp)) {
							set.add(temp);
							q.offer(narr);
						}
					}
				}
				if(cur[0]!=cur[2]) {
					narr = new int[3];
					narr[0] = cur[0]+ cur[0];
					narr[2] = cur[2] - cur[0];
					narr[1] = cur[1];
					
					
					if(narr[2]>0) {
						Arrays.spliterator(narr);
						String temp = ""+narr[0] + narr[1] + narr[2];
						if(!set.contains(temp)) {
							set.add(temp);
							q.offer(narr);
						}
					}
				}
			}
			
			if(flag) System.out.println(1);
			else System.out.println(0);
			
			
			
		}
		else {
			System.out.println(0);
		}
	}

}
