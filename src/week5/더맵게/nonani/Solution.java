
/*
## ✏️ [프로그래머스] 더 맵게
📶 문제 난이도
Lv. 2

🔗 문제 링크
https://school.programmers.co.kr/learn/courses/30/lessons/42626

⏱️ 풀이 시간
10분

✅ 풀이 근거
우선 순위큐를 쓰면 쉽게 해결되는 문제였다.

 */

import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int n : scoville) {
            pq.add(n);
        }

        while (pq.peek() < K) {
            if (pq.size() < 2)
                return -1;
            int a = pq.poll();
            int b = pq.poll();
            answer++;

            pq.add(a + b * 2);
        }

        return answer;
    }
}