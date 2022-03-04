import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int pindex = 0;
        int rindex = 0;
        Map<String,Integer> map=new HashMap();
        
        for(int i=0;i<words.length;i++){
        if(!map.containsKey(words[i])){ //키중복이아닌경우
            map.put(words[i],1);
            if(i==0) continue; // 첫번째일경우 무조건 통과
            int pl = words[i-1].length();
            // 첫번쨰가아니나 끝말잇기가 되면통과
             if(words[i-1].charAt(pl-1)==words[i].charAt(0)) continue;
                }
                pindex = i%n+1;
                rindex =  (i/n)+1;
                break;
        }
        answer[0] = pindex;
        answer[1] = rindex;

        return answer;
    }
}