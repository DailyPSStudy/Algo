package programmers_42746_biggestNumber;

import java.util.Arrays;
import java.util.Comparator;

/** 
 * 	��  ��  ��: �� �� ��
 *  ��       ��: 2022-01-10
 *  ���� ���: ���ڸ��� ū ���ڱ������� ���� �� ����
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
				return (o2 + o1).compareTo(o1 + o2); //(o1 + o2).compareTo(o2 + o1) ���� �ٸ� ���
			}
		});
		
		return "0".equals(strArr[0]) ? strArr[0] : String.join("", strArr);
	}
}
