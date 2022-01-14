package programmers_12985_ExpectedDraw;
/**
 * 일    시: 2022-01-14 5:10~5:40
 * 작 성 자: 유 소 연
 * https://programmers.co.kr/learn/courses/30/lessons/12985
 * (double)(a/2) vs (double)a/2
 * */
class Programmers_12985_ExpectedDraw {
 public int solution(int n, int a, int b) {
     
     // N : 1~10^6 => 큐로 돌리다간 터진다
     // ceil함수를 이용하여 /2 해나가야함
     int numberOfRound = 0;
     while(a!=b){
         // System.out.printf("before : %d vs %d\n", a,b);
         // System.out.println("b/2 "+(double)b/2);
         // System.out.println("b "+Math.ceil((double)b/2));
         a = (int)Math.ceil((double)a/2);
         b = (int)Math.ceil((double)b/2);
         
         // System.out.printf("after : %d vs %d\n", a,b);
         numberOfRound++;
         
     } // end of while
     
     return numberOfRound;
     
 } // end of solution
 
} // end of class
