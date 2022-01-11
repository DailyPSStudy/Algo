package backJoon_2206_BreakTheWallAndMove;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BackJoon_2206_BreakTheWallAndMove {
	static int Y,X;
	static int min = Integer.MAX_VALUE;
	static int[][] map;
	static boolean[][][] visited;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	
	static class Info implements Comparable<Info> {
		int y;
		int x;
		int distance;
		int destroy;
		public Info(int y, int x, int distance, int destroy) {
			this.y = y;
			this.x = x;
			this.distance = distance;
			this.destroy = destroy;
		}
		@Override
		public int compareTo(Info o1) {
			return this.distance-o1.distance; // 거리기준 오름차순
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// Y X
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		// map
		map = new int[Y][X];
		visited = new boolean[Y][X][2];
		
		for (int y = 0; y < Y; y++) {
			String str = br.readLine();
			for (int x = 0; x < X; x++) {
				map[y][x] = str.charAt(x)-'0';
			}
		}
		// end of input
		
		PriorityQueue<Info> q = new PriorityQueue<>();
		q.add(new Info(0,0,1,0)); //y,x,distance,destory -> 처음위치와 도착위치도 같이 카운트
		
		getShortestDistance(q); // y,x,distance,destory -> 처음위치와 도착위치도 같이 카운트
		
		if(min==Integer.MAX_VALUE) min = -1;
		System.out.println(min);
	} // end of main
	
	
	private static void getShortestDistance(PriorityQueue<Info> q) {
		
		while(q.size()!=0) {
			
			Info cur = q.poll();
			
			if(cur.y==Y-1 && cur.x==X-1) {
//				System.out.println("도착!! "+(cur.distance));
				if(min > cur.distance) {
					min = cur.distance;
				}
				return;
			}
			
			
			for (int d = 0; d < 4; d++) {
				int ny = cur.y+dy[d];
				int nx = cur.x+dx[d];
				// 이렇게하면 visited 둘중하나만 true여도 못지나가게됨.. 둘중하나만 true면 지나갈수있게해줘야지; 
//				if(!inRange(ny,nx) || visited[ny][nx][0] || visited[ny][nx][1]) continue;
				if(!inRange(ny,nx)) continue;
				
				if(map[ny][nx]==0) {
					
					// 부순벽이 없고 다음위치도 부순벽이없을때 방문하지않았따면
					if(cur.destroy==0 && !visited[ny][nx][0]) {
						visited[ny][nx][0] = true;
						q.add(new Info(ny,nx,cur.distance+1,cur.destroy));
					} else if(cur.destroy==1 && !visited[ny][nx][1]) {
						// 부순벽이 있는데 다음위치가 부순벽이있을때 방문한곳이 아니라면
						visited[ny][nx][1] = true;
						q.add(new Info(ny,nx,cur.distance+1,cur.destroy));
					}
					
				}else if(map[ny][nx]==1) {
					
					// 벽을 부수던가
					if(cur.destroy==0 && !visited[ny][nx][1]) {
						visited[ny][nx][1] = true;
						q.add(new Info(ny,nx,cur.distance+1,cur.destroy+1));
					}
					
				} // end of if-else
			} // end of for
			
		} // end of while
		
	}


	private static boolean inRange(int ny, int nx) {
		return ny>=0 && nx>=0 && ny<Y && nx<X;
	}
	
} // end of class
