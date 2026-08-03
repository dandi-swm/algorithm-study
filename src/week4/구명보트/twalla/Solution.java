package week4.구명보트.twalla;

// ✏️ 프로그래머스 구명보트

// 📶 문제 난이도
// Level 2

// 🔗 문제 링크
// https://school.programmers.co.kr/learn/courses/30/lessons/42885

// ⏱️ 풀이 시간
// 30분

// ✅ 풀이 근거
// 처음에 보트 하나에 최소 2명인걸 못봐서 가능한 다 때려 넣어서 태움.
// 최소 2명이면 로직이 더 간단해짐. 가장 무거운 사람이 가장 가벼운 사람이랑 함께 탈 수 있는지 확인

import java.util.*;

public class Solution {
    public int solution(int[] people, int limit) {

        Arrays.sort(people);

        Deque<Integer> deq = new ArrayDeque<>();
        for (int i = 0; i < people.length; i++) {
            deq.add(people[i]);
        }

        int cnt = 0;
        while (deq.size() >= 2) {
            int last = deq.pollLast();
            int first = deq.peekFirst();

            if (last + first <= limit) {
                deq.pollFirst();
            }

            cnt += 1;
        }

        if (!deq.isEmpty()) {
            cnt += 1;
        }

        return cnt;
    }
}
