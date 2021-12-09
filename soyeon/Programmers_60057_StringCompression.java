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
        // 2�߹ݺ��� �ȵ�
        // s�� �ٶ󺸸� n���� temp�� ������ ī��Ʈ�� ���� ť�� 3a �̷��� ��´�
        List<Info> list = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){ // i�� ����
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
                    // ��ġ�ϸ� cnt����
                    cnt++;
                    // System.out.printf("������ ��ġ, cnt:%d\n", cnt);
                }else{
                    // ��ġ���� ������ ans�� ���
                    if(cnt == 1){
                        ans += bef;
                    }else{
                        ans = ans+Integer.toString(cnt)+bef;
                        cnt = 1;
                    }
                    bef = s.substring(start,end);
                    // System.out.printf("������ ����ġ, ans:%s\n", ans);
                }
            } // end of for j
            if(cnt != 1){
                ans = ans+Integer.toString(cnt)+bef;
                // System.out.printf("���������� ��������ġ�¿���϶� ans:%s\n", ans);
            }else{
                ans += bef;
                // System.out.printf("���������� ��������ġ�������� ans:%s\n", ans);
            }
            list.add(new Info(ans, ans.length()));
            // System.out.printf("�� %d�� ���� >> list�� ���� ans:%s\n", (i+1), ans);
        } // end of for i
        
        // list�� ���ڿ��� ���ڿ����̰� �������
        Collections.sort(list, new Comparator<Info>(){
           @Override
            public int compare(Info o1, Info o2){
                return o1.len - o2.len; // ��������
            }
        });
        return list.get(0).len;
    } // end of solution
} // end of class