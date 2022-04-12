
import java.io.*;
import java.util.*;
public class 두동전 {

	static class board{
		int fx;
		int fy;
		int sx;
		int sy;
		int count;
		public board(int fx, int fy, int sx, int sy, int count) {
			this.fx = fx;
			this.fy = fy;
			this.sx = sx;
			this.sy = sy;
			this.count=count;
		}
		
		
	}
	static int array[][];
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[][][][] visited = new boolean[N][M][N][M];
		LinkedList<int[]> l = new LinkedList<>();
		Queue<board> q = new LinkedList<>();
		array = new int[N][M];
		for(int i=0;i<N;i++) {
			String line = br.readLine();
			for(int j=0;j<M;j++) {
				char cur = line.charAt(j);
				if(cur=='#') array[i][j]=1;
				if(cur=='o') {
					int[] a = new int[2];
					a[0] = i;
					a[1] = j;
					l.add(a);
				}
			}
		}
		board a = new board(l.get(0)[0],l.get(0)[1],l.get(1)[0],l.get(1)[1],0);
		q.add(a);
		
		int[] dx = new int[] {0,0,1,-1};
		int[] dy = new int[] {1,-1,0,0};
		int answer = 10;
		Loop:
		while(!q.isEmpty()) {
			board cur = q.poll();
			visited[cur.fx][cur.fy][cur.sx][cur.sy]=true;
			if(cur.count >10) {
				break;
			}
			
			for(int i=0;i<4;i++) {
				int nfx = cur.fx+dx[i];
				int nfy = cur.fy+dy[i];
				int nsx = cur.sx+dx[i];
				int nsy = cur.sy+dy[i];
				
				//둘다 떨어지는경우
				if((nfx<0 || nfy<0 ||nfx>=N|| nfy>=M) && (nsx<0 || nsy<0 ||nsx>=N|| nsy>=M)   ) {
					continue;
				}
				// 첫번째코인이 나가면서 두번째 코인은 그대로인경우 
				else if((nfx<0 || nfy<0 ||nfx>=N|| nfy>=M) || (nsx<0 || nsy<0 ||nsx>=N|| nsy>=M)   ) {
					answer = cur.count+1;
					break Loop;
				}
				
				//첫번째돌 이동할 구역이 벽으로 막혀있는경우
				if(array[nfx][nfy]==1) {
					nfx = cur.fx;
					nfy = cur.fy;
				}
				if(array[nsx][nsy]==1) {
					nsx = cur.sx;
					nsy = cur.sy;
				}
				
				if(visited[nfx][nfy][nsx][nsy]) continue;
				//돌이 겹치는경우
				q.add(new board(nfx,nfy,nsx,nsy,cur.count+1));
				
			}
			
			
		}
		
		if(answer>=11) System.out.println(-1);
		else System.out.println(answer);
	}

}
