package programmers_1835_takeAGroupPhoto;
import java.util.*;
/*
 * 
 * 프로그래머스
 * 1835. 단체사진 찍기
 * https://programmers.co.kr/learn/courses/30/lessons/1835
 * 2021-12-13
 * 
 * */
class Programmers_1835_takeAGroupPhoto {
	static int cnt;
    static boolean[] visited;
    static char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    
    public int solution(int n, String[] condition) {
    	// 순열로 모든 경우의 수를 만들고
        // 그 경우가 조건에 맞는지 체크
        visited = new boolean[8];
        cnt = 0;
        dfs(0, "", condition); // depth, line
        System.out.println(cnt);
        return cnt;
    } // end of solution
    
    public void dfs(int depth, String line, String[] condition) {
        if(depth == 8) {
            if(checkCondition(line, condition)){
                cnt++;   
            }
            return;
        }
        for(int i = 0; i < 8; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            dfs(depth+1, line+friends[i], condition);
            visited[i] = false;
        }
    } // end of dfs
    
    public boolean checkCondition(String line, String[] condition) {
        // System.out.printf("[ %s ]\n", line);
        for(int j = 0; j < condition.length; j++){
            char me = condition[j].charAt(0);
            char target = condition[j].charAt(2);
            int diff = condition[j].charAt(4)-'0';
            char op = condition[j].charAt(3);
            int start = -1;
            int end = -1;
            // me와 target 위치를 가늠하기
            for(int i = 0; i < 8; i++) {
                char ch = line.charAt(i);
                if(start==-1 && (ch==me || ch==target)) {
                    start = i;
                    end = i+1;
                }else if(start!=-1 && ch!=me && ch!=target) {
                    end++;
                }else if(start!=-1 && (ch==me || ch==target)) {
                    end = i;
                    break;
                }
            }
            // diff 계산하기
            if(op == '='){
                if (diff!=end-start-1) { // 같음
                    return false;
                }
            } else if (op == '<') { // 미만
                if(diff<=end-start-1) {
                    return false;
                }
            } else if(op == '>') { // 초과
                if(diff>=end-start-1) {
                    return false;
                }
            }
        } // end of condition
        return true;
    } // end of checkCondition
} // end of class