package programmers_17680_Cache;
import java.util.*;
// 2022-03-10 2:45~3:00
class Programmers_17680_Cache {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        boolean DEBUG = false;
        
        Queue<String> q = new LinkedList<>(); // �տ������� ���������� ��������
        Set<String> set = new HashSet<>(); // �ߺ�Ȯ�ο�
        int time = 0;
        
        for(int i = 0; i < cities.length; i++) {
            
            String city = cities[i].toLowerCase();
            if(DEBUG) System.out.printf("city : %s\n", city);
            
            if(set.contains(city)) {
                // hit
                time += 1;
                // ĳ��hit�� ��� ���� �ֱ� ĳ�÷� ������Ʈ ��Ŵ
                q.remove(city);
                q.add(city);
                if(DEBUG) System.out.printf("[hit] %d\n", time);
                
            } else {
                // miss
                time += 5;
                set.add(city);
                q.add(city);
                // cacheSize �ʰ��ϸ� q���ֱ�
                if(q.size() > cacheSize) {
                    String rm = q.poll();
                    set.remove(rm);
                    if(DEBUG) System.out.printf("size �ʰ�, %s ����\n", rm);
                }
                if(DEBUG) System.out.printf("[miss] %d\n", time);
            }
            
        } // end of for
        
        if(DEBUG) System.out.printf("time : %d\n", time);
        
        return time;
    } // end of soluton
    
    
    
}