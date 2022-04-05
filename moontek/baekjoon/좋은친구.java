import java.util.*;
import java.io.*;

public class 좋은친구 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
	
		Queue<Integer>[] qlist = new LinkedList[21];
		
		long answer = 0;
		for(int i=0;i<21;i++) {
			qlist[i] = new LinkedList<Integer>();
		}
		for(int i=0;i<N;i++) {
			String line = br.readLine();
			int sl = line.length();
			if(qlist[sl].isEmpty()) {
				qlist[sl].add(i);
				continue;
			}

			while(!qlist[sl].isEmpty()) {
				if(i-qlist[sl].peek()<=M) {
					// 첫번째 값이 된다면 아래있는 뒷번호는 다가능하다 그래서더해줌
					answer += qlist[sl].size();
					break;
				}
				qlist[sl].poll();
			}
			qlist[sl].add(i);
		}
	System.out.println(answer);
	}

}
