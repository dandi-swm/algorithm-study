package week9.배열자르기.Vryez11;

public class Solution {

    /**
     *
     * [프로그래머스] n^2 배열 자르기
     *
     * 문제 난이도: Lv2
     * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/87390
     * 풀이 시간: 20분
     * 풀이 근거: left, right가 long인 것을 보고 배열을 만드는게 아니라, 수학적으로 풀어야 겠다고 생각함. 배열의 접근을 i / n 과 i % n으로 함.
     */
    public int[] solution(int n, long left, long right) {

        int[] answer = new int[(int) (right - left) + 1];
        int idx = 0;

        for (long i = left; i <= right; i++) {

            int r = (int) (i / n);
            int c = (int) (i % n);

            int element;

            if (c <= r) {
                element = r + 1;
            } else {
                element = r + (c - r) + 1;
            }

            answer[idx++] = element;
        }

        return answer;
    }
}
