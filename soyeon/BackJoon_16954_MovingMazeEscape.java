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
		// . ��ĭ , # ��
		
		// �����ϴ��� ĳ���Ͱ� ������ܿ� ������ �� �ִٸ� 1, ������ 0 ���
		
		// 8*8 �� �Է�
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
		
		// ������� �����̰� �״��� �� ������
		q.add(new int[] {7,0}); // �����ϴ� (7,0)
		System.out.println(move());
		
	} // end of main

	
	/** 
	 * ����� �̵��Ѵ�.
	 *  */
	public static int move() {
		
		while(q.size() != 0) {
			if(DEBUG) System.out.println("satart");
			
			int size = q.size();
			if(DEBUG) System.out.println("size "+size);
			
			while(size > 0) {
				int[] cur = q.poll();
				size--; // #�̸� continue ó�� ������ ����� ��!!! 
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
			
			// �� �������� �� �� ����߸���
//			fall();
			fall2();
		} // end of while
		
		return 0;
	}
	
	
    public static void fall2() {
        for (int i = 6; i >= 0; i--) { // ��ó�� ó������ �ʰ� �Ʒ��� ������ ó�����ش�.
            for (int j = 0; j < 8; j++) {
                map[i+1][j] = map[i][j];
            }
        }
        for (int i = 0; i < 8; i++) {
            map[0][i] = '.';
        }
    }

	/**
	 * ���� ��������.
	 * �̷����ϸ� ���Ʒ� ���޾� ���� �����ö� ���ļ� ó���ȴ�.
	 * */
	private static void fall() {
		// ���� ������
		// ���� ����� �ִ� ������ �������� false, �ƴϸ� true
		int size = wall.size();
		while(size > 0) {
			size--;
			int[] cur = wall.poll();
			// ���� ����� �� �Ҹ�
			if(cur[0] < 7) {
				// ��ĭ�� �Ʒ��� �ű�
				map[cur[0]][cur[1]] = '.';
				cur[0]++;
				map[cur[0]][cur[1]] = '#';
				wall.add(new int[] {cur[0], cur[1]});
			} else { // �ǾƷ��� ���ֹ�����
				map[cur[0]][cur[1]] = '.';
			}
		} // end of while
		
	}


	private static boolean inRange(int ny, int nx) {
		return ny>=0 && nx>=0 && ny<8 && nx<8;
	}
	
	
} // end of class
