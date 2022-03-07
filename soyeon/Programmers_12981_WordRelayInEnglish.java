package programmers_12981_WordRelayInEnglish;
import java.util.*;
// 2022-03-02 12:25~1:00
class Programmers_12981_WordRelayInEnglish {
    public int[] solution(int n, String[] words) {
        
        // ������ ���Դ� �ܾ ���ϰų� �ǳ�ö�ڷ� �����ϴ� �ܾ ���ϸ� Ż��
        // �ܾ��ߺ�üũ -> set
        // ���° �Ͽ��� �������� �˾Ƴ��� -> n���� ���� ��
        // ���� Ż���ߴ��� -> n���� ���� ������
        boolean DEBUG = false;
        
        int[] ans = new int[2];
        Set<String> set = new HashSet<>();
        String bef = "";
        int turn = 0;
        for(int i = 0; i < words.length; i++) {
            String word = words[i];
            turn++;
            if(DEBUG) System.out.printf("�����ܾ�: %s, ����ܾ�: %s, turn: %d\n", bef, word, turn);
            
            if(!set.contains(word) && !"".equals(bef)
               && bef.charAt(bef.length()-1) == word.charAt(0)) {
                // ��ó�� ���� �ܾ��̰�, �����ܾ��ǳ����� �����ϴ� �ܾ���
                if(DEBUG) System.out.printf("�� ó�� X\n");
                set.add(word);
                bef = word;
            } else if("".equals(bef)) { // �� ó��
                if(DEBUG) System.out.printf("�� ó��\n");
                set.add(word);
                bef = word;
            } else { // �� �ܸ̿� Ż��
                if(DEBUG) System.out.printf("Ż��\n");
                if(DEBUG) System.out.printf("�����ܾ��� ��ö��:%c, ����ܾ��� ����ö��: %c\n",
                                            bef.charAt(bef.length()-1), word.charAt(0));
                if(DEBUG) System.out.println("�ߺ�����: "+set.contains(word));
                int who = turn%n;
                ans[0] = (who == 0) ? n : who;
                ans[1] = (int)Math.ceil((double)turn/n);
                break;
            }
        }
        
        return ans;
    } // end of solution
    
}