package programmers_42839_FindPrimeNumber;

import java.util.*;
class Programmers_42839_FindPrimeNumber {
	static int[] n;
	 static boolean[] visited;
	 static Set<Integer> pn = new HashSet<>();
	 
	 public int solution(String numbers) {
	 	// 중복조합
	     // 소수는 1,2를 제외하고, 1과 자기자신만 약수로 가지는 숫자
	     
	     // numbers를 배열에 옮겨담는다.
	     n = new int[numbers.length()];
	     visited = new boolean[numbers.length()];
	     for(int i = 0; i < numbers.length(); i++){
	         n[i] = numbers.charAt(i)-'0';
	     }
	     
	     dfs(0, ""); // depth, start, number
	     return isPn(); // pn 중에 소수가 몇개인지 센다.
	     
	     
	 }
	 // 만들어질 수 있는 모든수를 pn에 담는다.
	 private void dfs(int depth, String number){
	     if(depth == n.length) return;
	     
	     for(int i = 0; i < n.length; i++){
	         if(visited[i]) continue;
	         visited[i] = true;
	         pn.add(Integer.parseInt(number+n[i])); // Set 넣는게 add맞나.... 가물가물 ㅠㅠ
	         //System.out.println(number+n[i]);
	         dfs(depth+1, number+n[i]);
	         visited[i] = false;
	     }
	 }
	 
	 // dfs를 통해 담은 pn중에 소수가 몇개인지 센다.
	 private int isPn(){
	     int cnt = 0;
	     // 소수는 1과 2를 제외하고, 1과 자기자신만 약수로 가짐
	     Iterator<Integer> iter = pn.iterator(); // 맞나??...
	     while(iter.hasNext()){
	         int cur = iter.next();
	         System.out.println(cur);
	         
	         if(cur == 0 || cur == 1) continue; // 1은 소수가 아님
	         boolean flag = true;
	         
	         for(int i = 2; i < cur; i++){ // 1과 자기자신 제외하고 나눠진다면 소수가 아님
	             if(cur%i == 0) {
	                 flag = false;
	                 break;
	             }
	         }
	         if(flag) cnt++;
	     } // end of while
	     return cnt;
	 } // end of isPn
 
 
 
} //end of class