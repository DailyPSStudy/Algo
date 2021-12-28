package backJoon_1535_Hi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 일    시: 2021-12-25
 * 작 성 자: 유 소 연
 * https://www.acmicpc.net/problem/1535
 * */
public class BackJoon_1535_Hi {
	static int numberOfPeople, maxPleasure;
	static int[] health, happy;
	/**
	 * 냅색 문제
	 * <시간복잡도>
	 * O(2^N)
	 * 최악의경우, N이 20이므로 2^20 = 1000*1000 = 100만
	 * 완탐해도 충분하다.
	 * */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 인사하면 -L 체력, +J 기쁨
		// 최대한의 기쁨느끼기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// numberOfPeople
		numberOfPeople = Integer.parseInt(br.readLine());
		// numberOfPeople개의 health
		health = new int[numberOfPeople+1];
		// numberOfPeople개의 happy
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
		
		// 세준이의 체력은 100, 기쁨은 0
		greeting(100, 0, 1); // 세준이의 체력, 기쁨, 인사할 사람
		System.out.println(maxPleasure);
		
	} // end of main

	private static void greeting(int hp, int pleasure, int i) {
		// 체력이 0이나 음수면 죽어서 아무기쁨도 못느끼게된것
		if(hp <= 0) return;
		if(i >= numberOfPeople+1) {
			if(maxPleasure < pleasure) {
				maxPleasure = pleasure;
			}
			return;
		}
		// i번째 사람에게 인사하는 경우
		greeting(hp-health[i], pleasure+happy[i], i+1);
		// 안하는 경우
		greeting(hp, pleasure, i+1);
	} // end of greeting
} // end of class
