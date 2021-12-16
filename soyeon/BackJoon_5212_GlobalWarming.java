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
 * 일    시: 2021-12-17
 * 작 성 자: 유 소 연
 * https://www.acmicpc.net/problem/5212
 * */
public class BackJoon_5212_GlobalWarming {
	static int Y, X;
	
	public static void main(String[] args) throws IOException {
		// 1. map의 모든요소를 탐색하며 X일경우 4방향에 '.'이 몇개있는지 카운트.
		//	  3개,4개 있다면 X를 '.'으로 치환
		// 2. 만약 3개,4개가 아니라면 list에 해당 좌표를 저장
		// 3. 가장 큰 x,y, 가장작은 x,y를 구하여 지도 범위 추측
		
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
							cnt++; // 지도를 벗어나는 곳은 모두 바다이다!!!!!
						} else if(map[ny][nx]=='.') {
							cnt++;
						}
					} // end of for dir
					if(cnt!=3 && cnt!=4) {
						list.add(new int[] {i,j}); // 가라앉지않은 섬의 위치 저장
					} else {
						check[i][j] = true; // 가라앉아야 하는 섬 체크
					}
				} // end of if
			} // end of for x
		} // end of for y
		// 섬에 알맞게 맵을 자르는 방법 두가지
		// 1. 가로세로 한줄씩 읽으며 'X'가 하나라도 있는 행,열 알아내기
		// 2. y,x기준 정렬해서 가장큰y,x 가장작은y,x 걸러내서 추측
		Collections.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0]; // y기준 오름차순
			}
		});
		int min_y = list.get(0)[0];
		int max_y = list.get(list.size()-1)[0];
		Collections.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1]; // x기준 오름차순
			}
		});
		int min_x = list.get(0)[1];
		int max_x = list.get(list.size()-1)[1];
		
		// (min_y,min_x) ~ (max_y,max_x) 까지 출력
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
