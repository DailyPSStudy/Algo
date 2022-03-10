import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
class Node{
	int x;
	int y;
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}
public class 움직이는미로탈출 {

	static boolean[][] Array = new boolean[8][8];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0;i<8;i++) {
			String line = br.readLine();
			for(int j=0;j<8;j++) {
				if(line.charAt(j)=='.') {
					Array[i][j]=true;
				}
				else {
					Array[i][j]=false;
				}
			}
		}

		
		if(bfs()) {
			System.out.println(1);
		}
		else {
			System.out.println(0);
		}
		
	}
	
	public static boolean bfs() {
		int[] dy = {-1, 0, 1, 0, 0, -1, 1, -1, 1};
		int[] dx = {0, -1, 0, 1, 0, 1, -1, -1, 1};
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(7,0));
		boolean flag= false;
		boolean[][] visited = new boolean[8][8];
		while(!q.isEmpty()) {
			int size = q.size();
			visited = new boolean[8][8];
			
			for(int a=0;a<size;a++) {
				
			Node current = q.poll();
			int cx = current.x;
			int cy = current.y;
			
			if(!Array[cx][cy]) continue;
			
			if(cx==0 && cy==7) {
				return true;
			}
			
			for(int i=0;i<9;i++) {
				int ncx = cx+dx[i];
				int ncy = cy+dy[i];
				
				if(ncx<0 || ncx>7 || ncy <0 || ncy>7) continue;
				if(visited[ncx][ncy] || !Array[ncx][ncy]) continue;
				
				q.add(new Node(ncx,ncy));
				visited[ncx][ncy] = true;
				
				}
			
			}
			
			
			wall_move();
		}
		return false;
	}
	
	
	
	public static void wall_move() {
		  for (int i = 7; i >= 0; i--) {
	            for (int j = 0; j < 8; j++) {
	                if (!Array[i][j]) {
	                    Array[i][j] = true;

	                    if (i != 7) {
	                        Array[i + 1][j] = false;
	                    }
	                }
	            }
	        }
	}
}