import java.util.*;

class Solution {
    public int[] solution(String msg) {

        HashMap<String,Integer> h = new HashMap<>();
        char cur = 'A';
        for(int i=1;i<27;i++){
            String current = ""+cur;
            h.put(current,i);
            cur+=1;
        }
        int cindex = 27;
        LinkedList<Integer> k = new LinkedList<>();
        for(int i=0;i<msg.length();i++){
            
            String line = "";
            boolean flag = false;
            for(int j=i;j<msg.length();j++){
                String newline = line +"" + msg.charAt(j);
                int find = h.getOrDefault(newline,-1);
                if(find==-1){ //등록안된문자임
                    k.add(h.get(line));
                    h.put(newline,cindex);
                    cindex++;
                    flag = true;
                    i=j-1;
                    break;
                }
                line=newline;
            }          
                if(!flag){ //끝까지 간경우임
                    k.add(h.get(line));
                    break;
                }
        }
        int[] answer = new int[k.size()];
        for(int a=0;a<k.size();a++){
           answer[a] = k.get(a);
        }
        return answer;
    }
}