package programmers_17680_Cache;
import java.util.*;
// 2022-03-10 2:45~3:00
class Programmers_17680_Cache {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        boolean DEBUG = false;
        
        Queue<String> q = new LinkedList<>(); // 앞에서부터 순차적으로 빠져나옴
        Set<String> set = new HashSet<>(); // 중복확인용
        int time = 0;
        
        for(int i = 0; i < cities.length; i++) {
            
            String city = cities[i].toLowerCase();
            if(DEBUG) System.out.printf("city : %s\n", city);
            
            if(set.contains(city)) {
                // hit
                time += 1;
                // 캐시hit인 경우 가장 최근 캐시로 업데이트 시킴
                q.remove(city);
                q.add(city);
                if(DEBUG) System.out.printf("[hit] %d\n", time);
                
            } else {
                // miss
                time += 5;
                set.add(city);
                q.add(city);
                // cacheSize 초과하면 q빼주기
                if(q.size() > cacheSize) {
                    String rm = q.poll();
                    set.remove(rm);
                    if(DEBUG) System.out.printf("size 초과, %s 제거\n", rm);
                }
                if(DEBUG) System.out.printf("[miss] %d\n", time);
            }
            
        } // end of for
        
        if(DEBUG) System.out.printf("time : %d\n", time);
        
        return time;
    } // end of soluton
    
    
    
}