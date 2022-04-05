import java.util.*;
class Solution {
    public int solution(String dirs) {
        int answer=0;
        boolean visited[][][] = new boolean[11][11][4]; //길이가 최대 500이래서..
        
        int nowx=5; 
        int nowy=5;
        int nowd= -1;
        
        int[] dx = new int[]{0,1,0,-1};
        int[] dy = new int[]{1,0,-1,0};
        
        for(int i=0;i<dirs.length();i++){
            char nowc = dirs.charAt(i);
            int revd = -1;
            if(nowc=='U') nowd=0;
            else if(nowc=='D') nowd=2;
            else if(nowc=='R') nowd=1;
            else nowd =3;
            
            int newx = nowx + dx[nowd];
            int newy = nowy + dy[nowd];
            if(newx<0 || newx >10|| newy<0 || newy >10){
                continue;
            }

            revd = (nowd+2)%4;
            if(!visited[newx][newy][nowd] && !visited[nowx][nowy][revd]){
                visited[newx][newy][nowd] = true;
                visited[nowx][nowy][revd] = true;
                answer++;
            }
            nowx =newx;
            nowy =newy;

        }

        return answer;
    }
}