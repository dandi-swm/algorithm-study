package week9.디펜스게임.Vryez11;

import java.util.PriorityQueue;

public class Solution {

    /**
     *
     * [프로그래머스] 디펜스 게임
     *
     * 문제 난이도: Lv2
     * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/142085
     * 풀이 시간: 40분
     * 풀이 근거: temp = sum + enemy[현재 인덱스] 일 때, 작으면 그냥 pq에 현재 적 수 넣고 sum = temp, 크면 pq 보다 큰 지, 작은 지 확인 후 크면 k무적권 쓰고 pq에서 빼고 차 만큼 더하기, 작으면 그냥 K 무적수 쓰기
     */
    public int solution(int n, int k, int[] enemy) {

        int ans = 0;
        int sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for (int i = 0; i < enemy.length; i++) {

            int temp = sum + enemy[i];

            if (temp > n && k == 0) {
                return ans;
            }

            if (temp <= n) {
                pq.offer(enemy[i]);
                sum = temp;
                ans++;
                continue;
            }

            if (!pq.isEmpty() && pq.peek() > enemy[i]) {
                Integer now = pq.poll();
                sum -= (now - enemy[i]);
                pq.offer(enemy[i]);
            }

            k--;
            ans++;
        }

        return ans;
    }
}
