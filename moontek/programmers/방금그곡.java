import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        String newm = "";
        
        // A# Q  C# W D# R  F# Y G# U
        
       newm =  m.replace("C#","W")
           .replace("D#","R")
           .replace("F#","Y")
           .replace("G#","U")
           .replace("A#","Q")
           .replace("E#","i");
        
        int mmax = -1;
        
       
        for(int i=0;i<musicinfos.length;i++){
           String line = musicinfos[i];
          String[] array = line.split(",");
            array[3]=  array[3].replace("C#","W")
           .replace("D#","R")
           .replace("F#","Y")
           .replace("G#","U")
           .replace("A#","Q")
            .replace("E#","i");
          String[] start = array[0].split(":");
          String[] end = array[1].split(":");
            int sh = Integer.parseInt(start[0]);
            int sm = Integer.parseInt(start[1]);
            int eh = Integer.parseInt(end[0]);
            int em = Integer.parseInt(end[1]);
         int total = (eh*60+em) - (sh*60+sm);
            if(mmax>=total) continue; //플레이시간보다적을경우
            String realine = "";
            for(int j=0;j<total;j++){
                 realine += array[3].charAt(j%(array[3].length()));
            }
            if(realine.contains(newm)){
                mmax = total;
                answer = array[2];
            }
            
        }
        
        return answer;
    }
}