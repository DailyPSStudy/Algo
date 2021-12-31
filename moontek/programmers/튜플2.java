package Programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.StringTokenizer;

public class 튜플2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
		
		System.out.println(Arrays.toString(solution(s)));
	}
	   public static int[] solution(String s) {
		   
		   boolean visited[] = new boolean[100001];
		   String n ="";
		   n = s.substring(1, s.length()-1);
	       StringTokenizer st = new StringTokenizer(n,"}");
	       int count = st.countTokens();
		   
	        Set<Integer>[] array = new Set[count];
	        
	        for(int i=0;i<count;i++) {
	        	array[i] = new HashSet<>();
	        }
	        
	        int start =0;
	        int end = start+1;
	        while(!(end>=n.length())) {
	        	if(n.charAt(end)=='}') {
	        		Set<Integer> numbers = new HashSet<>();
	        		String num = "";
	        		int ccount = 0;
	        		for(int i=start+1;i<end;i++) {
	        			if(n.charAt(i)==',') {
	        				numbers.add(Integer.parseInt(num));
	        				ccount++;
	        				num="";
	        				continue;
	        			}
	        			num+= n.charAt(i);
	        		}
	        		numbers.add(Integer.parseInt(num));
	        		start = end+2;
	        		end = start+1;
	        		array[ccount] = numbers;
	        	}
	        	else {
	        		end++;
	        	}
	        }
	        int[] answer = new int[count];
	        
	        for(int i=0;i<count;i++) {
	        	Iterator<Integer> it = array[i].iterator();
	        	int num = it.next();
	        	
	        	for(int k=i+1;k<count;k++) {
	        		array[k].remove(num);
	        	}
	        	answer[i] = num;
	        }
	        

	        return answer;
	    }
}
