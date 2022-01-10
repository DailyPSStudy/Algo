package backJoon_10026_RedGreenColorWeakness;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 일    시: 2022-01-11
 * 작 성 자: 유 소 연
 * https://www.acmicpc.net/problem/10026
 * */
public class BackJoon_10026_RedGreenColorWeakness {
	static int lengthOfMap;
	static boolean[][] visited;
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,1,-1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// 적록색약이 '아닌' 사람과 적록색약인 사람이 보는 구역의 수를 리턴하라
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// lengthOfMap
		lengthOfMap = Integer.parseInt(br.readLine());
		// map
		char[][] map = new char[lengthOfMap][lengthOfMap];
		for (int y = 0; y < lengthOfMap; y++) {
			String str = br.readLine();
			for (int x = 0; x < lengthOfMap; x++) {
				map[y][x] = str.charAt(x);
			}
		}
		// end of input

		visited = new boolean[lengthOfMap][lengthOfMap];
		int normal = 0;
		for (int y = 0; y < lengthOfMap; y++) {
			for (int x = 0; x < lengthOfMap; x++) {
				if(visited[y][x]) continue;
				visited[y][x] = true;
				normal++;
				getNormal(y,x,map);
			}
		}
		
		visited = new boolean[lengthOfMap][lengthOfMap];
		int weekness = 0;
		for (int y = 0; y < lengthOfMap; y++) {
			for (int x = 0; x < lengthOfMap; x++) {
				if(visited[y][x]) continue;
				visited[y][x] = true;
				weekness++;
//				System.out.printf("(%d,%d) -> %d\n",y,x, weekness);
				getWeekness(y,x,map);
			}
		}
		
		System.out.print(normal+" "+weekness);
		
	} // end of main

	/** 적록색약이 보는 구역의 수 리턴 */
	private static void getWeekness(int y, int x, char[][] map) {
		
		// R,G 면 같은 색으로 인식
		for (int d = 0; d < 4; d++) {
			int ny = y+dy[d];
			int nx = x+dx[d];
			if(inRange(ny,nx) && !visited[ny][nx]) {
				if(map[y][x]==map[ny][nx] || (map[y][x]=='R'&&map[ny][nx]=='G') || (map[y][x]=='G'&&map[ny][nx]=='R')) {
//					System.out.printf("(%d,%d)\n", ny,nx);
					visited[ny][nx] = true;
					getWeekness(ny,nx,map);
				}
			}
		}
	}

	
	/** 일반인이 보는 구역의 수 리턴 */
	private static void getNormal(int y, int x, char[][] map) {
		
		// R,G,B 다 따로 구분
		for (int d = 0; d < 4; d++) {
			int ny = y+dy[d];
			int nx = x+dx[d];
			if(inRange(ny,nx) && map[y][x]==map[ny][nx] && !visited[ny][nx]) {
				visited[ny][nx] = true;
				getNormal(ny,nx,map);
			}
		}
	}

	
	/** 범위체크 */
	private static boolean inRange(int ny, int nx) {
		return ny>=0 && nx>=0 && ny<lengthOfMap && nx<lengthOfMap;
	}
	
	
} // end of class
