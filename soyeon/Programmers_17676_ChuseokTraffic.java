package programmers_17676_ChuseokTraffic;
import java.util.*;
// https://gre-eny.tistory.com/133
class Programmers_17676_ChuseokTraffic {
    public int solution(String[] lines) {
        int answer = 0;
        // Ư�� 1�ʿ��� ���ÿ� ����Ǵ� Ʈ������ �ִ� ����� ã�ƾ� ��
        // ������ �Ϸ� 24�õ����� ������ ������ ũ�� ������ �̴� �Ұ���.
        // ���� Ʈ���Ȱ����� '��ȭ'�� �̷����� � �κи� �˻��ϸ� ��
        // ���۽ð�~���۽ð�+1.0s : ���۽ð� ���� Ʈ���� ������ 1 �����ϹǷ�
        // ����ð�~����ð�+1.0s : ����ð� ���� Ʈ���� ������ 1 �����ϹǷ�
        // ��, �� �ΰ�����쿡 ��� Ʈ������ �����ϴ��� �˻��ϰ� ���� �ִ밪�� ã���� ��
        int[] start = new int[lines.length];
        int[] end = new int[lines.length];
        for(int i = 0; i < lines.length; i++){
            String[] log = lines[i].split(" ");
            String[] time = log[1].split(":");
            // ���۽ð�: ����ð�-ó���ð�+1s
            // ó���ð�: ms*1000
            int process = (int)(Double.parseDouble(log[2].substring(0, log[2].length()-1))*1000);
            end[i] = (int)(((Double.parseDouble(time[0])*3600) + (Double.parseDouble(time[1])*60) + Double.parseDouble(time[2]))*1000);
            start[i] = end[i]-process+1;
        }
        // end of start, end time
        int len = lines.length;
        int max = 0;
        for(int i = 0; i < len; i++){
            int startT = start[i]+1000; // +1s
            int endT = end[i]+1000;
            int cnt = 0;
            // ���� ������ �����ϴ� ��û�� ���� ī��Ʈ
            cnt = getCount(start, end, len, startT, 0, start[i], i);
            max = Math.max(cnt, max);
            cnt = getCount(start, end, len, endT, 0, end[i], i);
            max = Math.max(cnt, max);
        }
        return max;
    } // end of solution
    
    private int getCount(int[] start, int[] end, int len, int startT, int cnt, int cur, int i){
        // ������ �α׿� ���� (���۽ð�~���۽ð�+1.0s), (����ð�~����ð�+1.0s)�� � Ʈ������ �ִ��� ī��Ʈ
        for(int j = 0; j < len; j++){
            if((start[j]<=cur && startT<=end[j]) || (cur<=start[j] && start[j]<startT) || (cur<=end[j]&&end[j]<startT)){
                cnt++;
            }
        }
        return cnt;
    } // end of getCount
} // end of class