package Programmers;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 가장큰수 {
	
	static class number implements Comparable<number>{
		String num;
		public number(String num) {
			this.num = num;
		}
		public int compareTo(number o) {
			String first = this.num+o.num;
			String second = o.num+this.num;
			if(Integer.parseInt(first)<Integer.parseInt(second)) {
				return 1;
			}
			return -1;
		}
		
	}
	  public static String solution(int[] numbers) {
	        StringBuilder sb = new StringBuilder();
	        
	        PriorityQueue<number> pq = new PriorityQueue<>();

	        for(int i=0;i<numbers.length;i++) {
	        	pq.add(new number(String.valueOf(numbers[i])));
	        }
	        while(!pq.isEmpty()) {
    			sb.append(pq.poll().num);
    		}

	        String answer = sb.toString();
	        if(answer.charAt(0)=='0')
	        	return "0";
	        return answer;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = new int[] {
		23,232,21,212 };
		System.out.println(solution(numbers));
	}
}
