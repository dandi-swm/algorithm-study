package week6.입국심사.Vryez11;

import java.util.Arrays;

public class Solution {

    /**
     *
     * [프로그래머스] 입국심사
     *
     * 문제 난이도: Lv3
     * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/43238
     * 풀이 시간: 20분
     * 풀이 근거: 총 시간을 이분 탐색
     */
    public long solution(int n, int[] times) {

        Arrays.sort(times);

        long left = 1;
        long right = (long) times[times.length - 1] * n;

        while (left <= right) {

            long mid = (left + right) / 2;
            long count = 0;

            for (int time : times) {
                count += mid / time;
            }

            if (count < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}
