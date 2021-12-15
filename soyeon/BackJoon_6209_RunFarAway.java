package backJoon_6209_RunFarAway;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * ��    ��: 2021-12-14
 * �� �� ��: �� �� ��
 * https://www.acmicpc.net/problem/6209
 * */
public class BackJoon_6209_RunFarAway {
	static int d, n, m;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		// ���� ���� m���� ������, �����ϴ� �ּҰŸ��� �ִ��� ���϶�
		// ������ ���� 5�������̹Ƿ� ����... �ȵɰŰ�����;;; �׷��� ��2����..����
		// m�� ���ٸ������� �ּҰŸ��� �ΰ�, ������ Ž���ϸ� �� �ּҰŸ��� �ǳʶ� �� �ִ� ���ǰ����� üũ
		// �� ������ �Ųٷ� Ǭ��.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// �������κ��� Ż�ⱸ������ �Ÿ� d, ���������� �� n, �����Ҽ��ִ� �����Ǽ� m
		d = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n+2];
		// n���� ������
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		// end of input
		
		arr[n+1] = d;
		Arrays.sort(arr); // �̺�Ž���� ���� ����
		int left = 0;
		int right = d;
		int ans = 0;
		while(left <= right) {
			int mid = (left+right)/2;
			int pos = 0, cnt = 0;
			for (int i = 1; i <= n+1; i++) {
				if(arr[i] - arr[pos] < mid) {
					cnt++;
				} else {
					pos = i;
				}
			}
			
			if(cnt > m) {
				// cnt�� �����Ҽ��ִ� ���� ������ ���ٸ�
				right = mid-1;
			} else {
				// cnt�� �����Ҽ��ִ� ���� ������ ���ų� ������
				left = mid+1;
				ans = mid;
			}
		} // end of while
		System.out.println(ans);
	} // end of main
} // end of class
