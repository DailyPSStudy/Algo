package programmers_81302_CheckTheDistance;
import java.util.*;
/**
 * ��    ��: 2021-12-30
 * �� �� ��: �� �� ��
 * https://programmers.co.kr/learn/courses/30/lessons/81302
 * BFS
 * */
class Programmers_81302_CheckTheDistance {
    static char[][] map;
    static boolean[][] visited;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int numberOfP = 0;
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        // �Ÿ��α� 2���� ����, but ��Ƽ���� ���̿� �ΰ������� ����
        for(int i = 0; i < places.length; i++) {
            // places[i]�� map�� �Űܴ��
            putInMap(places[i]);
            printMap();
            System.out.println("================");
            // System.out.println(Arrays.deepToString(map));
            
            // �����ڰ� �ƹ��� ������ ���������ִ°����� ����.
            if(numberOfP==0){
                answer[i] = 1;
                continue;
            }
            
            // bfs Ž��
            // boolean flag= false;
            int cnt = 0;
            Queue<int[]> q;
ex:            for(int y = 0; y < 5; y++) {
                for(int x = 0; x < 5; x++) {
                    if(map[y][x]=='P') {
                        q = new LinkedList<>();
                        visited = new boolean[5][5];
                        System.out.printf("%d,%d �˻����...\n",y,x);
                        q.add(new int[]{y,x,0,0});
                        visited[y][x] = true;
                        int dis = checkMap(q);
                        if(dis==0){//�ѹ��̶� ����Ű�� �ٷ� 0
                            answer[i] = 0;
                            System.out.println("�����׾�");
                            break ex;
                        }else{// ��� 1�̾�� ��.
                            cnt++;
                            System.out.printf("%dȸ ��Ŵ\n",cnt);
                        }
                    }
                }
            }
            System.out.println("numberOfP: "+numberOfP+", cnt: "+cnt);
            if(numberOfP==cnt){
                answer[i] = 1;
            }
            numberOfP=0;
            cnt = 0;
        } // end of for
        
        
        return answer;
    } // end of solution
    
    /** places[]�� map�� �Űܴ�� */
    public void putInMap(String[] places) {
        map = new char[5][5];
        visited = new boolean[5][5];
        for(int i = 0; i < places.length; i++) {
            String row = places[i];
            for(int j = 0; j < row.length(); j++) {
                map[i][j] = row.charAt(j);
                if(map[i][j]=='P') {
                    // q.add(new int[]{i,j,0,0});
                    numberOfP++;
                }
            }
        }
    } // end of putInMap
    
    /** bfs�� �Ÿ��α� Ž�� */
    public int checkMap(Queue<int[]> q) {
        while(q.size()!=0) {
            int[] cur = q.poll();
            System.out.printf("%d,%d �˻�, ����Ÿ� %d\n", cur[0],cur[1],cur[2]);
            for(int d = 0; d < 4; d++) {
                int ny = cur[0]+dy[d];
                int nx=  cur[1]+dx[d];
                if(!inRange(ny,nx) || cur[2]>1 || visited[ny][nx]) continue;
                if(map[ny][nx]=='P' && cur[3]==0){
                    // ��Ƽ�� ���µ� �Ÿ��α����������
                    System.out.printf("%d,%d ����Ŵ\n",ny,nx);
                    return 0;
                }
                if(map[ny][nx]=='X') {
                    // ��Ƽ���̸� ��Ƽ��+1 �ϰ� ť�� ����
                    q.add(new int[]{ny,nx,cur[2]+1,cur[3]+1});
                }else{
                    // �� �� 
                    q.add(new int[]{ny,nx,cur[2]+1,cur[3]});
                }
                visited[ny][nx] = true;
            }
        }
        return 1;
    }
    
    public boolean inRange(int ny, int nx) {
        return ny>=0 && nx>=0 && ny<5 && nx<5;
    }
    
    public void initVisited() {
        for(int y = 0; y < 5; y++) {
            for(int x = 0; x < 5; x++) {
                visited[y][x] = false;
            }
        }
    }
    
    public void printMap(){
        for(int i = 0; i < 5; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
    }
} // end of class