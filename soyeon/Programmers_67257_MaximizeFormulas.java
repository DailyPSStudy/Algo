package programmers_67257_MaximizeFormulas;
import java.util.*;

class Programmers_67257_MaximizeFormulas {
    static char[] op = {'*','+','-'};
    static char[] priority;
    static boolean[] visited;
    static long max;
    
    public static void main(String[] args) {
		long answer = solution("100-200*300-500+20");
		System.out.println(answer);
	}
    
    public static long solution(String expression) {
        
        // 순열로 연산자의 우선순위를 구함
        priority = new char[3];
        visited = new boolean[3];
        getPriority(0, expression); // depth, expr
        
        return max;
    } // end of solution
    
    /** 순열로 연산자의 우선순위를 구함 */
    public static void getPriority(int depth, String expr) {
        if(depth==3) {
            long res = go(expr); // 우선순위대로 계산하기
            if(res > max) max = res;
            return;
        }
        for(int i = 0; i < 3; i++) {
            if(visited[i]) continue;
            priority[depth] = op[i];
            getPriority(depth+1, expr);
        }
    }
    
    /** 우선순위대로 expr 계산 */
    public static long go(String expr) {
        // 연산자의 위치만 따로 빼둠
        int[] opIndex = findOpIndex(expr);
        System.out.printf("%s\n", expr);
        
        while(opIndex.length!=0){
            // 최우선순위 찾음
            for(int i = 0; i < priority.length; i++) {
                char op = priority[i];
                System.out.printf("op : %c\n", op);
                
                for(int j = 0; j < expr.length(); j++) {
                    char ch = expr.charAt(j);
                    System.out.printf("ch : %c\n", ch);
                    if(ch==op) {
                    	System.out.println("op==ch");
                        int[] idx = getBothEndIdx(expr, j);
                        System.out.println("both idx: "+Arrays.toString(idx));
                        String str = expr.substring(idx[0], idx[1]+1);
                        System.out.println("str: "+str);
                        long res = calc(str, j, i);
                        expr = expr.replace(str, Long.toString(res));
                    }
                } // end of for j expr
                
            } // end of for i priority
            
            opIndex = findOpIndex(expr);
        } // end of while
        return Math.abs(Long.parseLong(expr));
    }
    
    /** 연산자의 위치를 중심으로 계산 */
    public static int calc(String expr, int idx, int opIdx) {
        System.out.printf("expr size: %d\n", expr.length());
        int a = Integer.parseInt(expr.substring(0,idx+1));
        int b = Integer.parseInt(expr.substring(idx,expr.length()));
        char op = priority[opIdx];
        if(op=='+') {
            return a+b;
        }else if(op=='-') {
            return a-b;
        }else{
            return a*b;
        }
        
    }
    
    /** op범위의 start,end 인덱스 반환 */
    public static int[] getBothEndIdx(String expr, int idx) {
        int[] res = new int[2];
        System.out.println("getBothEndIdx");
        System.out.printf("expr: %s, idx: %d\n", expr, idx);
        // start 구하기
        for(int i = 1; i <= 3; i++){
        	System.out.printf("idx: %d, i: %d\n", idx, i);
            if(idx-i < 0){
                res[0] = idx-i+1;
                System.out.printf("idx-i (%d)가 0보다 작음 => %d로 고정\n", idx-i,res[0]);
                break;
            }
            char ch = expr.charAt(idx-i);
            System.out.printf("ch: %c\n", ch);
            if(Character.isLetter(ch)){
                res[0] = idx-i+1;
                System.out.printf("start index 찾음 => %d\n", idx-i+1);
                break;
            }
        }
        
        // end 구하기
        for(int i = 1; i <= 3; i++){
            if(idx+i >= expr.length()){
                res[1] = idx+i-1;
                System.out.printf("idx+i (%d)가 expr길이보다 큼 => %d로 고정\n", idx+i,res[1]);
                break;
            }
            char ch = expr.charAt(idx+i);
            if(Character.isLetter(ch)){
                res[1] = idx+i-1;
                System.out.printf("end index 찾음 => %d\n", res[1]);
                break;
            }
        }
        return res;
    }
    
    /** 연산자의 위치만 따로 빼둠 */
    public static int[] findOpIndex(String expr) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < expr.length(); i++) {
            if(expr.charAt(i)=='+' || expr.charAt(i)=='-' || expr.charAt(i)=='*') {
                list.add(i);
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    
    
} // end of class