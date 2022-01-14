package backJoon_2662_CorporateInvestment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 일    시: 2022-01-14 10:10~10:40
 * 작 성 자: 유 소 연
 * https://www.acmicpc.net/problem/2662
 * 틀림ㅋㅋ 반례가 뭐지
 * */
public class BackJoon_2662_CorporateInvestment {
	static int amount, numberOfCorp;
	static long[][] profit;
	
	public static void main(String[] args) throws IOException {
		
		// 투자금액 amount, 투자가능한 기업 개수 numberOfCorp
		// amount개의 줄에 투자액수와 각기업이 투자가에게 주는 이익
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		amount = Integer.parseInt(st.nextToken());
		numberOfCorp = Integer.parseInt(st.nextToken());
		
		profit = new long[amount+1][numberOfCorp+1];
		for (int y = 1; y <= amount; y++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int x = 0; x < numberOfCorp+1; x++) {
				profit[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 이중반복문으로 ..!
		long max = 0;
		long[] amounts = new long[2]; // A,B에게 투자한 금액
		for (int amt = 0; amt <= amount; amt++) {
			long sum = 0;
			sum = profit[amt][1] + profit[amount-amt][2]; // A기업 기준
			if(max < sum) {
				max = sum;
				amounts[0] = profit[amt][0];
				amounts[1] = profit[amount-amt][0];
			}
			sum = profit[amt][2] + profit[amount-amt][1]; // B기업 기준
			if(max < sum) {
				max = sum;
				amounts[0] = profit[amt][0];
				amounts[1] = profit[amount-amt][0];
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(max).append("\n").append(amounts[0]).append(" ").append(amounts[1]).append("\n");
		System.out.print(sb);
	} // end of main
} // end of class
