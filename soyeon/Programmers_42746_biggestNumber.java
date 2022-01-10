package programmers_42746_biggestNumber;

import java.util.Arrays;
import java.util.Comparator;

/** 
 * 	작  성  자: 유 소 연
 *  일       시: 2022-01-10
 *  접근 방법: 앞자리가 큰 숫자기준으로 정렬 후 조합
 *  https://programmers.co.kr/learn/courses/30/lessons/42746
 *  */
public class Programmers_42746_biggestNumber {
	public String solution(int[] numbers) {
		
		String[] strArr = new String[numbers.length];
		for (int i = 0; i < strArr.length; i++) {
			strArr[i] = String.valueOf(numbers[i]);
		}
		
		Arrays.sort(strArr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return (o2 + o1).compareTo(o1 + o2); //(o1 + o2).compareTo(o2 + o1) 서로 다른 결과
			}
		});
		
		return "0".equals(strArr[0]) ? strArr[0] : String.join("", strArr);
	}
}
