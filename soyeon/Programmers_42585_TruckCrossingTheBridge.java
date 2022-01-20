package programmers_42585_TruckCrossingTheBridge;

import java.util.LinkedList;
import java.util.Queue;

import programmers_42585_TruckCrossingTheBridge.Solution.Truck;

public class Programmers_42585_TruckCrossingTheBridge {
	class Truck{
		int weight;
		int startSec;

		public Truck(int weight, int startSec) {
			this.weight = weight;
			this.startSec = startSec;
		}
	}
	
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        /** bridge_length ������ ť */
        Queue<Truck> load = new LinkedList<>();
        int sec = 0; // ��
        int trIdx = 0; // Ʈ�� �ε���
        int curWeight = 0; // ���� ����
        
        while(true) {
        	/** 0��(��ó��)�� �ƴѵ� ť�� ��������� ��� Ʈ���� �� ������ ���̹Ƿ� break */
        	if(load.isEmpty() && sec != 0) break;
        	sec++;
        	
        	/** Ʈ���� ���� ���� �ٸ����� �ʸ�ŭ �־����� �̹� ���������̹Ƿ� ����(ť)���� ������ */
        	if(!load.isEmpty() && sec - load.peek().startSec == bridge_length) { // �ʱ�����϶��� load�� ��������Ƿ� ����üũ ���ش�.
        		curWeight -= load.peek().weight; // ���ο��� �����������Ƿ� ���� ���Կ����� ����
        		load.poll();
        	}
        	
        	/** ���� �ٸ� ���� ���ѹ��������� Ʈ������ ������ ���ο� Ʈ���� �����ش�. */
        	if(load.size() < bridge_length && trIdx < truck_weights.length) {
        		if(!(trIdx > truck_weights.length - 1)) { // trIdx�� �����ʰ����� �ʴ´ٸ�
        			if(curWeight + truck_weights[trIdx] <= weight) { // ���� Ʈ���� ���ο� �ö���� �� �ִ빫�Ը� �Ѿ�� �ʴ��� üũ
        				load.add(new Truck(truck_weights[trIdx], sec));
        				curWeight += truck_weights[trIdx];
        				trIdx++;
        			}
        		}
        	}
        } // end of while
        return sec;
    }
}
