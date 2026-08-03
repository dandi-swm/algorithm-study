package week4.두큐합같게만들기;

// ✏️ 프로그래머스 두 큐 합 같게 만들기

// 📶 문제 난이도
// Level 2

// 🔗 문제 링크
// https://school.programmers.co.kr/learn/courses/30/lessons/118667

// ⏱️ 풀이 시간
// 20분

// ✅ 풀이 근거
// 간단히 큐로 해결함.
// 다만 while문을 빠져나오는 조건을 고민했었는데,
// 일단 두 큐의 길이가 같고, q1의 제일 앞 원소가 q2로 갔다가 다시 q1의 제일 앞자리로 돌아오기까지의 시간이 4 * N이라고 판단

import java.util.*;

public class Solution {
    public int solution(int[] queue1, int[] queue2) {

        int N = queue1.length;
        long sum1 = 0, sum2 = 0;

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            sum1 += queue1[i];
            sum2 += queue2[i];

            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }

        if (sum1 == sum2) {
            return 0;
        }

        int answer = 0;
        while (answer < 4 * N) {

            if (sum1 < sum2) {
                int elem = q2.poll();
                q1.offer(elem);
                sum1 += elem;
                sum2 -= elem;
            } else if (sum1 > sum2) {
                int elem = q1.poll();
                q2.offer(elem);
                sum1 -= elem;
                sum2 += elem;
            } else {
                return answer;
            }

            answer += 1;
        }

        return -1;
    }
}