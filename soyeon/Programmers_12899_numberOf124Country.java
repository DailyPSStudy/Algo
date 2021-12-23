package programmers_12899_numberOf124Contry;
/**
 * 일    시: 2021-12-23
 * 작 성 자: 유 소 연
 * https://programmers.co.kr/learn/courses/30/lessons/12899
 * */
public class Programmers_12899_numberOf124Country {
	public String solution(int n) {
        // 나머지는 뒤에 붙이고, 몫이 0이 아니면 계속 나누고 붙이는것을 반복한다.
        // dp로 풀려고 했으나 n이 5억이라 규칙이 반드시 존재할 것이라 생각
        
        // 이 부분 int형 배열로 했더니 효율성에서 시간초과남.
        String[] num = {"4","1","2"}; // 나머지 0->4, 1->1, 2->2로 변환
        int m = n; // 몫
        int r = 0; // 나머지
        String ans = "";
        while(m > 0) {
            r = m%3;
            if(r==0) m--;
            m /= 3;
            ans = num[r]+ans;
        } // end of while
        return ans;
    } // end of solution
} // end of class
