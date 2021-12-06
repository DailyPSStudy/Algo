import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA2382 {

	static class micro {
		int x,y,count,dir,hour,presentcount;

		public micro(int x, int y, int count, int dir, int hour, int presentcount) {
			this.x = x;
			this.y = y;
			this.count = count;
			this.dir = dir;
			this.hour = hour;
			this.presentcount = presentcount;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb =new StringBuilder();
		StringTokenizer st;
		
		for(int i=1;i<=tc;i++) {
			
			st = new StringTokenizer(br.readLine());
			//step0 초기셋팅
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[] dx = new int[] { -1, 1, 0, 0 };
			int[] dy = new int[] {  0, 0,-1, 1 };
			micro[][][] visited = new micro[N][N][M+1]; //방문확인용 x,y, hour 
			//step1 q에 넣기
			for(int j=0;j<K;j++) {
				st = new StringTokenizer(br.readLine());
				int cx = Integer.parseInt(st.nextToken());
				int cy = Integer.parseInt(st.nextToken());
				int cc = Integer.parseInt(st.nextToken());
				int cd = Integer.parseInt(st.nextToken());
				
				visited[cx][cy][0] = new micro(cx,cy,cc,cd,0,cc);
			}
			
			// step2 시뮬
			
			for(int a=0;a<M;a++) {
				
				for(int q=0;q<N;q++) {
					for(int w=0;w<N;w++) {
						if(visited[q][w][a]!=null) {
							micro current = visited[q][w][a];
							int nx = current.x;
							int ny = current.y;
							int ncount = current.count;
							int ndir = current.dir;
							int nhour = current.hour+1;
							int npresentcount = current.presentcount;
							if(ncount!=npresentcount) {
								npresentcount=ncount;
							}
							
							
							if(current.dir==1) { //상이동
								if(current.x==1) { // 죽는구간
									ncount = ncount/2;
									ndir = 2;
								}
								nx = nx-1;
							}
							else if(current.dir==2) { // 하이동
								if(current.x==N-2) { // 죽는구간
									ncount = ncount/2;
									ndir = 1;
								}
								nx = nx+1;
							}
							else if(current.dir==3) { // 좌 이동
								if(current.y==1) { // 죽는구간
									ncount = ncount/2;
									ndir = 4;
								}
								ny = ny-1;
							}
							else { // 우 이동
								if(current.y==N-2) { // 죽는구간
									ncount = ncount/2;
									ndir = 3;
								}
								ny = ny+1;
							}
							
							if(visited[nx][ny][nhour]!=null) {
								micro tempmicro = visited[nx][ny][nhour];
								if(tempmicro.presentcount > npresentcount) { //기존값이 더커서 합쳐짐 당하는경우
									ndir = tempmicro.dir;
									npresentcount = tempmicro.presentcount;
								}
								ncount = tempmicro.count+ncount; // 미생물 합치기 
							}
							micro nmicro = new micro(nx,ny,ncount,ndir,nhour,npresentcount);
							visited[nx][ny][nhour] = nmicro;
						}
					}
				}
				
			}

			int total=0;
			for(int a=0;a<N;a++) {
				for(int b=0;b<N;b++) {
					if(visited[a][b][M]!=null)
					total += visited[a][b][M].count;
				}
			}
			sb.append("#").append(i).append(" ").append(total).append("\n");
		}
		System.out.println(sb);
	}

}
