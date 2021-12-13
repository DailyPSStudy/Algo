package programmers_1835_takeAGroupPhoto;
import java.util.*;
/*
 * 
 * ���α׷��ӽ�
 * 1835. ��ü���� ���
 * https://programmers.co.kr/learn/courses/30/lessons/1835
 * 2021-12-13
 * 
 * */
class Programmers_1835_takeAGroupPhoto {
	static int cnt;
    static boolean[] visited;
    static char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    
    public int solution(int n, String[] condition) {
    	// ������ ��� ����� ���� �����
        // �� ��찡 ���ǿ� �´��� üũ
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
            // me�� target ��ġ�� �����ϱ�
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
            // diff ����ϱ�
            if(op == '='){
                if (diff!=end-start-1) { // ����
                    return false;
                }
            } else if (op == '<') { // �̸�
                if(diff<=end-start-1) {
                    return false;
                }
            } else if(op == '>') { // �ʰ�
                if(diff>=end-start-1) {
                    return false;
                }
            }
        } // end of condition
        return true;
    } // end of checkCondition
} // end of class