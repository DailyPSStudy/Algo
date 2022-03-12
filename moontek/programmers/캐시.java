import java.util.*;
class Solution {
   
    public int solution(int cacheSize, String[] cities) {
        
       if (cacheSize==0) return cities.length*5;
        int answer = 0;
        LinkedList<String> l = new LinkedList<>();
        for(String now : cities){
            String rnow = now.toLowerCase();
            if(l.size()==0){
                answer+=5;
                l.add(rnow);
                continue;
            }
            if(l.contains(rnow)){ //hit
                int rindex = l.indexOf(rnow);
                l.remove(rindex);
                l.add(rnow);
                answer++;
                continue;
            }
            // miss
            if(l.size()<cacheSize){
                l.add(rnow);
            }
            else {
                l.remove();
                l.add(rnow);
            }
            answer+=5;
        }
        
        return answer;
    }
}