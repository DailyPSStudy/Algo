import java.util.*;
import java.io.*;

public class 같은수로만들기 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int k = Integer.parseInt(br.readLine());
		
		Stack<Long> s = new Stack<>();
		long answer=0;
		long m = 0;
		for(int i=0;i<k;i++) {
			long cur =  Long.parseLong(br.readLine());
			
			m = Math.max(cur, m);
			if(s.isEmpty()) {
				s.add(cur);
			}
			else {
				if(s.peek()<cur) { // 현재 값이 더크면 이전의 값을 현재값에 맞춰서 초기화 해주고 넣어줌  3 3 3 5이면 5 5 5 5 로바꿔주는과정
					answer += cur - s.pop();
					s.add(cur);
				}
				else if(s.peek()>cur) { //현재값이 더작으면 그 값을 기준으로 다시맞춰주는 과정을 하기위해 스택에넣음
										//결국 나중에는 최소값이 들어가게됨 즉 3 3 3 1 이면 1이들어가고 max가 5면 4번 계산하면 5 5 5 5 가됨
					s.pop();
					s.add(cur);
				}
			}
		}
		
		
		
		while(!s.isEmpty()) {
			long cur = s.pop();
			answer += m-cur;
		}
	
			
		System.out.println(answer);
	}

}
