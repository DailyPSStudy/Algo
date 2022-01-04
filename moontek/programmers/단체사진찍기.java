package Programmers;

import java.util.Arrays;

public class 단체사진찍기 {

	static int N;
	static String[] ndata;
	static int count;
	static boolean[] visited;
	static int[] array;
	static char[] alphalist;
	
	static int[] alpha;
	 static void dfs(int num){
		 if(num==8) {
			 // 
			 
			if (Math.abs(alpha['N']-alpha['F'])!=1) {
				return;
			}
			else if (Math.abs(alpha['R']-alpha['T'])<4) {
				return;
			}
			 
			 
			 for(int i=0;i<N;i++) {
				 char char1 = ndata[i].charAt(0);
				 char char2 = ndata[i].charAt(2);
				 char calt  = ndata[i].charAt(3);
				 int calr  = ndata[i].charAt(4)-'0'+1;
				 

				 if(calt=='=') {
					 if(Math.abs(alpha[char1]-alpha[char2])!=calr) {
						 return;
					 }
				 }
				 else if(calt=='<')
				 {


					 if(!(Math.abs(alpha[char1]-alpha[char2])<calr)) {

						 return;
					 } 

				 }
				 else if(calt=='>') 
				 {					
					 if(!(Math.abs(alpha[char1]-alpha[char2])<=calr)) {
						 return;
					 } 
				 }
			 }
			 count++;
			 return;
		 }
		 for(int i=0;i<8;i++) {
			 if(visited[i]) continue;
			 visited[i] = true;
			 alpha[alphalist[num]] = i;
			 dfs(num+1);
			 visited[i] = false;
		 }
	 }
	
	
	  public static int solution(int n, String[] data) {
		   alphalist= new char[] { 
					'A','C','F','J','M','N','R','T'
			};
		  	alpha = new int[100];
			count = 0;
			visited = new boolean[8];
			array = new int[8];
		  	ndata = data;
	        int answer = 0;
	        N = n;
	        dfs(0);
	        answer = count;
	        return answer;
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] data = new String[] {
				"M~C<2","C~M>1"
		};
		System.out.println(solution(2,data));
		System.out.println(count);
	}

}
