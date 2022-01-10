package programmers_42839_FindPrimeNumber;

import java.util.*;
class Programmers_42839_FindPrimeNumber {
	static int[] n;
	 static boolean[] visited;
	 static Set<Integer> pn = new HashSet<>();
	 
	 public int solution(String numbers) {
	 	// �ߺ�����
	     // �Ҽ��� 1,2�� �����ϰ�, 1�� �ڱ��ڽŸ� ����� ������ ����
	     
	     // numbers�� �迭�� �Űܴ�´�.
	     n = new int[numbers.length()];
	     visited = new boolean[numbers.length()];
	     for(int i = 0; i < numbers.length(); i++){
	         n[i] = numbers.charAt(i)-'0';
	     }
	     
	     dfs(0, ""); // depth, start, number
	     return isPn(); // pn �߿� �Ҽ��� ����� ����.
	     
	     
	 }
	 // ������� �� �ִ� ������ pn�� ��´�.
	 private void dfs(int depth, String number){
	     if(depth == n.length) return;
	     
	     for(int i = 0; i < n.length; i++){
	         if(visited[i]) continue;
	         visited[i] = true;
	         pn.add(Integer.parseInt(number+n[i])); // Set �ִ°� add�³�.... �������� �Ф�
	         //System.out.println(number+n[i]);
	         dfs(depth+1, number+n[i]);
	         visited[i] = false;
	     }
	 }
	 
	 // dfs�� ���� ���� pn�߿� �Ҽ��� ����� ����.
	 private int isPn(){
	     int cnt = 0;
	     // �Ҽ��� 1�� 2�� �����ϰ�, 1�� �ڱ��ڽŸ� ����� ����
	     Iterator<Integer> iter = pn.iterator(); // �³�??...
	     while(iter.hasNext()){
	         int cur = iter.next();
	         System.out.println(cur);
	         
	         if(cur == 0 || cur == 1) continue; // 1�� �Ҽ��� �ƴ�
	         boolean flag = true;
	         
	         for(int i = 2; i < cur; i++){ // 1�� �ڱ��ڽ� �����ϰ� �������ٸ� �Ҽ��� �ƴ�
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