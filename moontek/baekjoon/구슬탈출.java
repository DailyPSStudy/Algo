package simulation;

import java.io.*;
import java.util.*;


public class 구슬탈출 {

	static char array[][];
	static int turn[];
	static int tcount=0;
	static int min;
	static int N;
	static int M;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		 N = Integer.parseInt(st.nextToken());
		 M = Integer.parseInt(st.nextToken());
		array = new char[N][M];
		turn = new int[10];
		min=11;
		for(int i=0;i<N;i++) {
			String line = br.readLine();
			for(int j=0;j<M;j++) {
				array[i][j] = line.charAt(j);
			}
		}


		dfs(0);
		
		if(min==11) min=-1;
		System.out.println(min);

		/*
		turn = new int[2];
		turn[0] = 0;
		turn[1] = 3;
		
		System.out.println(check());
		*/
	}
	
	
	public static void printa(char[][] ccarray) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(ccarray[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void dfs(int count) {
		if(count==turn.length) {
			int mx = check();
			if(mx<min) {
				min = mx;

			}
			return;
		}
		if(count==0) {
		for(int i=0;i<4;i++) {
			turn[count]=i;
			dfs(count+1);
			}
		}
		else {
			for(int i=0;i<4;i++) {
				if(turn[count-1]==i) continue;
				turn[count]=i;
				dfs(count+1);
			}
		}
	}

	public static int check() {
		char[][] barray = new char[N][M];
		  for(int i=0; i<N; i++){
	            System.arraycopy(array[i], 0, barray[i], 0, M);
	        }
		  
		  
		int rx = 0,ry=0,bx=0,by=0,ox=0,oy=0;
		// step1 R과B의 xy좌표 가져와야됨 그래서 먼저 움직일 순서를 구해야함!
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(array[i][j]=='R') {
					rx=i;
					ry=j;
				}
				else if(array[i][j]=='B') {
					bx=i;
					by=j;
				}
				else if(array[i][j]=='O') {
					ox=i;
					ox=j;
				}
			}
		}
		
		for(int i=0;i<min-1;i++) {

			int type = turn[i];

			
			boolean rend =false; 
			boolean bend =false;
			
			
			
			if(type==0) { //아래로 땅기기
				//어떤 값이 먼저인지 고민해줘야함 가장 아래에있는거
				
				if(rx>bx) {// r이 더 밑에있기때문에 r먼저 움직일경우
					
					int rb = -1 ; // r이 막히는 아래블럭  index
					for(int j=rx+1;j<N;j++) { // 검사해주기
						if(barray[j][ry]=='.') { // 비어있어서 움직일수있는경우
						rb=j;
						continue;
						}
						else if(barray[j][ry]=='O') { //그대로 정답인경우
							rend=true;
						}
						break;
					}
					
					if(rend) barray[rx][ry]='.';
					
					if(rb!=-1 && !rend) {
						barray[rx][ry] = '.';
						barray[rb][ry] = 'R';
						rx=rb;
					}
					
					int bb = -1;
					for(int j=bx+1;j<N;j++) { // 검사해주기
						if(barray[j][by]=='.') { // 비어있어서 움직일수있는경우
						bb=j;
						continue;
						}
						else if(barray[j][by]=='O') { //그대로 정답인경우
							bend=true;
						}
						break;
					}
					if(rend==true && bend==false) return i+1;
					if(bb!=-1 && !bend) {
						barray[bx][by] = '.';
						barray[bb][by] = 'B';
						bx=bb;
					}
				}
				else {
					
					int rb = -1 ; // r이 막히는 아래블럭  index
					int bb = -1;
					for(int j=bx+1;j<N;j++) { // 검사해주기
						if(barray[j][by]=='.') { // 비어있어서 움직일수있는경우
						bb=j;
						continue;
						}
						else if(barray[j][by]=='O') { //그대로 정답인경우
							bend=true;
						}
						break;
					}
					if(bend) barray[bx][by]='.';
					if(bb!=-1 && !bend) {
						barray[bx][by] = '.';
						barray[bb][by] = 'B';
						bx=bb;
					}

					for(int j=rx+1;j<N;j++) { // 검사해주기
						if(barray[j][ry]=='.') { // 비어있어서 움직일수있는경우
						rb=j;
						continue;
						}
						else if(barray[j][ry]=='O') { //그대로 정답인경우
							rend=true;
						}
						break;
					}
					
					if(rend==true && bend==false)  return i+1;
					if(rb!=-1 && !rend) {
						barray[rx][ry] = '.';
						barray[rb][ry] = 'R';
						rx=rb;
					}
				}
				// B가 빠져버리면 끝나서 더이상 진행할 필요가없음
				if(bend) return 11;
			}
			else if(type==1) { //위로 땅기기
				
				if(rx<bx) {// r이 더 위에있기때문에  r먼저 움직일경우
					
					int rb = -1 ; // r이 막히는 아래블럭  index
					for(int j=rx-1;j>=0;j--) { // 검사해주기
						if(barray[j][ry]=='.') { // 비어있어서 움직일수있는경우
						rb=j;
						continue;
						}
						else if(barray[j][ry]=='O') { //그대로 정답인경우
							rend=true;
						}
						break;
					}
					
					if(rend) barray[rx][ry]='.';
					if(rb!=-1 && !rend) {
						barray[rx][ry] = '.';
						barray[rb][ry] = 'R';
						rx=rb;
					}
					
					int bb = -1;
					for(int j=bx-1;j>=0;j--) { // 검사해주기
						if(barray[j][by]=='.') { // 비어있어서 움직일수있는경우
						bb=j;
						continue;
						}
						else if(barray[j][by]=='O') { //그대로 정답인경우
							bend=true;
						}
						break;
					}
					if(rend==true && bend==false)  return i+1;
					if(bb!=-1 && !bend) {
						barray[bx][by] = '.';
						barray[bb][by] = 'B';
						bx=bb;
					}
				}
				else {
					
					int rb = -1 ; // r이 막히는 아래블럭  index
					int bb = -1;
					for(int j=bx-1;j>0;j--) { // 검사해주기
						if(barray[j][by]=='.') { // 비어있어서 움직일수있는경우
						bb=j;
						continue;
						}
						else if(barray[j][by]=='O') { //그대로 정답인경우
							bend=true;
						}
						break;
					}
					if(bend) barray[bx][by]='.';
					if(bb!=-1 && !bend) {
						barray[bx][by] = '.';
						barray[bb][by] = 'B';
						bx=bb;
					}

					for(int j=rx-1;j>=0;j--) { // 검사해주기
						if(barray[j][ry]=='.') { // 비어있어서 움직일수있는경우
						rb=j;
						continue;
						}
						else if(barray[j][ry]=='O') { //그대로 정답인경우
							rend=true;
						}
						break;
					}
					
					if(rend==true && bend==false)  return i+1;
					if(rb!=-1 && !rend) {
						barray[rx][ry] = '.';
						barray[rb][ry] = 'R';
						rx=rb;
					}
				}
				// B가 빠져버리면 끝나서 더이상 진행할 필요가없음
				if(bend) return 11;
			}
			else if(type==2) { //오른쪽 땅기기
				
				if(ry>by) {// r이 더 오른쪽에있기때문에 r먼저 움직일경우
					
					int rb = -1 ; // r이 막히는 오른쪽블럭  index
					for(int j=ry+1;j<M;j++) { // 검사해주기
						if(barray[rx][j]=='.') { // 비어있어서 움직일수있는경우
						rb=j;
						continue;
						}
						else if(barray[rx][j]=='O') { //그대로 정답인경우
							rend=true;
						}
						break;
					}
					
					if(rend) barray[rx][ry]='.';
					if(rb!=-1 && !rend) {
						barray[rx][ry] = '.';
						barray[rx][rb] = 'R';
						ry=rb;
					}
					
					int bb = -1;
					for(int j=by+1;j<M;j++) { // 검사해주기
						if(barray[bx][j]=='.') { // 비어있어서 움직일수있는경우
						bb=j;
						continue;
						}
						else if(barray[bx][j]=='O') { //그대로 정답인경우
							bend=true;
						}
						break;
					}
					if(rend==true && bend==false)  return i+1;
					if(bb!=-1 && !bend) {
						barray[bx][by] = '.';
						barray[bx][bb] = 'B';
						by=bb;
					}
				}
				else {
					
					int rb = -1 ; // r이 막히는 아래블럭  index
					int bb = -1;
					for(int j=by+1;j<M;j++) { // 검사해주기
						if(barray[bx][j]=='.') { // 비어있어서 움직일수있는경우
						bb=j;
						continue;
						}
						else if(barray[bx][j]=='O') { //그대로 정답인경우
							bend=true;
						}
						break;
					}
					if(bend) barray[bx][by]='.';
					if(bb!=-1 && !bend) {
						barray[bx][by] = '.';
						barray[bx][bb] = 'B';
						by=bb;
					}

					for(int j=ry+1;j<M;j++) { // 검사해주기
						if(barray[rx][j]=='.') { // 비어있어서 움직일수있는경우
						rb=j;
						continue;
						}
						else if(barray[rx][j]=='O') { //그대로 정답인경우
							rend=true;
						}
						break;
					}
					
					if(rend==true && bend==false)  return i+1;
					if(rb!=-1 && !rend) {
						barray[rx][ry] = '.';
						barray[rx][rb] = 'R';
						ry=rb;
					}
				}
				// B가 빠져버리면 끝나서 더이상 진행할 필요가없음
				if(bend) return 11;
			}
			else { //왼쪽
					if(ry<by) {// r이 더 왼쪽에있기때문에 r먼저 움직일경우
					
					int rb = -1 ; // r이 막히는 왼쪽블럭  index
					for(int j=ry-1;j>=0;j--) { // 검사해주기
						if(barray[rx][j]=='.') { // 비어있어서 움직일수있는경우
						rb=j;
						continue;
						}
						else if(barray[rx][j]=='O') { //그대로 정답인경우
							rend=true;
						}
						break;
					}
					
					if(rend) barray[rx][ry]='.';
					if(rb!=-1 && !rend) {
						barray[rx][ry] = '.';
						barray[rx][rb] = 'R';
						ry=rb;
					}
					
					int bb = -1;
					int tx=-1;int ty=-1;
					for(int j=by-1;j>=0;j--) { // 검사해주기
						if(barray[bx][j]=='.') { // 비어있어서 움직일수있는경우
						bb=j;
						continue;
						}
						else if(barray[bx][j]=='O') { //그대로 정답인경우
							bend=true;
						}
						tx=bx;
						ty=j;
						break;
					}
					if(rend==true && bend==false) {

						return i+1;
					}
					if(bb!=-1 && !bend) {
						barray[bx][by] = '.';
						barray[bx][bb] = 'B';
						by=bb;
					}
				}
				else {
					
					int rb = -1 ; // r이 막히는 아래블럭  index
					int bb = -1;
					for(int j=by-1;j>=0;j--) { // 검사해주기
						if(barray[bx][j]=='.') { // 비어있어서 움직일수있는경우
						bb=j;
						continue;
						}
						else if(barray[bx][j]=='O') { //그대로 정답인경우
							bend=true;
						}
						break;
					}
					if(bend) barray[bx][by]='.';
					if(bb!=-1 && !bend) {
						barray[bx][by] = '.';
						barray[bx][bb] = 'B';
						by=bb;
					}

					for(int j=ry-1;j>=0;j--) { // 검사해주기
						if(barray[rx][j]=='.') { // 비어있어서 움직일수있는경우
						rb=j;
						continue;
						}
						else if(barray[rx][j]=='O') { //그대로 정답인경우
							rend=true;
						}
						break;
					}
					
					if(rend==true && bend==false)  return i+1;
					if(rb!=-1 && !rend) {
						barray[rx][ry] = '.';
						barray[rx][rb] = 'R';
						ry=rb;
					}
				}
				// B가 빠져버리면 끝나서 더이상 진행할 필요가없음
				if(bend) return 11;
			}
		}
		
		return 11;
	}
	

}
