package week2.징검다리건너기.Vryez11;

public class Solution {

    /**
     *
     * [프로그래머스] 징검다리 건너기
     *
     * 문제 난이도: Lv. 3
     * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/64062
     * 풀이 시간: 20분
     * 풀이 근거: 
     */

    public int solution(int[] stones, int k) {

        int left = 1;
        int right = 200_000_000;
        int answer = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canCross(stones, k, mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    private boolean canCross(int[] stones, int k, int people) {
        int count = 0;

        for (int stone : stones) {
            if (stone < people) {
                count++;

                if (count >= k) {
                    return false;
                }

            } else {
                count = 0;
            }
        }

        return true;
    }
}
