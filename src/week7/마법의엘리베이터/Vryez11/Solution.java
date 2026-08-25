package week7.마법의엘리베이터.Vryez11;

public class Solution {

    /**
     *
     * [프로그래머스] 마법의 엘리베이터
     *
     * 문제 난이도: Lv2
     * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/148653
     * 풀이 시간:
     * 풀이 근거:
     */

    public int solution(int storey) {

        int stoneCount = 0;

        while (storey > 0) {
            int remainder = storey % 10;
            int nextDigit = (storey / 10) % 10;

            if (remainder > 5 || (remainder == 5 && nextDigit >= 5)) {
                stoneCount += (10 - remainder);
                storey += (10 - remainder);
            } else {
                stoneCount += remainder;
            }

            storey /= 10;
        }

        return stoneCount;
    }
}
