package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 지구온난화 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[R][C];
		int [][] map2 = new int[R][C];
		
		for(int r=0; r<R; r++) {
			String line = br.readLine();
			for(int c=0; c<C; c++) {
				map[r][c] = line.charAt(c);
			}	
		}
		
		
		int dr[] = {0,0,-1,1};
		int dc[] = {-1,1,0,0};
		
		//after 50 years
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				if(map[r][c] == 'X') {
					for(int d=0; d<4; d++) {
						int nr = r+dr[d];
						int nc = c+dc[d];
						
						
						if(nr>=0 && nc>=0 && nr<R && nc<C) {
							if(map[nr][nc]=='X') {
								map2[r][c] ++;
							}
						}
					}
				}
			}	
		}
		
		int FirstR = 10, FirstC = 10;
		int LastR = 0, LastC = 0;
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				if(map2[r][c] < 2) {
					map[r][c] = '.';
				}else {
					if(LastR < r) {
						LastR = r;
					}
					if(LastC < c) {
						LastC = c;
					}
					if(FirstR > r) {
						FirstR = r;
					}
					if(FirstC > c) {
						FirstC = c;
					}
				}
			}	
		}
		for(int r=FirstR; r<=LastR; r++) {
			for(int c= FirstC; c<= LastC; c++) {
				System.out.print(map[r][c]);
			}	
			System.out.println();
		}
		
	}

}
