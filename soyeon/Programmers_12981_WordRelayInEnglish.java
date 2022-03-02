package programmers_12981_WordRelayInEnglish;
import java.util.*;
// 2022-03-02 12:25~1:00
class Programmers_12981_WordRelayInEnglish {
    public int[] solution(int n, String[] words) {
        
        // 이전에 나왔던 단어를 말하거나 맨끝철자로 시작하는 단어를 말하면 탈락
        // 단어중복체크 -> set
        // 몇번째 턴에서 끝났는지 알아내기 -> n으로 나눈 몫
        // 누가 탈락했는지 -> n으로 나눈 나머지
        boolean DEBUG = false;
        
        int[] ans = new int[2];
        Set<String> set = new HashSet<>();
        String bef = "";
        int turn = 0;
        for(int i = 0; i < words.length; i++) {
            String word = words[i];
            turn++;
            if(DEBUG) System.out.printf("이전단어: %s, 현재단어: %s, turn: %d\n", bef, word, turn);
            
            if(!set.contains(word) && !"".equals(bef)
               && bef.charAt(bef.length()-1) == word.charAt(0)) {
                // 맨처음 말한 단어이고, 이전단어의끝으로 시작하는 단어라면
                if(DEBUG) System.out.printf("맨 처음 X\n");
                set.add(word);
                bef = word;
            } else if("".equals(bef)) { // 맨 처음
                if(DEBUG) System.out.printf("맨 처음\n");
                set.add(word);
                bef = word;
            } else { // 그 이외면 탈락
                if(DEBUG) System.out.printf("탈락\n");
                if(DEBUG) System.out.printf("이전단어의 끝철자:%c, 현재단어의 시작철자: %c\n",
                                            bef.charAt(bef.length()-1), word.charAt(0));
                if(DEBUG) System.out.println("중복여부: "+set.contains(word));
                int who = turn%n;
                ans[0] = (who == 0) ? n : who;
                ans[1] = (int)Math.ceil((double)turn/n);
                break;
            }
        }
        
        return ans;
    } // end of solution
    
}