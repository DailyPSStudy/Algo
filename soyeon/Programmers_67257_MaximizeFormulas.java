package programmers_67257_MaximizeFormulas;
import java.util.*;
/**
 * 일    시: 2022-01-01
 * 작 성 자: 유 소 연
 * https://programmers.co.kr/learn/courses/30/lessons/67257
 * <주의사항>
 * 1. calc에서 Long.parseLong 을 사용했어야 하는데, Integer.parseInt 로 함.
 * 2. go 에서 i=0을 해줘야함. 안그러면 계속 뒤의 숫자들로 진행을 해버림.
 * 3. 우선순위로 정한 부분만 계산하는 식의 진행이 구현하기 너무 어려웠다. 그러나 ArrayList로 풀면 굉장히 쉽다ㅠㅠ 왜 문자열로 풀었는지...
 * */
class Programmers_67257_MaximizeFormulas {
    static char[] op = {'*','+','-'};
    static char[] priority;
    static boolean[] visited;
    static long max;
    
    public static void main(String[] args) {
//		long answer = solution("2*2*2*2*2-2*2*2"); // 32-8 = 24가 맞는데 왜 64가..?
		long answer = solution("1+4-0*9");
		System.out.println("answer : "+answer);
	}
    
    public static long solution(String expression) {
    	// expressiont에서 숫자와 연산자를 추출하여 list에 넣음
        ArrayList<String> list = readInput(expression);
        priority = new char[3];
        visited = new boolean[3];
//        printList(list); // test print
        // 순열로 우선순위 연산자 선정
        getPriority(0, expression, list);
        return max;
    } // end of solution


	private static void getPriority(int depth, String exp, ArrayList<String> list) {
		if(depth==3) {
			System.out.println(Arrays.toString(priority));
			ArrayList<String> copyOfList = copyList(list);
			long res = go(exp, copyOfList);
			System.out.println("연산결과: "+res);
			if(max<res) max = res;
			return;
		}
		for (int i = 0; i < op.length; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			priority[depth] = op[i];
			getPriority(depth+1, exp, list);
			visited[i] = false;
		}
	}


	/** priority에 맞춰 exp 연산 */
	private static long go(String exp, ArrayList<String> list) {
		
		while(list.size() > 1) {
			System.out.println("go");
			printList(list);
			
			for (int j = 0; j < 3; j++) {
				for (int i = 0; i < list.size(); i++) {
					String cur = list.get(i);
					String oper = Character.toString(priority[j]);
					if(cur.equals(oper)) {
						long res = calc(list.get(i-1), list.get(i+1), oper);
						remove(list, i-1);
						list.add(i-1, Long.toString(res));
						printList(list);
						i = 0; // 존나중요.
					}
				}
				
			}
			
		} // end of while
		
		long res = Long.parseLong(list.get(0));
		
		System.out.printf("res: %d\n",res);
		
		return Math.abs(res);
	}


	private static long calc(String a, String b, String oper) {
		long res = 0;
		switch(oper) {
			case "+" :
				res = Long.parseLong(a)+Long.parseLong(b);
				break;
			case "-" :
				res = Long.parseLong(a)-Long.parseLong(b);
				break;
			case "*" :
				res = Long.parseLong(a)*Long.parseLong(b);
				break;
		}
		return res;
	}

	/** 숫자,연산자를 추출하여 list에 넣음 */
	private static ArrayList<String> readInput(String exp) {
		ArrayList<String> list = new ArrayList<String>();
		String str = "";
		for (int i = 0; i < exp.length(); i++) {
			char ch = exp.charAt(i);
			if(Character.isDigit(ch)) {
				str += ch;
			}else {
				list.add(str);
				list.add(Character.toString(ch));
				str = "";
			}
		}
		list.add(str);
		return list;
	}
    
	private static void remove(ArrayList<String> list, int i) {
		for (int j = 0; j < 3; j++) {
			list.remove(i);
		}
	}
	
	/** list "깊은" 복사 */
	private static ArrayList<String> copyList(ArrayList<String> list) {
		ArrayList<String> res = new ArrayList<>();
		for(String str : list) {
			res.add(str);
		}
		return res;
	}
	
	/** list 출력 */
	private static void printList(ArrayList<String> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i)+" ");
		}
		System.out.println();
	}
    
    
} // end of class