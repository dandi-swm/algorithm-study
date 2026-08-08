package week5.예상대진표.Vryez11;

public class Solution {

    /**
     *
     * [프로그래머스] 예상 대진표
     *
     * 문제 난이도: Lv. 2
     * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12985
     * 풀이 시간: 20분
     * 풀이 근거: n 개 킹 받 네
     */

    public int solution(int n, int a, int b) {

          int cnt = 0;

          while (a != b) {

              cnt++;

              a = (a + 1) / 2;
              b = (b + 1) / 2;
          }

          return cnt;
    }
}
