package backJoon_10026_RedGreenColorWeakness;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ��    ��: 2022-01-11
 * �� �� ��: �� �� ��
 * https://www.acmicpc.net/problem/10026
 * */
public class BackJoon_10026_RedGreenColorWeakness {
	static int lengthOfMap;
	static boolean[][] visited;
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,1,-1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// ���ϻ����� '�ƴ�' ����� ���ϻ����� ����� ���� ������ ���� �����϶�
		
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

	/** ���ϻ����� ���� ������ �� ���� */
	private static void getWeekness(int y, int x, char[][] map) {
		
		// R,G �� ���� ������ �ν�
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

	
	/** �Ϲ����� ���� ������ �� ���� */
	private static void getNormal(int y, int x, char[][] map) {
		
		// R,G,B �� ���� ����
		for (int d = 0; d < 4; d++) {
			int ny = y+dy[d];
			int nx = x+dx[d];
			if(inRange(ny,nx) && map[y][x]==map[ny][nx] && !visited[ny][nx]) {
				visited[ny][nx] = true;
				getNormal(ny,nx,map);
			}
		}
	}

	
	/** ����üũ */
	private static boolean inRange(int ny, int nx) {
		return ny>=0 && nx>=0 && ny<lengthOfMap && nx<lengthOfMap;
	}
	
	
} // end of class
