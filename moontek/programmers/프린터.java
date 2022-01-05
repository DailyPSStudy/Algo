package Programmers;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class doc {
	int index;
	int value;
	public doc(int index, int value) {
		this.index = index;
		this.value = value;
	}
	
}
public class 프린터 {

	
	   public static int solution(int[] priorities, int location) {
		   Queue<doc> s = new LinkedList<>();
		   
		   int max = 0;
		   for(int k=0;k<priorities.length;k++) {
			   max = Math.max(max, priorities[k]);
			   s.add(new doc(k,priorities[k]));
		   }
		    int answer = 0;
		    int count = 0;
		   while(!s.isEmpty()) {

			   doc current = s.poll();
			   if(current.value==max) {
				   max=0;
				   answer++;
				   if(current.index==location) {
					   break;
				   }
				  Iterator it = s.iterator();
				  doc n = null;
				   while(it.hasNext()) {
					    n = (doc) it.next();
					   max = Math.max(max, n.value);
				   }
				   
			   }
			   else {
				   s.add(current);
			   }
		   }
		  System.out.println(answer);
	        return answer;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] pro = {1, 1, 9, 1, 1, 1};
		int location = 0;
		solution(pro,location);
	}

}
