package programmers_60057_StringCompression;

import java.util.*;

class Programmers_60057_StringCompression {
    class Info {
        String str;
        int len;
        public Info(String str, int len){
            this.str = str;
            this.len = len;
        }
    }
    public int solution(String s) {
        // 2중반복문 안됨
        // s를 바라보며 n개씩 temp에 쌓으며 카운트를 세서 큐에 3a 이렇게 담는다
        List<Info> list = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){ // i개 묶음
            String bef = "";
            int cnt = 1;
            String ans = "";
            int size = s.length()/(i+1);
            if(s.length()%(i+1)!=0) size++;
            for(int j = 0; j < size; j++){
                int start = i*j+j;
                int end = start+i+1;
                if(end > s.length()){
                    end = s.length();
                }
                // System.out.printf("start:%d / end:%d\n", start, end);
                if(bef.equals(s.substring(start,end))){
                    // 일치하면 cnt증가
                    cnt++;
                    // System.out.printf("이전과 일치, cnt:%d\n", cnt);
                }else{
                    // 일치하지 않으면 ans에 담기
                    if(cnt == 1){
                        ans += bef;
                    }else{
                        ans = ans+Integer.toString(cnt)+bef;
                        cnt = 1;
                    }
                    bef = s.substring(start,end);
                    // System.out.printf("이전과 불일치, ans:%s\n", ans);
                }
            } // end of for j
            if(cnt != 1){
                ans = ans+Integer.toString(cnt)+bef;
                // System.out.printf("마지막에서 여러번겹치는요소일때 ans:%s\n", ans);
            }else{
                ans += bef;
                // System.out.printf("마지막에서 여러번겹치지않을때 ans:%s\n", ans);
            }
            list.add(new Info(ans, ans.length()));
            // System.out.printf("▶ %d개 묶음 >> list에 넣은 ans:%s\n", (i+1), ans);
        } // end of for i
        
        // list에 문자열과 문자열길이가 담겨있음
        Collections.sort(list, new Comparator<Info>(){
           @Override
            public int compare(Info o1, Info o2){
                return o1.len - o2.len; // 오름차순
            }
        });
        return list.get(0).len;
    } // end of solution
} // end of class