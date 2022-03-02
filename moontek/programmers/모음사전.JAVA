class Solution {
    public int solution(String word) {
        int answer = 0;
        int total = 3905 ;//   3905,  781, 156, 31, 6, 1   (*5+1)임
        
        
        
        for(int i=0;i<word.length();i++){
            
            int type = 0;
            if(word.charAt(i)=='A'){
                type=0;
            }
            else if(word.charAt(i)=='E'){
                type=1;
            }
            else if(word.charAt(i)=='I'){
                type=2;
            }
            else if(word.charAt(i)=='O'){
                type=3;
            }
            else {
                type=4;
            }
            total/=5;
            answer += total*type+1;
        }
        return answer;
    }
}