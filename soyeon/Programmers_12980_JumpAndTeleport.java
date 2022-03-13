package programmers_12980_JumpAndTeleport;
/**
 * 일    시: 2022-01-09
 * 작 성 자: 유 소 연
 * https://programmers.co.kr/learn/courses/30/lessons/12980
 * */
public class Programmers_12980_JumpAndTeleport {
	
	public static void main(String[] args) {
		int ans = solution(5000);
		System.out.println(ans);
	}
	
	public static int solution(int n) {
		// Top-Down 방식 (n에서부터 0까지)
		// 숨바꼭질처럼 bfs로 풀면 효율성 테스트에서 시간초과남
		// 0 -> n 까지 가는데 *2 순간이동 써서 가는 것이 건전지 소모가 안돼서 효율적
		// 고로 0이 아닌 짝수일때에만 순간이동을 쓰고, 홀수일때에 점프를 하면됨
		int energy = 0;
		while(n > 0) {
			if(n%2==0) {
				// 순간이동
				n /= 2;
			}else {
				n--;
				energy++;
			}
		} // end of while
		
		return energy;
	} // end of solution
} // end of class
