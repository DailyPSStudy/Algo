import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 오등큰수 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		int[] array = new int[1000001];
		int[] answer = new int[1000001];
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Integer> s = new Stack<>();
		Stack<Integer> ns = new Stack<>();
		for(int i=0;i<k;i++) {
			int n = Integer.parseInt(st.nextToken());
			array[n]++;
			s.add(n);
		}
		int index = k;
		while(!s.isEmpty()) {
			k--;
			int cur = s.pop();
			if(ns.isEmpty()) {
				answer[k] =-1;
				ns.add(cur);
				continue;
			}
			boolean flag = false;
			while(!ns.isEmpty()) {

				int ncur = ns.peek();
				if(array[ncur]<=array[cur]) {
					ns.pop();
					continue;
				}
				// 여기까지오면 맘에드는애가있음
				flag = true;
				answer[k] = ncur;
				break;
			}
			ns.add(cur);
			// 원하는게하나도없어!!
			if(!flag) {
				answer[k] = -1;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<index;i++) {
			sb.append(answer[i]).append(" ");
		}
		System.out.println(sb);
	}

}
