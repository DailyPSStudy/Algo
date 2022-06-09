import java.io.*;
import java.util.*;

public class PPAP {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		Stack<Character> s = new Stack<>();
		for(int i=0;i<line.length();i++) {
			Iterator it = s.iterator();

			char k = line.charAt(i);
			if(k=='P') {  //P가 나오면 검증할필요없고 A일때만 검증해주고 스택에 담아주자 
				s.add(k);
				continue;
			}
			
			if(i==0 || i == line.length()-1) { // 처음부터 A로 시작하거나 맨마지막에 A가 나오면 되돌릴수없다.
				s.add('a');
				break;
			}
			
			
			if(s.size()<2 || line.charAt(i+1)!='P'){ // PPAP 삭제 불가  CASE 1 ,2  |  앞에 2글자없는경우 혹은 뒷글자가 P가 아닐경우
				s.add('a');
				break;
			}
			char prevc1 = s.pop();
			char prevc2 = s.pop();
			
			if(prevc1!='P' || prevc2 != 'P') { // CASE 3 : 앞두글자가 PP가 아닌경우
				s.add('a');
				break;
			}
			s.add('P');
			i = i+1;
		}
		
		String answer = "NP";
		if(s.size()==1 && line.length()>=4) {
			char cur = s.pop();
			if(cur=='P') {
			answer = "PPAP";
			}
		}
		
		if(line.equals("P")) {
			answer = "PPAP";
		}
		System.out.println(answer);
		
	}

}
