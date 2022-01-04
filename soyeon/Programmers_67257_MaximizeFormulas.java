package programmers_67257_MaximizeFormulas;
import java.util.*;
/**
 * ��    ��: 2022-01-01
 * �� �� ��: �� �� ��
 * https://programmers.co.kr/learn/courses/30/lessons/67257
 * <���ǻ���>
 * 1. calc���� Long.parseLong �� ����߾�� �ϴµ�, Integer.parseInt �� ��.
 * 2. go ���� i=0�� �������. �ȱ׷��� ��� ���� ���ڵ�� ������ �ع���.
 * 3. �켱������ ���� �κи� ����ϴ� ���� ������ �����ϱ� �ʹ� �������. �׷��� ArrayList�� Ǯ�� ������ ���٤Ф� �� ���ڿ��� Ǯ������...
 * */
class Programmers_67257_MaximizeFormulas {
    static char[] op = {'*','+','-'};
    static char[] priority;
    static boolean[] visited;
    static long max;
    
    public static void main(String[] args) {
//		long answer = solution("2*2*2*2*2-2*2*2"); // 32-8 = 24�� �´µ� �� 64��..?
		long answer = solution("1+4-0*9");
		System.out.println("answer : "+answer);
	}
    
    public static long solution(String expression) {
    	// expressiont���� ���ڿ� �����ڸ� �����Ͽ� list�� ����
        ArrayList<String> list = readInput(expression);
        priority = new char[3];
        visited = new boolean[3];
//        printList(list); // test print
        // ������ �켱���� ������ ����
        getPriority(0, expression, list);
        return max;
    } // end of solution


	private static void getPriority(int depth, String exp, ArrayList<String> list) {
		if(depth==3) {
			System.out.println(Arrays.toString(priority));
			ArrayList<String> copyOfList = copyList(list);
			long res = go(exp, copyOfList);
			System.out.println("������: "+res);
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


	/** priority�� ���� exp ���� */
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
						i = 0; // �����߿�.
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

	/** ����,�����ڸ� �����Ͽ� list�� ���� */
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
	
	/** list "����" ���� */
	private static ArrayList<String> copyList(ArrayList<String> list) {
		ArrayList<String> res = new ArrayList<>();
		for(String str : list) {
			res.add(str);
		}
		return res;
	}
	
	/** list ��� */
	private static void printList(ArrayList<String> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i)+" ");
		}
		System.out.println();
	}
    
    
} // end of class