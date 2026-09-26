package week9.디펜스게임.twalla;

import java.util.*;

/*
## ✏️ [프로그래머스] 디펜스 게임

📶 문제 난이도
Lv. 2

🔗 문제 링크
https://school.programmers.co.kr/learn/courses/30/lessons/142085

⏱️ 풀이 시간
20분

✅ 풀이 근거
처음엔 좀 어렵게 생각해서 헤맸는데, 조금 더 생각해보니, 현재까지 탐색한 데이터의 순서는 전혀 상관없이 정렬되어 있으면 무적권을 쓸 수 있겠다고 판단
따라서 PQ로 간단하게 해결.

*/

public class Solution {
    public int solution(int n, int k, int[] enemies) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            return o2 - o1;
        });
        int sum = 0;

        for (int i = 0; i < enemies.length; i++) {

            int enemy = enemies[i];
            pq.add(enemy);
            sum += enemy;

            while (!pq.isEmpty() && sum > n && k > 0) {
                sum -= pq.poll();
                k -= 1;
            }

            if (sum > n && k == 0) {
                return i;
            }
        }

        return enemies.length;
    }
}
