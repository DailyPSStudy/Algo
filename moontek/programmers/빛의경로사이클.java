package Programmers;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 빛의경로사이클 {

	static String[] garray;
	static int array[][][];
	static int c;
	static int r;
	static int[] dx = new int[]{-1, 0, 1, 0};
	static int[] dy = new int[]{ 0,-1,0,  1};
	   public static int[] solution(String[] grid) {
	       garray = grid;
	       c = grid[0].length(); 
		   r = grid.length;
		   PriorityQueue<Integer> pq = new PriorityQueue<>();
		   array = new int[r][c][4];
		   
		   for(int i=0;i<r;i++) {
			   for(int j=0;j<c;j++) {
				   for(int k=0;k<4;k++) {
					   if(array[i][j][k]==0) {
						   pq.add(shoot(i,j,k));
					   }
				   }
			   }
		   }
		   
		   int size = pq.size();
		   int[] answer = new int[size];
		   int index=0;
		   while(!pq.isEmpty()) {
			   answer[index] = pq.poll();
					   index++;
		   }
		   
	       return answer;
	    }
	private static int shoot(int x, int y, int d) {
		// TODO Auto-generated method stub
		int as = 0;
		int nx = x;
		int ny = y;
		int nd = d;
		while(true) {
			if(array[nx][ny][nd]==1) {
				break;
			}
			array[nx][ny][nd] = 1;
			as++;
			if(garray[nx].charAt(ny)=='R') {
				nd = (nd+1)%4;
			}
			else if(garray[nx].charAt(ny)=='L'){
				nd = (nd+3)%4;
				
			}
			nx = (nx +dx[nd]+r)%r;
			ny = (ny +dy[nd]+c)%c;
		

		}
		return as;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] grid = new String[]{ "SL","LR"};
		System.out.println(Arrays.toString(solution(grid)));
		
	}

}
