package week4.구명보트.Vryez11;

import java.util.Arrays;

public class Solution {

    /**
     *
     * [프로그래머스] 구명보트
     *
     * 문제 난이도: Lv. 2
     * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42885?language=java
     * 풀이 시간: 1시간 30분
     * 풀이 근거: 아 이거 최대 2명인줄 모르고 아ㅏㅏㅏㅏㅏㅏㅏㅏㅏ 개 빡 침
     */

    public int solution(int[] people, int limit) {

        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;
        int ans = 0;

        while (left <= right) {

            if (people[left] + people[right] > limit) {
                right--;
                ans++;
                continue;
            }

            left++;
            right--;
            ans++;
        }

        return ans;
    }
}
