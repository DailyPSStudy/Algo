package programmers_76502_RotateBracket;
import java.util.*;
// 2022-03-01 4:44~5:26
// �̰�.. q�� Ǫ�°� �ƴϴ�. ����Ʈ�� Ǫ�°Ŵ�...
class Programmers_76502_RotateBracket {
    static ArrayList<Character> brc;
    static boolean DEBUG;
    
    public int solution(String s) {
        
        // s�� brc�� �ű��
        init(s);
        
        int cnt = 0;
        for(int i = 0; i < s.length(); i++) { // s���̸�ŭ ȸ��
            if(DEBUG) print();
            if(isRight()) { // ���� brc�� �����ϳ�
                // �����ϴٸ� ī��Ʈ
                if(DEBUG) System.out.println("is Right");
                cnt++;
            }
            // ��ȣ ȸ��
            rotate();
        }
        
        return cnt;
    } // end of solution
    
    
    public boolean isRight() {
        Stack<Character> stack = new Stack<>();
        stack.push(brc.get(0)); // ó������
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