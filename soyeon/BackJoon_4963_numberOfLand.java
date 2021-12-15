package backJoon_4963_numberOfLand;
import java.util.*;
/*
 * 
 * 백준알고리즘
 * 4963. 섬의 개수
 * https://www.acmicpc.net/problem/4963
 * 2021-12-15
 * 
 * */
public class BackJoon_4963_numberOfLand {
	static Scanner sc = new Scanner(System.in);
	static int x, y;
	static int[][] map;
	static boolean[][] visited;
	static List<Integer> numberOfLand = new ArrayList<>();
	
	public static void main(String[] args) {
		int answer;
		while(true) {
			input();
			
			if(x == 0 && y == 0) break;
			
			answer = 0;
			
			for(int i = 0; i < y; i++) {
				for(int j = 0; j < x; j++) {
					if(visited[i][j] == false && map[i][j] == 1) {
						visited[i][j] = true;
						dfs(i, j);
						answer++; 
					}
				}
			}
			numberOfLand.add(answer);
		}
		
		for(int n = 0; n < numberOfLand.size(); n++) {
			System.out.println(numberOfLand.get(n));
		}
	}


	private static void dfs(int i, int j) {
		int[] dy = {-1, 1, 0, 0, -1, 1, 1, -1};
		int[] dx = {0, 0, 1, -1, 1, -1, 1, -1};
		
		int ny = 0;
		int nx = 0;

		for(int d = 0; d < 8; d++) {
			ny = dy[d] + i;
			nx = dx[d] + j;
			
			if(isArrange(ny,nx) && visited[ny][nx] == false && map[ny][nx] == 1) {
				visited[ny][nx] = true;
				dfs(ny,nx);
			}
		}
	}


	private static boolean isArrange(int ny, int nx) {
		return ny >= 0 && nx >= 0 && ny < y && nx < x;
	}


	private static void input() {
		
		x = sc.nextInt();
		y = sc.nextInt();
		
		//System.out.println("x: "+x+" y: "+y);
		
		map = new int[y][x];
		visited = new boolean[y][x];
		for(int i = 0; i < y; i++) {
			for(int j = 0; j < x; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		/*
		for(int i = 0; i < y; i++) {
			for(int j = 0; j < x; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}*/
		
	}
}
