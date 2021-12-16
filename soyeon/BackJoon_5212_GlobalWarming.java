package backJoon_5212_GlobalWarming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/**
 * ��    ��: 2021-12-17
 * �� �� ��: �� �� ��
 * https://www.acmicpc.net/problem/5212
 * */
public class BackJoon_5212_GlobalWarming {
	static int Y, X;
	
	public static void main(String[] args) throws IOException {
		// 1. map�� ����Ҹ� Ž���ϸ� X�ϰ�� 4���⿡ '.'�� ��ִ��� ī��Ʈ.
		//	  3��,4�� �ִٸ� X�� '.'���� ġȯ
		// 2. ���� 3��,4���� �ƴ϶�� list�� �ش� ��ǥ�� ����
		// 3. ���� ū x,y, �������� x,y�� ���Ͽ� ���� ���� ����
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		char[][] map = new char[Y][X];
		for (int i = 0; i < Y; i++) {
			String str = br.readLine();
			for (int j = 0; j < X; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		// end of input
		
		int[] dy = {-1,1,0,0};
		int[] dx = {0,0,-1,1};
		boolean[][] check = new boolean[Y][X];
		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				if(map[i][j]=='X') {
					int cnt = 0;
					for (int d = 0; d < 4; d++) {
						int ny = i+dy[d];
						int nx = j+dx[d];
						if(!inRange(ny,nx)) {
							cnt++; // ������ ����� ���� ��� �ٴ��̴�!!!!!
						} else if(map[ny][nx]=='.') {
							cnt++;
						}
					} // end of for dir
					if(cnt!=3 && cnt!=4) {
						list.add(new int[] {i,j}); // ����������� ���� ��ġ ����
					} else {
						check[i][j] = true; // ����ɾƾ� �ϴ� �� üũ
					}
				} // end of if
			} // end of for x
		} // end of for y
		// ���� �˸°� ���� �ڸ��� ��� �ΰ���
		// 1. ���μ��� ���پ� ������ 'X'�� �ϳ��� �ִ� ��,�� �˾Ƴ���
		// 2. y,x���� �����ؼ� ����ūy,x ��������y,x �ɷ����� ����
		Collections.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0]; // y���� ��������
			}
		});
		int min_y = list.get(0)[0];
		int max_y = list.get(list.size()-1)[0];
		Collections.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1]; // x���� ��������
			}
		});
		int min_x = list.get(0)[1];
		int max_x = list.get(list.size()-1)[1];
		
		// (min_y,min_x) ~ (max_y,max_x) ���� ���
		StringBuilder sb = new StringBuilder();
		for (int i = min_y; i <= max_y; i++) {
			for (int j = min_x; j <= max_x; j++) {
				if(check[i][j]) {
					sb.append(".");
				} else {
					sb.append(map[i][j]);
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);
	} // end of main

	private static boolean inRange(int ny, int nx) {
		return ny>=0 && nx>=0 && ny<Y && nx<X;
	} // end of inRange
} // end of class
