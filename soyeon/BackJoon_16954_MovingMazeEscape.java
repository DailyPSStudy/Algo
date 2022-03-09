package backJoon_16954_MovingMazeEscape;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BackJoon_16954_MovingMazeEscape {
	static boolean DEBUG = false;
	static char[][] map;
	static int[] dy = {0,-1,1,0,0,1,-1,-1,1};
	static int[] dx = {0,0,0,-1,1,1,1,-1,-1};
	static int[] coord = new int[2];
	static Queue<int[]> wall, q;
	
	public static void main(String[] args) throws IOException {
		
		// BFS
		// . 빈칸 , # 벽
		
		// 우측하단의 캐릭터가 좌측상단에 도착할 수 있다면 1, 없으면 0 출력
		
		// 8*8 맵 입력
		map = new char[8][8];
		wall = new LinkedList<>();
		q = new LinkedList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 8; i++) {
			String line = br.readLine();
			map[i] = line.toCharArray();
			for (int j = 0; j < 8; j++) {
				if(map[i][j] == '.') continue;
				wall.add(new int[] {i,j});
			}
		}
		// end of input
		
		// 사람부터 움직이고 그다음 벽 떨어짐
		q.add(new int[] {7,0}); // 좌측하단 (7,0)
		System.out.println(move());
		
	} // end of main

	
	/** 
	 * 사람이 이동한다.
	 *  */
	public static int move() {
		
		while(q.size() != 0) {
			if(DEBUG) System.out.println("satart");
			
			int size = q.size();
			if(DEBUG) System.out.println("size "+size);
			
			while(size > 0) {
				int[] cur = q.poll();
				size--; // #이면 continue 처리 이전에 해줘야 함!!! 
				if(map[cur[0]][cur[1]] == '#') continue;
				
				for (int d = 0; d < 9; d++) {
					int ny = cur[0] + dy[d];
					int nx = cur[1] + dx[d];
					if(!inRange(ny, nx)) continue;
					if(ny==0 && nx==7) return 1;
					if(map[ny][nx] == '.') {
						q.add(new int[] {ny, nx});
					}
				}
				
			} // end of while
			
			// 다 움직여본 후 벽 떨어뜨리기
//			fall();
			fall2();
		} // end of while
		
		return 0;
	}
	
	
    public static void fall2() {
        for (int i = 6; i >= 0; i--) { // 겹처서 처리되지 않게 아래의 벽부터 처리해준다.
            for (int j = 0; j < 8; j++) {
                map[i+1][j] = map[i][j];
            }
        }
        for (int i = 0; i < 8; i++) {
            map[0][i] = '.';
        }
    }

	/**
	 * 벽이 떨어진다.
	 * 이렇게하면 위아래 연달아 벽이 내려올때 겹쳐서 처리된다.
	 * */
	private static void fall() {
		// 벽이 떨어짐
		// 만약 사람이 있는 곳으로 떨어지면 false, 아니면 true
		int size = wall.size();
		while(size > 0) {
			size--;
			int[] cur = wall.poll();
			// 범위 벗어나면 벽 소멸
			if(cur[0] < 7) {
				// 한칸씩 아래로 옮김
				map[cur[0]][cur[1]] = '.';
				cur[0]++;
				map[cur[0]][cur[1]] = '#';
				wall.add(new int[] {cur[0], cur[1]});
			} else { // 맨아래면 없애버리기
				map[cur[0]][cur[1]] = '.';
			}
		} // end of while
		
	}


	private static boolean inRange(int ny, int nx) {
		return ny>=0 && nx>=0 && ny<8 && nx<8;
	}
	
	
} // end of class
