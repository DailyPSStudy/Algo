package backJoon_7569_Tomato;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 일    시: 2021-12-24
 * 작 성 자: 유 소 연
 * https://www.acmicpc.net/problem/7569
 * */
public class BackJoon_7569_Tomato {
	static int X, Y, H, min, numberOfBlank, numberOfRipedTomato;
	static int[][][] map;
	static boolean[][][] visited;
	static Queue<int[]> q = new LinkedList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// bfs
		// 3차원배열 토마토 문제
		// 전후좌우 + 상하 6방향 탐색
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 가로,세로,높이
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		// map
		map = new int[Y][X][H];
		visited = new boolean[Y][X][H];
		for (int h = 0; h < H; h++) {
			for (int y = 0; y < Y; y++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int x = 0; x < X; x++) {
					map[y][x][h] = Integer.parseInt(st.nextToken());
					if(map[y][x][h] == 1) {
						numberOfRipedTomato++;
						q.add(new int[] {y,x,h,0});
						visited[y][x][h] = true;
					}else if(map[y][x][h] == -1) {
						numberOfBlank++;
					}
				} // end of x
			} // end of y
		} // end of height
		// end of input
		spread();
		if(isAllRipe()) {
			System.out.println(min);
			return;
		}else {
			System.out.println(-1);
			return;
		}
	} // end of main

	/** 토마토 익히는것을 확산시킨다. */
	private static void spread() {
		int[] dy = {-1,1,0,0};
		int[] dx = {0,0,-1,1};
		
		while(q.size() != 0) {
			int[] cur = q.poll();
			int y = cur[0]; int x = cur[1]; int h = cur[2]; int day = cur[3]; min = day;
			for (int d = 0; d < 6; d++) {
				int ny = y; int nx = x; int nh = h;
				if(d < 4) {
					ny = y+dy[d];
					nx = x+dx[d];
				}
				if(d == 4) nh += 1;
				if(d == 5) nh -= 1;
				
				if(inRange(ny,nx,nh) && !visited[ny][nx][nh] && map[ny][nx][nh] == 0) {
					numberOfRipedTomato++;
					q.add(new int[] {ny,nx,nh,day+1});
					visited[ny][nx][nh] = true;
				}
			} // end of dir
		} // end of while
	} // end of spread

	/** 토마토가 모두 익었는지 검사 */
	private static boolean isAllRipe() {
		// visited = true 이면 익은 토마토
		// all - numberOfBlank == true의 개수  => true
		if (Y*X*H - numberOfBlank == numberOfRipedTomato) {
			return true;
		} else {
			return false;
		}
	} // end of checkTomato
	
	private static boolean inRange(int ny, int nx, int nh) {
		return ny>=0 && nx>=0 && nh>=0 && ny<Y && nx<X && nh<H;
	} // end of inRange
} // end of class
