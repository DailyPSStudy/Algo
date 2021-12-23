package programmers_12899_numberOf124Contry;
/**
 * ��    ��: 2021-12-23
 * �� �� ��: �� �� ��
 * https://programmers.co.kr/learn/courses/30/lessons/12899
 * */
public class Programmers_12899_numberOf124Country {
	public String solution(int n) {
        // �������� �ڿ� ���̰�, ���� 0�� �ƴϸ� ��� ������ ���̴°��� �ݺ��Ѵ�.
        // dp�� Ǯ���� ������ n�� 5���̶� ��Ģ�� �ݵ�� ������ ���̶� ����
        
        // �� �κ� int�� �迭�� �ߴ��� ȿ�������� �ð��ʰ���.
        String[] num = {"4","1","2"}; // ������ 0->4, 1->1, 2->2�� ��ȯ
        int m = n; // ��
        int r = 0; // ������
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
