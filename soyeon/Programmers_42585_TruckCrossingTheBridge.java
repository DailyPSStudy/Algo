package programmers_42585_TruckCrossingTheBridge;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

import programmers_42585_TruckCrossingTheBridge.Solution.Truck;

public class Programmers_42585_TruckCrossingTheBridge {
	static class Truck {
        int time;
        int weight;
        public Truck(int time, int weight) {
            this.weight = weight;
            this.time = time;
        }
    }
    
    public static void main(String[] args) {
		int ans = solution(100, 100, new int[] {10,10,10,10,10,10,10,10,10,10});
		System.out.println(ans);
	}
    
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Deque<Truck> bridge = new LinkedList<>();
        Queue<Integer> wait = new LinkedList<>();
        // array -> queue
        wait = putInQueue(truck_weights);
        // System.out.println(wait.size());
        int time = 0;
        int curWeight = 0;
        // ���� �����µ� 1�� �ɸ��°ų� ���� ������� ...?
        do {
            System.out.printf("%d��\n", time);
            
            // bridge_length�ʸ�ŭ �������� ť���� ����, sec�ʱ�ȭ
            if(bridge.size()!=0 && bridge.peek().time+bridge_length==time) {
                Truck truck = bridge.pollFirst();
                int out = truck.weight;
                System.out.printf("%d ��������\n", out);
                curWeight -= out;
            }
            
            // bridge�� �ƹ��͵� ������ �ֱ�
            if(bridge.size()==0 && wait.size()!=0) {
                int in = wait.poll();
                System.out.printf("���ο� �ƹ��͵� �����Ƿ� %d ��\n", in);
                bridge.add(new Truck(time, in));
                curWeight += in;
            }
            // wait.peek + bridge.pollLast �� weight���� ������ �ֱ�
            else if(wait.size()!=0 && wait.peek()+curWeight <= weight) {
                int in = wait.poll();
                bridge.addLast(new Truck(time, in));
                curWeight += in;
                System.out.printf("%d ��\n", in);
            }
            
            time++;
        } while(bridge.size()!=0); // end of while
        
        return time;
        
    } // end of solution
    
    
    public static Deque<Integer> putInQueue(int[] weights) {
        Deque<Integer> res = new LinkedList<>();
        for(int i = 0; i < weights.length; i++) {
            res.add(weights[i]);
        }
        return res;
    }
}
