package programmers_42586_FeatureDevelopment;

import java.util.*;
/**
 * 일    시: 2021-12-24
 * 작 성 자: 유 소 연
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
        int cnt = 1; // 기능의 수
        while(start < days.size()) {
            System.out.printf("start: %d, end: %d\n", start, end);
            if(end >= days.size()) {
                // end가 끝까지 다 갔으면 start를 한칸뒤로해서 다시 탐색
                break;
            }
            if(days.get(start) >= days.get(end)) {
                // start가 end보다 크거나 같으면 같은날에 배포한다.
                cnt++;
                end++;
            }else{
                // 그렇지 않으면 다른날에 배포한다.
                ans.add(cnt);
                cnt = 1;
                start = end;
                end = start+1;
            }
            if(end >= days.size()) {
                // end가 끝까지 다 갔으면 start를 한칸뒤로해서 다시 탐색
                ans.add(cnt);
                cnt = 1;
                start++;
                end = start+1;
                break;
            }
        } // end of while
        
        // 출력
        int[] answer = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    } // end of solution
}
