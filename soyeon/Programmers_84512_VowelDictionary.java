package programmers_84512_VowelDictionary;
import java.util.*;

// 2022-03-01 1:06~1:13
// 중복조합

class Programmers_84512_VowelDictionary {
    static int cnt, ans;
    static boolean flag;
    static char[] alpha = {'A','E','I','O','U'};
    
    public int solution(String word) {
        cnt = 0;
        ans = 0;
        flag = false;
        // dfs로 모든 중복조합을 구하며 word가 나타나면 즉시 cnt return
        dfs(0, "", word); // depth, str, word
        
        return ans;
    } // end of solution
    
    
    public void dfs(int depth, String str, String word) {
        if(word.equals(str)) {
            ans = cnt;
            flag = true;
            return;
        }
        if(depth == 5) {
            return;
        }
        
        for(int i = 0; i < 5; i++) {
            cnt++;
            dfs(depth+1, str+alpha[i], word);
            if(flag) return;
        }
        
    } // end of dfs
    
} // end of class