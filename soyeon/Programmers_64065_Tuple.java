package programmers_64065_Tuple;
import java.util.*;
/**
 * 일    시: 2022-01-04
 * 작 성 자: 유 소 연
 * https://programmers.co.kr/learn/courses/30/lessons/64065
 * */
class Solution {
	 public int[] solution(String s) {
	     // replace로 { } 다 없애버림
	     s = s.replace("{", "");
	     s = s.replace("}", "");
	     
	     // , 만 남으면 charAt 으로 읽으며 수만 map에 주워담음. 개수도 셈.
	     Map<Integer, Integer> map = new HashMap<>();
	     map = putInMap(s);
	     
	     // 내림차순정렬을 위해 리스트에 옮김
	     List<int[]> list = new ArrayList<>();
	     list = putInList(map);
	     
	     // 개수 기준 내림차순
	     Collections.sort(list, new Comparator<int[]>(){
	        @Override
	         public int compare(int[] o1, int[] o2) {
	             return o2[1] - o1[1];
	         }
	     });
	     
	     // 배열로 담음
	     int[] ans = new int[list.size()];
	     for(int i = 0; i < list.size(); i++) {
	         ans[i] = list.get(i)[0];
	     }
	     
	     return ans;
	 } // end of solution
	 
	 
	 /** s -> map */
	 public Map<Integer, Integer> putInMap (String s) {
	     Map<Integer, Integer> map = new HashMap<>();
	     
	     // s 에서 , 기준으로 숫자만 담음
	     String[] numbers = s.split(",");
	     
	     for(int i = 0; i < numbers.length; i++) {
	         int key = Integer.parseInt(numbers[i]);
	         if(map.size()==0) {
	             map.put(key, 1);
	         } else if(map.containsKey(key)) {
	             int value = map.get(key);
	             map.put(key, value+1);
	         } else {
	             map.put(key, 1);
	         }
	     }
	     return map;
	 } // end of putInMap
	 
	 
	 /** map -> list */
	 public List<int[]> putInList(Map<Integer, Integer> map) {
	     List<int[]> list = new ArrayList<>();
	     for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
	         list.add(new int[]{entry.getKey(), entry.getValue()});
	     }
	     return list;
	 }
}