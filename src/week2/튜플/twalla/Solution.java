// ✏️ 프로그래머스 섬 연결하기

// 📶 문제 난이도
// Level 2

// 🔗 문제 링크
// https://school.programmers.co.kr/learn/courses/30/lessons/64065

// ⏱️ 풀이 시간
// 30분

// ✅ 풀이 근거
// 문자열 파싱이 굉장히 귀찮았던 문제

package week2.튜플.twalla;

import java.util.*;

public class Solution {
    public int[] solution(String s) {

        PriorityQueue<List<Integer>> tuples = new PriorityQueue<>((o1, o2) -> {
            return o1.size() - o2.size();
        });

        int start = 1;
        int cnt = 0;
        while (start < s.length() - 1) {

            if (s.charAt(start) != '{') {
                start += 1;
                continue;
            }

            int end = start;
            while (s.charAt(end) != '}') {
                end += 1;
            }

            String[] scope = s.substring(start + 1, end).split(",");

            List<Integer> tuple = new ArrayList<>();
            for (String elem : scope) {
                tuple.add(Integer.parseInt(elem));
            }

            tuples.add(tuple);
            cnt += 1;

            start = end;
        }

        Set<Integer> set = new HashSet<>();
        int[] answer = new int[cnt];

        for (int i = 0; i < cnt; i++) {
            List<Integer> tuple = tuples.poll();
            for (int j = 0; j < tuple.size(); j++) {
                int elem = tuple.get(j);
                if (set.contains(elem)) {
                    continue;
                }
                answer[i] = elem;
                set.add(elem);
                break;
            }
        }

        return answer;
    }
}
