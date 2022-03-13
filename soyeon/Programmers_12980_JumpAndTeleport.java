package programmers_12980_JumpAndTeleport;
/**
 * ��    ��: 2022-01-09
 * �� �� ��: �� �� ��
 * https://programmers.co.kr/learn/courses/30/lessons/12980
 * */
public class Programmers_12980_JumpAndTeleport {
	
	public static void main(String[] args) {
		int ans = solution(5000);
		System.out.println(ans);
	}
	
	public static int solution(int n) {
		// Top-Down ��� (n�������� 0����)
		// ���ٲ���ó�� bfs�� Ǯ�� ȿ���� �׽�Ʈ���� �ð��ʰ���
		// 0 -> n ���� ���µ� *2 �����̵� �Ἥ ���� ���� ������ �Ҹ� �ȵż� ȿ����
		// ��� 0�� �ƴ� ¦���϶����� �����̵��� ����, Ȧ���϶��� ������ �ϸ��
		int energy = 0;
		while(n > 0) {
			if(n%2==0) {
				// �����̵�
				n /= 2;
			}else {
				n--;
				energy++;
			}
		} // end of while
		
		return energy;
	} // end of solution
} // end of class
