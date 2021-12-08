import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA5658 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb =new StringBuilder();
		StringTokenizer st;
		
		for(int i=1;i<=tc;i++) {
			st = new StringTokenizer(br.readLine());
			
			
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken())-1;
			int slice = N/4;
			char array[] = new char[N];			
			HashSet<Integer> set = new HashSet<Integer>();
			String line = br.readLine();
			
			//step0 . slice만큼 반복
			for(int k=0;k<slice;k++) {
			//step1 . 배열에 넣기 (첫번째 만)
			if(k==0) 
			{
				for(int j=0;j<N;j++) 
				{
					array[j] = line.charAt(j);
				}
			}
			//step2.  array에 있는값으로  pq에 넣기
			for(int j=0;j<4;j++) {
				String ele ="";
				for(int o=0;o<slice;o++) {
					ele = ele + array[o+j*slice];
				}
				set.add(Integer.parseInt(ele,16));
			}
			
			
			//step4  한칸씩 move
			char temp = array[N-1];
			
			for(int j=N-1;j>0;j--) {
				array[j] = array[j-1];
			}
			array[0] = temp;

			}

			List<Integer>result = new ArrayList<Integer>(set);
			Collections.sort(result);
			
			int turn = result.size()-K-1;
			sb.append("#").append(i).append(" ").append(result.get(turn)).append("\n");
			
		}
		System.out.println(sb);
	}

}
