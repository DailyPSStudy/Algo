package Programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 거리두기확인하기 {

	static class point{
		int x;
		int y;
		public point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

			String[][] place = new String[][]{
				{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
				{"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, 
				{"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
				{"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
				{"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
			};
			solution(place);
	}
	   static public int[] solution(String[][] places) {
	        int pl = places.length;
	        int[] answer = new int[pl];
        	char[][] array = new char[5][5];

        	int[] dx = new int[] {0 , 0 , 1 , -1, -1,-1, 1 ,1};
        	int[] dy = new int[] {1 ,-1 , 0 ,  0, -1, 1,-1, 1};
	        for(int i=0;i<pl;i++) {
	        	Queue<point> q = new LinkedList<>();

	        	
	        	for(int j=0;j<5;j++) {
	        		for(int k=0;k<5;k++) {
	        			array[j][k] = places[i][j].charAt(k);
	        			if(array[j][k]=='P') {
	        				q.add(new point(j,k));
	        			}
	        		}
	        	}
	        	
	        	

	        	
	        	boolean flag = false;
	        	Loop1 :
	        	while(!q.isEmpty()) {
	        		
	        		point c = q.poll();
	        		int x = c.x;
	        		int y = c.y;
	        		for(int j=0;j<4;j++) { // 상 하 좌 우 탐색 (1칸탐색)
	        			int nx = x+dx[j];
	        			int ny = y+dy[j];
	        			if(nx<0 || nx >4 || ny<0 || ny>4) {
	        				continue;
	        			}
	        			if(array[nx][ny]=='P') { flag = true;break Loop1;
	        			}
	        			
	        		}
	        		
	        		for(int j=0;j<4;j++) { // 상 하 좌 우 탐색 (2칸탐색)
	        			int nx = x+2*(dx[j]);
	        			int ny = y+2*(dy[j]);
	        			if(nx<0 || nx >4 || ny<0 || ny>4) {
	        				continue;
	        			}
	        			if(array[nx][ny]=='P') {  
	        				if(array[x+dx[j]][y+dy[j]]!='X')  // 사이에 가림막이없다면
	        				{
	        				flag = true;break Loop1;}
	        				}
	        		}
	           		for(int j=4;j<8;j++) { // 대각선탐색 
	        			int nx = x+(dx[j]);
	        			int ny = y+(dy[j]);
	        			if(nx<0 || nx >4 || ny<0 || ny>4) {
	        				continue;
	        			}
	        			if(array[nx][ny]=='P') {  
	        				if(array[x][ny]!='X' || array[nx][y]!='X') {
	        					flag = true;break Loop1;}
	        				}
	        				
	        		}
	        		
	        		
	        	}
	        	
	        	
	        	
	        	if(!flag) {
	        		answer[i] = 1;
	        	}
	        	else {
	        		answer[i]=0;
	        	}
	        	
	        	
	        	
	        }
	        return answer;
	    }
}
