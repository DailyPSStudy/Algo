package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 카카오프렌즈컬러링북 {
		

		static boolean[][] visited;
		static int M;
		static int N;
		static int maxsize;
		static int[] dx = new int[]{1,-1, 0, 0};
		static int[] dy = new int[]{0, 0, 1,-1};
		static int[][] npicture;
		
		
	    static public int[] solution(int m, int n, int[][] picture) {
	        visited = new boolean[m][n];
	    	int numberOfArea = 0;
	        int maxSizeOfOneArea = 0;
	        npicture = picture;
	        M = m;
	        N = n;
	        for(int i=0;i<M;i++) {
	        	for(int j=0;j<N;j++) {
	        		if(picture[i][j]!=0 && !visited[i][j]) {
	        			visited[i][j] = true;
	        			maxsize = 1;
	        			dfs(i,j,picture[i][j]);
	        			numberOfArea++;
	        			maxSizeOfOneArea = Math.max(maxSizeOfOneArea, maxsize);
	        		}
	        	}
	        }
	        
	        
	        int[] answer = new int[2];
	        answer[0] = numberOfArea;
	        answer[1] = maxSizeOfOneArea;
	        return answer;
	    }
	private static void dfs(int x, int y, int type) {
			// TODO Auto-generated method stub
		
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx>=0 && nx < M && ny>=0 && ny <N ) {
				if(!visited[nx][ny]&& npicture[nx][ny]==type) {
					visited[nx][ny] = true;
					dfs(nx,ny,type);
					maxsize++;
				}
			}
		}
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[][] picture = new int[][] 
			 {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}
			 };
		 int[] answer = solution(6,4,picture);
		 
		 System.out.println(answer[0] + "  " +answer[1]);
	}

}
