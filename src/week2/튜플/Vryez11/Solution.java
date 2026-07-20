package week2.튜플.Vryez11;

import java.util.*;

public class Solution {

    /**
     *
     * [프로그래머스] 튜플
     * <p>
     * 문제 난이도: Lv. 2
     * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/64065
     * 풀이 시간: 10분
     * 풀이 근거: 배열의 크기 정렬
     */

    public int[] solution(String s) {

        s = s.substring(2, s.length() - 2);

        String[] arr = s.split("\\},\\{");

        Arrays.sort(arr, (a, b) -> Integer.compare(a.length(), b.length()));

        List<Integer> answer = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for (String str : arr) {
            String[] nums = str.split(",");

            for (String num : nums) {

                int value = Integer.parseInt(num);

                if(!set.contains(value)) {
                    set.add(value);
                    answer.add(value);
                }
            }
        }

        return answer.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}
