package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class nqueen {

	static int board[];
	static int N;
	static int count;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N =Integer.parseInt(br.readLine());
		board = new int[N+1];
		chess(1);
		System.out.println(count);
	}
	private static void chess(int i) {
		// TODO Auto-generated method stub
		
		if(!check(i-1)) {
			return;
		}
		if(i>N) { //배치가 다끝나고넘어온거
			count++;
			return;
		}
		// 이전까지의 배치가 유효한지 확인

		
		for(int j=1;j<=N;j++) {
			board[i] = j; // 배치
			chess(i+1);
		}
		
	}
	private static boolean check(int now) {
		// TODO Auto-generated method stub
		for(int prev=1;prev<now;prev++) {
			
			if(board[prev]==board[now]) {
				return false;
			}
			int minusrow = Math.abs(now-prev);
			int minuscol = Math.abs(board[now]-board[prev]);
			if(minusrow==minuscol) {
				return false;
			}
		}
			
		return true;
	}

}
