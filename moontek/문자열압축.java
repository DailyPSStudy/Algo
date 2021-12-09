package Programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열압축 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		System.out.println(solution(str));
	}

	
    public static int solution(String s) {
        int answer = 0;
        
        
        
        int size = s.length();
        answer = size;
        for(int i=1;i<=size/2;i++) {
        	
        	int j=0;
        	String str="";
        	int samecount=1;
        	boolean flag =false;
        	while(true) {
        		if(j+i+i>size) {
        			if(samecount!=1) {
        				str+= samecount+s.substring(j,j+i);
        			}
        			else {
        				str += s.substring(j,j+i);
        			}
        			str+= s.substring(j+i,size);
        			break;
        		}
        		String now = s.substring(j,j+i);
        		String next = s.substring(j+i,j+i+i);
        		if(now.equals(next)) {
        			samecount++;
        			
        		}
        		else {
        			if(samecount!=1) {
        				str+= samecount+now;
        				samecount=1;
        			}
        			else {
        				str+= now;
        			}
        		}
        		j=j+i;
        	}

        	
        	
        	answer = Math.min(answer, str.length());
        }

        return answer;
    }
}
