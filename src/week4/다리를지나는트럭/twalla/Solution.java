package week4.다리를지나는트럭.twalla;

// ✏️ 프로그래머스 다리를 지나는 트럭

// 📶 문제 난이도
// Level 2

// 🔗 문제 링크
// https://school.programmers.co.kr/learn/courses/30/lessons/42583

// ⏱️ 풀이 시간
// 30분

// ✅ 풀이 근거
// 다리를 Queue로 추상화해서 해결

import java.util.*;

public class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {

        Queue<Integer> bridge = new LinkedList<>();

        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(-1);
        }

        int sec = 0, done = 0, truckIndex = 0, current_weight = 0;

        while (done < truck_weights.length) {

            sec += 1;
            int bridgeLast = bridge.poll();

            if (bridgeLast != -1) {
                current_weight -= bridgeLast;
                done += 1;
            }

            if (truckIndex == truck_weights.length) {
                continue;
            }

            int truck_weight = truck_weights[truckIndex];
            if (current_weight + truck_weight <= weight) {
                bridge.offer(truck_weight);
                current_weight += truck_weight;
                truckIndex += 1;
            } else {
                bridge.offer(-1);
            }
        }

        return sec;
    }
}