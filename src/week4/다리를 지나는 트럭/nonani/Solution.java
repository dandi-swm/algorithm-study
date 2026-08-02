/*
## ✏️ [프로그래머스] 다리를 지나는 트럭
📶 문제 난이도
Lv. 2

🔗 문제 링크
https://school.programmers.co.kr/learn/courses/30/lessons/42583

⏱️ 풀이 시간
40분
✅ 풀이 근거
큐를 사용하면 되겠다 생각은 했는데 문제가 너무 이해가 안되어서 세부조건을 놓쳐서 시간이 오래걸림

*/

import java.util.*;

class Truck {
    int exitTime; // 다리에서 빠져나가는 시각
    int weight;

    public Truck(int exitTime, int weight) {
        this.exitTime = exitTime;
        this.weight = weight;
    }
}

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        ArrayDeque<Truck> bridge = new ArrayDeque<>();

        int time = 0;
        int currentWeight = 0;

        for (int truckWeight : truck_weights) {
            // 앞 트럭이 들어간 시각보다 최소 1초 뒤에 들어갈 수 있음
            int enterTime = time + 1;

            while (true) {
                // enterTime까지 다리를 빠져나간 트럭들 다 큐에서 제거
                while (!bridge.isEmpty()
                        && bridge.peek().exitTime <= enterTime) {

                    currentWeight -= bridge.poll().weight;
                }

                boolean hasSpace = bridge.size() < bridge_length;

                boolean canSupportWeight = currentWeight + truckWeight <= weight;

                if (hasSpace && canSupportWeight) {
                    break;
                }

                // 지금 못 들어간다면 앞 트럭이 나갈 때의 시간으로
                enterTime = bridge.peek().exitTime;
            }

            int exitTime = enterTime + bridge_length;

            bridge.offer(new Truck(exitTime, truckWeight));
            currentWeight += truckWeight;
            time = enterTime;
        }

        return time + bridge_length;
    }
}