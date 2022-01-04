package Programmers;

import java.util.Arrays;
import java.util.LinkedList;

public class 수식최대화 {
    public static long solution(String expression) {
        String[] order = new String[]{ "*+-","*-+","-+*","-*+","+*-","+-*"};
        long exl = expression.length();
    	LinkedList<Long> narray;
    	LinkedList<Character> carray;
    	long realresult = 0;
        for(int i=0;i<6;i++) {
        	narray = new LinkedList<>();
        	carray = new LinkedList<>();
        	char fir = order[i].charAt(0);
        	char sec = order[i].charAt(1);
        	char thi = order[i].charAt(2);


        	
        	int prev =0;
        	long number = 0;
        	for(int j=0;j<exl;j++) {
        		char now = expression.charAt(j);
        		if(now-'0'<0) {
            			String num = "";
            			for(int k=prev;k<j;k++) {
            				
            			num += expression.charAt(k);	
            			
            			}

        			number = Integer.parseInt(num);
        			narray.add(number);
        			prev = j+1;
        			carray.add(now);
        		}
        	}
        	String num = "";
        	for(int j=prev;j<exl;j++) {
        		num += expression.charAt(j);
        	}
        	narray.add((long) Integer.parseInt(num));
        	
        	

        	
        	int start = 0;
        	while(!(start>=carray.size())) {
        		
        		if(carray.get(start)==fir) {
          
        			carray.remove(start);
        			long result = cal(narray.get(start),narray.get(start+1),fir);
        			narray.remove(start);
        			narray.set(start, result);
        			
        		}
        		else {
        			start++;
        			continue;
        		}
        	}
        	start = 0;
        	while(!(start>=carray.size())) {
        		
        		if(carray.get(start)==sec) {
        			carray.remove(start);
        			long result = cal(narray.get(start),narray.get(start+1),sec);
        			narray.remove(start);
        			narray.set(start, result);
        		}
        		else {
        			start++;
        			continue;
        		}
        	}
        	start = 0;
        	while(!(start>=carray.size())) {
        		
        		if(carray.get(start)==thi) {
        			carray.remove(start);
        			long result = cal(narray.get(start),narray.get(start+1),thi);
        			narray.remove(start);
        			narray.set(start, result);
        		}
        		else {
        			start++;
        			continue;
        		}
        	}
        	

        	
        	realresult = Math.max(realresult, Math.abs(narray.get(0)));

        }
        System.out.println(realresult);
        return realresult;
    }
    public static long cal(long number1,long number2, char type) {
    	long answer = 0;
    	switch(type) {
    	case '*': answer= number1*number2; break;
    	case '-': answer= number1-number2; break;
    	case '+': answer= number1+number2; break;
    	}
    	return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "100-200*300-500+20";
		
		
		solution(str);
	}

}
