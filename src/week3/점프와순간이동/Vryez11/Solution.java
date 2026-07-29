package week3.점프와순간이동.Vryez11;

public class Solution {

    /**
     *
     * [프로그래머스] 점프와 순간 이동
     *
     * 문제 난이도: Lv2
     * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12980
     * 풀이 시간: 20분
     * 풀이 근거: 2로 나눠지면 순간 이동 / 아니면 한 칸 앞으로 가기
     */

    public int solution(int n) {

        int battery = 0;

        while (n > 0) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
                battery += 1;
            }
        }

        return battery;
    }
}
