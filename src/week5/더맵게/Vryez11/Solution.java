package week5.더맵게.Vryez11;

import java.util.PriorityQueue;

public class Solution {

    /**
     *
     * [프로그래머스] 더 맵게
     *
     * 문제 난이도: Lv.2
     * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42626
     * 풀이 시간: 15분
     * 풀이 근거: PriorityQueue를 이용해서 가장 낮은 스코빌, 2번째 스코빌 찾아서 계산해서 넣기
     */
    public int solution(int[] scoville, int K) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int food : scoville) {

            pq.add(food);
        }

        int count = 0;
        while (!pq.isEmpty() && pq.peek() < K) {

            if (pq.size() < 2) {

                return -1;
            }

            count++;
            int small = pq.poll();
            int mid = pq.poll();

            pq.add(small + mid * 2);
        }

        return count;
    }
}
