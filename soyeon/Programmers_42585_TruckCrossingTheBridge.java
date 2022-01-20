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
        /** bridge_length 사이즈 큐 */
        Queue<Truck> load = new LinkedList<>();
        int sec = 0; // 초
        int trIdx = 0; // 트럭 인덱스
        int curWeight = 0; // 현재 무게
        
        while(true) {
        	/** 0초(맨처음)가 아닌데 큐가 비어있으면 모든 트럭이 다 지나간 것이므로 break */
        	if(load.isEmpty() && sec != 0) break;
        	sec++;
        	
        	/** 트럭이 도로 위에 다리길이 초만큼 있었으면 이미 지나간것이므로 도로(큐)에서 빼낸다 */
        	if(!load.isEmpty() && sec - load.peek().startSec == bridge_length) { // 초기상태일때도 load는 비어있으므로 조건체크 해준다.
        		curWeight -= load.peek().weight; // 도로에서 빠져나갔으므로 현재 무게에서도 빼냄
        		load.poll();
        	}
        	
        	/** 현재 다리 위에 제한무게이하의 트럭들이 있으면 도로에 트럭을 더해준다. */
        	if(load.size() < bridge_length && trIdx < truck_weights.length) {
        		if(!(trIdx > truck_weights.length - 1)) { // trIdx가 범위초과하지 않는다면
        			if(curWeight + truck_weights[trIdx] <= weight) { // 다음 트럭이 도로에 올라왔을 시 최대무게를 넘어가지 않는지 체크
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
