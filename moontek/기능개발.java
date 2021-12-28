package Programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 기능개발 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = new int[] {95, 90, 99, 99, 80, 99};
		int[] b = new int[] {1, 1, 1, 1, 1, 1};

		System.out.println(		Arrays.toString(solution(a,b)));

	}

	
	 public static int[] solution(int[] progresses, int[] speeds) {
	        int[] answer = {};
	        
	        
	        Queue<Integer> q = new LinkedList<>();
	        for(int i=0;i<progresses.length;i++) {
	        	q.add(progresses[i]);
	        }
	        
	        int[] f = new int[progresses.length];
	        int cindex = 0;
	        int sindex = 0;
	        int cmax = -1;
	        while(!q.isEmpty()) {
	        	int current = q.poll();
	        	current = 100-current;
	        	int time;
	        	if(current%speeds[sindex]==0) {
	        		time = current/speeds[sindex];
	        	}
	        	else {
	        		time = (current/speeds[sindex]) +1;
	        	}

	        	if(cmax==-1) {
	        		cmax = time;
	        		f[cindex]++;
	        		sindex++;
	        		continue;
	        	}
	        	
	        	if(cmax >= time) {
	        	f[cindex]++;
	        	sindex++;
	        	}
	        	else {
	        		f[++cindex]++;
	        		sindex++;
	        		cmax = time;
	        	}
	        }
	        
	        
	        answer = new int[cindex+1];
	        
	        for(int i=0;i<=cindex;i++) {
	        	answer[i] = f[i];
	        }
	        return answer;
	    }
}
