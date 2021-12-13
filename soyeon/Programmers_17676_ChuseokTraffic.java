package programmers_17676_ChuseokTraffic;
import java.util.*;
// https://gre-eny.tistory.com/133
class Programmers_17676_ChuseokTraffic {
    public int solution(String[] lines) {
        int answer = 0;
        // 특정 1초에서 동시에 실행되는 트래픽이 최대 몇개인지 찾아야 함
        // 하지만 하루 24시동안의 범위가 굉장히 크기 때문에 이는 불가능.
        // 따라서 트래픽개수의 '변화'가 이뤄지는 몇개 부분만 검사하면 됨
        // 시작시간~시작시간+1.0s : 시작시간 이후 트래픽 개수가 1 증가하므로
        // 응답시간~응답시간+1.0s : 응답시간 이후 트래픽 개수가 1 감소하므로
        // 즉, 저 두가지경우에 몇개의 트래픽이 존재하는지 검사하고 그중 최대값을 찾으면 됨
        int[] start = new int[lines.length];
        int[] end = new int[lines.length];
        for(int i = 0; i < lines.length; i++){
            String[] log = lines[i].split(" ");
            String[] time = log[1].split(":");
            // 시작시간: 응답시간-처리시간+1s
            // 처리시간: ms*1000
            int process = (int)(Double.parseDouble(log[2].substring(0, log[2].length()-1))*1000);
            end[i] = (int)(((Double.parseDouble(time[0])*3600) + (Double.parseDouble(time[1])*60) + Double.parseDouble(time[2]))*1000);
            start[i] = end[i]-process+1;
        }
        // end of start, end time
        int len = lines.length;
        int max = 0;
        for(int i = 0; i < len; i++){
            int startT = start[i]+1000; // +1s
            int endT = end[i]+1000;
            int cnt = 0;
            // 현재 구간에 존재하는 요청의 개수 카운트
            cnt = getCount(start, end, len, startT, 0, start[i], i);
            max = Math.max(cnt, max);
            cnt = getCount(start, end, len, endT, 0, end[i], i);
            max = Math.max(cnt, max);
        }
        return max;
    } // end of solution
    
    private int getCount(int[] start, int[] end, int len, int startT, int cnt, int cur, int i){
        // 각각의 로그에 대해 (시작시간~시작시간+1.0s), (응답시간~응답시간+1.0s)에 몇개 트래픽이 있는지 카운트
        for(int j = 0; j < len; j++){
            if((start[j]<=cur && startT<=end[j]) || (cur<=start[j] && start[j]<startT) || (cur<=end[j]&&end[j]<startT)){
                cnt++;
            }
        }
        return cnt;
    } // end of getCount
} // end of class