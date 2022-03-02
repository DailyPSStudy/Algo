package programmers_76502_RotateBracket;
import java.util.*;
// 2022-03-01 4:44~5:26
// 이건.. q로 푸는게 아니다. 리스트로 푸는거다...
class Programmers_76502_RotateBracket {
    static ArrayList<Character> brc;
    static boolean DEBUG;
    
    public int solution(String s) {
        
        // s를 brc로 옮기기
        init(s);
        
        int cnt = 0;
        for(int i = 0; i < s.length(); i++) { // s길이만큼 회전
            if(DEBUG) print();
            if(isRight()) { // 현재 brc가 온전하냐
                // 온전하다면 카운트
                if(DEBUG) System.out.println("is Right");
                cnt++;
            }
            // 괄호 회전
            rotate();
        }
        
        return cnt;
    } // end of solution
    
    
    public boolean isRight() {
        Stack<Character> stack = new Stack<>();
        stack.push(brc.get(0)); // 처음쌓음
        for(int i = 1; i < brc.size(); i++) {
            char cur = brc.get(i);
            if(stack.size()!=0 && stack.peek()=='(' && cur==')') {
                stack.pop();
            } else if(stack.size()!=0 && stack.peek()=='{' && cur=='}') {
                stack.pop();
            } else if(stack.size()!=0 && stack.peek()=='[' && cur==']') {
                stack.pop();
            } else {
                stack.push(brc.get(i));
            }
            
        }
        if(stack.size() == 0) return true;
        else return false;
    }
    
    public void rotate() {
        char ch = brc.get(0);
        brc.remove(0);
        brc.add(ch);
    }
    
    public void init(String s) {
        brc = new ArrayList<>();
        for(int i = 0; i < s.length(); i++) {
            brc.add(s.charAt(i));
        }
    }
    
    public void print() {
        // print brc
        for(int i = 0; i < brc.size(); i++) {
            System.out.print(brc.get(i));
        }
        System.out.println();
    }
    
} // end of class