package Programmers;

import java.util.ArrayList;

public class 뉴스클러스터링 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str1 = "e=m*c^2";
		String str2 = "E=M*C^2";
		System.out.println(solution(str1,str2));
	}
    static public int solution(String str1, String str2) {
        int answer = 0;
        
        String nstr1 = str1.toLowerCase();
        String nstr2 = str2.toLowerCase();
        
        int length1 = nstr1.length();
        int length2 = nstr2.length();
        
        if(length1==length2 && length1==0) {
        	return 65536;
        }
        ArrayList<String> str1a = new ArrayList<>();
        for(int i=0;i<length1-1;i++) {
        	int sn = nstr1.charAt(i);
        	int en = nstr1.charAt(i+1);
        	if(sn<97 || sn>122 || en<97 || en>122) {
        		continue;
        	}
        	String word = ""+nstr1.charAt(i) + nstr1.charAt(i+1);
        	str1a.add(word);
        }
        
        int na = str1a.size();
        int nb = 0;
        int mid = 0;
        for(int i=0;i<length2-1;i++) {
        	int sn = nstr2.charAt(i);
        	int en = nstr2.charAt(i+1);
        	if(sn<97 || sn>122 || en<97 || en>122) {
        		continue;
        	}
        	
        	String word = ""+nstr2.charAt(i) + nstr2.charAt(i+1);
        	nb++;
        	int index = -1;
        	for(int j=0;j<str1a.size();j++) {
        		if(str1a.get(j).equals(word)) {
        			mid++;
        			index = j;
        			break;
        		}
        	}
        	if(index!=-1) {
        		str1a.remove(index);
        	}
        }
        if(na==nb&& na==0) {
        	return 65536;
        }
       
        int total = na+nb-mid;
        double q = (double) mid/total * 65536;
        answer = (int) q;
        

        
        // 소문자 97~122
        return answer;
        
        
        
        
    }
}
