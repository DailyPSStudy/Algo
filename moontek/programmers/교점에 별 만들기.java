import java.util.*;
class Solution {
    private int rMax = Integer.MIN_VALUE;
    private int cMax = Integer.MIN_VALUE;
    private int rMin = Integer.MAX_VALUE;
    private int cMin = Integer.MAX_VALUE;
    
    // 최대 최소 row column 설정
    
    
    private Set<String> hs = new HashSet<>();
    
    //세트를 집어넣을 해쉬셋설정 
    public String[] solution(int[][] line) {
        for(int i=0 ; i<line.length-1 ; i++) {
            for(int j=i+1 ; j<line.length ; j++) {
                helper(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]); // A,B,E, C,D,F 넣기
            }
        }
        String[] ret = new String[rMax-rMin+1];  //비교하면서 담을 스트링배열
        for(int i=rMax ; i>=rMin ; i--) {
            StringBuilder sb = new StringBuilder();  //SB사용
            for(int j=cMin ; j<=cMax ; j++) {
                sb.append(hs.contains(i+"|"+j)?"*":"."); // 해쉬셋검증
            }
            ret[rMax-i] = sb.toString();
        }
        return ret;
    }
    
    public void helper(int xx1, int yy1, int zz1, int xx2, int yy2, int zz2) {
        
        long x1=(long)xx1, y1=(long)yy1, z1=(long)zz1;
        long x2=(long)xx2, y2=(long)yy2, z2=(long)zz2;
        if(x1*y2==y1*x2 || (y1*z2-y2*z1)%(x1*y2-y1*x2)!=0 || (x2*z1-x1*z2)%(x1*y2-y1*x2)!=0) { //안생길 확률 교점이
            return;
        }
        //주어진 공식대로 좌표를구해줌
        int x = (int)(y1*z2-y2*z1)/(int)(x1*y2-y1*x2); 
        int y = (int)(x2*z1-x1*z2)/(int)(x1*y2-y1*x2);
        hs.add(y+"|"+x);
        
        //ROW COL 최대최소 최신화
        rMax = Math.max(rMax, y);
        rMin = Math.min(rMin, y);
        cMax = Math.max(cMax, x);
        cMin = Math.min(cMin, x);
    }
}