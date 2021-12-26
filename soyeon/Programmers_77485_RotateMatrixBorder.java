package programmers_77485_RotateMatrixBorder;
import java.util.*;
/**
* ��    ��: 2021-12-25
* �� �� ��: �� �� ��
* https://programmers.co.kr/learn/courses/30/lessons/77485
*/
class Programmers_77485_RotateMatrixBorder {
    static int[][] map;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        // map�� 1~r*c��ŭ ���� �����ϱ�
        setMap(rows, columns);
        // System.out.println(Arrays.deepToString(map));
        printMap(map);
        for (int i = 0; i < queries.length; i++) {
        	// �����鼭 �ּҰ� ã�� ����
        	answer[i] = rotation(queries[i], map);
        	// System.out.println(Arrays.deepToString(map));
        	printMap(map);
		} // end of rotate
        return answer;
    } // end of solution
    
    public void setMap(int rows, int columns) {
        map = new int[rows][columns];
        int size = 1;
        for(int y = 0; y < rows; y++) {
            for(int x = 0; x < columns; x++) {
                map[y][x] = size;
                size++;
            }
        }
    } // end of setMap
    
    public int rotation(int[] query, int[][] map) {
    	boolean stop = false;
        int[] dy = {0,1,0,-1}; // �����»�
        int[] dx = {1,0,-1,0};
        int start_y = query[0]-1; int start_x = query[1]-1;
        int y = start_y; int x = start_x;
        int dir = 0; int next = 0; int cur = map[y][x]; int min = 9701;
        int ny = start_y+dy[dir]; int nx = start_x+dx[dir];
        do {
            if(min > map[y][x]) min = map[y][x];
            if(y==start_y && x==start_x && stop) break;
            stop = true; // ó�� start ������ �ѹ� �ѱ�� ����
            // next�� �����ϰ�, ���縦 next��, �������� temp�� ����δ�µ�, 
            next = map[ny][nx];
            map[ny][nx] = cur;
            y = ny; x = nx;
            cur = next;
            if(!inRange(ny+dy[dir],nx+dx[dir],query)) {
                // ���� �Ѿ�� ������ȯ
                dir = (dir+1)%4;
            }
            ny = ny+dy[dir]; nx = nx+dx[dir];
        } while(true);
        return min;
    } // end of rotation
    
    public boolean inRange(int ny, int nx, int[] query) {
        return ny >= query[0]-1 && nx >= query[1]-1 && ny < query[2] && nx < query[3];
    } // end of inRange
    
    public void printMap(int[][] map) {
        for(int y = 0; y < map.length; y++) {
            System.out.println(Arrays.toString(map[y]));
        }
    } // end of printMap
} // end of class