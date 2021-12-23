package programmers_42586_FeatureDevelopment;

import java.util.*;
/**
 * ��    ��: 2021-12-24
 * �� �� ��: �� �� ��
 * https://programmers.co.kr/learn/courses/30/lessons/42586
 * */
public class Programmers_42586_FeatureDevelopment {
	public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> days = new ArrayList<>();
        for(int no = 0; no < progresses.length; no++) {
            double progress = 100-progresses[no];
            double speed = speeds[no];
            int day = (int)Math.ceil(progress/speed);
            days.add(day);
            System.out.printf("day %d\n",day);
        } // end of for
        
        List<Integer> ans = new ArrayList<>();
        int start = 0; int end = 1;
        int cnt = 1; // ����� ��
        while(start < days.size()) {
            System.out.printf("start: %d, end: %d\n", start, end);
            if(end >= days.size()) {
                // end�� ������ �� ������ start�� ��ĭ�ڷ��ؼ� �ٽ� Ž��
                break;
            }
            if(days.get(start) >= days.get(end)) {
                // start�� end���� ũ�ų� ������ �������� �����Ѵ�.
                cnt++;
                end++;
            }else{
                // �׷��� ������ �ٸ����� �����Ѵ�.
                ans.add(cnt);
                cnt = 1;
                start = end;
                end = start+1;
            }
            if(end >= days.size()) {
                // end�� ������ �� ������ start�� ��ĭ�ڷ��ؼ� �ٽ� Ž��
                ans.add(cnt);
                cnt = 1;
                start++;
                end = start+1;
                break;
            }
        } // end of while
        
        // ���
        int[] answer = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    } // end of solution
}
