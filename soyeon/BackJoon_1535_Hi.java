package backJoon_1535_Hi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ��    ��: 2021-12-25
 * �� �� ��: �� �� ��
 * https://www.acmicpc.net/problem/1535
 * */
public class BackJoon_1535_Hi {
	static int numberOfPeople, maxPleasure;
	static int[] health, happy;
	/**
	 * ���� ����
	 * <�ð����⵵>
	 * O(2^N)
	 * �־��ǰ��, N�� 20�̹Ƿ� 2^20 = 1000*1000 = 100��
	 * ��Ž�ص� ����ϴ�.
	 * */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// �λ��ϸ� -L ü��, +J ���
		// �ִ����� ��ݴ�����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// numberOfPeople
		numberOfPeople = Integer.parseInt(br.readLine());
		// numberOfPeople���� health
		health = new int[numberOfPeople+1];
		// numberOfPeople���� happy
		happy = new int[numberOfPeople+1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= numberOfPeople; i++) {
			health[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= numberOfPeople; i++) {
			happy[i] = Integer.parseInt(st.nextToken());
		}
		// end of input
		
		// �������� ü���� 100, ����� 0
		greeting(100, 0, 1); // �������� ü��, ���, �λ��� ���
		System.out.println(maxPleasure);
		
	} // end of main

	private static void greeting(int hp, int pleasure, int i) {
		// ü���� 0�̳� ������ �׾ �ƹ���ݵ� �������ԵȰ�
		if(hp <= 0) return;
		if(i >= numberOfPeople+1) {
			if(maxPleasure < pleasure) {
				maxPleasure = pleasure;
			}
			return;
		}
		// i��° ������� �λ��ϴ� ���
		greeting(hp-health[i], pleasure+happy[i], i+1);
		// ���ϴ� ���
		greeting(hp, pleasure, i+1);
	} // end of greeting
} // end of class
