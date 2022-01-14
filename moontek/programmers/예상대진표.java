package Programmers;

import java.util.*;
public class 예상대진표 {

	    public int solution(int n, int a, int b)
	    {
	        boolean[] array = new boolean[n];
	        array[a-1] = true;
	        array[b-1] = true;
	        
	        Queue<Boolean> q = new LinkedList<>();

	        for(int i=0;i<n;i++)
	        {
	         q.add(array[i]);   
	        }
	        int answer = 0;
	        Loop:
	        while(true)
	        {
	        Queue<Boolean> qb = new LinkedList<>();
	        answer++;
	        int qsize = q.size();
	          for(int i=0;i<qsize;i=i+2){
	             boolean first  = q.poll();
	             boolean second = q.poll();
	              
	              if(!first && !second){
	                  qb.add(false);
	              }
	              else if(first && second){
	                  break Loop;
	              }
	              else {
	                  qb.add(true);
	              }
	          }
	        q=qb;
	        }
	        


	        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
	        System.out.println("Hello Java");

	        return answer;
	     }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
