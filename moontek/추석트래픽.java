package Programmers;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class 추석트래픽 {

	static class Traffic{
		long start;
		long end;
		
		public Traffic(long start, long end) {
			this.start = start;
			this.end = end;
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] line = new String[] {
				"2016-09-15 01:00:04.001 2.0s",
				"2016-09-15 01:00:07.000 2s"
		};
		System.out.println(solution(line));
	}
	 public static int solution(String[] lines) {
		 
		 StringTokenizer st;
		 //하루는 86400초
		 ArrayList<Traffic> tarray = new ArrayList<>();
		 for(int i=0;i<lines.length;i++) {
			st= new StringTokenizer(lines[i]);
			
			
			String day = st.nextToken();
			String time = st.nextToken();
			String length = st.nextToken().replace("s", "");
			st = new StringTokenizer(day,"-");
			st.nextToken();
			st.nextToken();
			int realday = Integer.parseInt(st.nextToken())-14; 
			int realtimesec = 0;
			realtimesec = realday*86400*1000;
			
			//-- 날짜 계산 끗
			
			
			st= new StringTokenizer(time,":");
			int hour = Integer.parseInt(st.nextToken());
			int min =  Integer.parseInt(st.nextToken());
			double sec =  Double.parseDouble(st.nextToken());
			
			
			sec += hour*3600+min*60;
			
			double timelength = Double.parseDouble(length)-0.001;
			double startsec = sec-timelength;
			
			long ssec = (long) (startsec*1000); 
			long esec = (long) (sec*1000);
			
			ssec += realtimesec;
			esec += realtimesec;

			if(esec<86400000) {
				
			}
			else {
				
				if(ssec<86400000) {
					ssec = 86400000;
				}
				if(esec>(86400000*2)) // 작업기간이 16일넘어가는경우
				{
					esec = (86400000*2)-1001;  //23시 59분 58초 999 로바꿈 그러면 end max가 59.999로 맞춰짐   
				}
				tarray.add(new Traffic(ssec,esec));
			}
			System.out.println(ssec + " ~ "+ esec);
		 }
		 
		 int max = 0;
		 int a=0;
		 for(Traffic current : tarray) {
			 a++;
			 long start = current.start;
			 long end = current.end;
			
			 
			 // start 기준으로 + 1 체크하기 
			 int checktraffic = 0;
			 for(int i=0;i<tarray.size();i++) {
				 long tstart = tarray.get(i).start;
				 long tend = tarray.get(i).end;
				 // case 1 . s~s+1 사이에 tstart가있는경우
				 if(start<=tstart && start+999>=tstart) {

					 checktraffic++;
				 }
				 else if(start<=tend && start+999>= tend) {
					 checktraffic++;
				 }
				 else if(tstart<=start && tend>= start+999) {
					 checktraffic++;
				 }
			 }
			 max = Math.max(max, checktraffic);
			 checktraffic = 0;
			 
			 for(int i=0;i<tarray.size();i++) {
				 long tstart = tarray.get(i).start;
				 long tend = tarray.get(i).end;
				 // case 1 . s~s+1 사이에 tstart가있는경우
				 if(end<=tstart && end+999>=tstart) {
					 
					 checktraffic++;
				 }
				 else if(end<=tend && end+999>= tend) {
					 checktraffic++;
				 }
				 else if(tstart<=end && tend>= end+999) {
					 checktraffic++;
				 }
			 }
			 max = Math.max(max, checktraffic);
			 checktraffic = 0;
			 // end 기준으로 +1 체크하기
		 }
		 
		 
		 
	        int answer = max;
	        return max;
	    }

}
