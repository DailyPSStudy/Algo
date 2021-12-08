import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 일    시: 2021-12-08
 * 작 성 자: 유 소 연
 * */
public class SWEA_5658 {
	static int N, K;
	static String number;
	static Set<Info> set2;
	static Set<String> set;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int TEST_CASE = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TEST_CASE; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			number = br.readLine();
			set = new HashSet<>();
			// N/4번 회전하며 set에 넣는다.
			for (int c = 0; c < N/4; c++) {
				for (int i = 0; i < 4; i++) {
					// i로부터 시작해 N/4개씩 한묶음
					String str = "";
					for (int j = 0; j < N/4; j++) {
						int idx = (N/4)*i+j-c;
						if(idx < 0) {
							idx = N+idx;
						}
						str += number.charAt(idx);
					} // end of for j
//					System.out.println(str);
					set.add(str); // 설마... new Info라 전부 다른 값으로 인식..?
				} // end of for i
			} // end of circle
			
			// 내림차순 정렬하기 위해 set을 list로 변환
			List<Integer> list = new ArrayList<>();
			Iterator<String> iter = set.iterator();
			while(iter.hasNext()) {
				list.add(Integer.parseInt(iter.next(), 16));
			} // end of while
			
			Collections.sort(list, new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o2 - o1;
				}
			});
//			System.out.println(list.toString());
			sb.append("#").append(tc).append(" ").append(list.get(K-1)).append("\n");
		} // end of testCase
		System.out.print(sb);
	} // end of main
} // end of class
