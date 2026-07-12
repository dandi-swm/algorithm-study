package week1.퍼즐게임챌린지.Vryez11;

public class Solution {

    /**
     *
     * 퍼즐 게임 챌린지
     *
     * 문제 난이도 : Lv2
     * 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/340212
     * 풀이 시간 : 30분
     * 풀이 근거 : left = 1, right = 300_000으로 한 후 mid 를 현재 level로 해서 이분 탐색
     */

    public int solution(int[] diffs, int[] times, long limit) {

        int left = 1;
        int right = 300_000;
        int mid = (right + left) / 2;

        while (left <= right) {


            long sectionLimit = limit;
            int time_prev = times[0];
            sectionLimit -= diffs[0] - mid > 0 ? (long) (diffs[0] - mid) * times[0] : times[0];

            for (int i = 1; i < diffs.length; i++) {

                if (sectionLimit < 0) break;

                sectionLimit -= diffs[i] - mid > 0 ? (long) (diffs[i] - mid) * (time_prev + times[i]) + times[i] : times[i];
                time_prev = times[i];
            }

            if (sectionLimit >= 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

            mid = (left + right) / 2;
        }

        return ++mid;
    }
}
