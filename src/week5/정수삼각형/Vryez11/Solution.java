package week5.정수삼각형.Vryez11;

import java.util.Arrays;

public class Solution {

    /**
     *
     * [프로그래머스] 정수 삼각형
     *
     * 문제 난이도: Lv3
     * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/43105
     * 풀이 시간: 25분
     * 풀이 근거: dp 스포를 카테고리에서 당해버림 .. 요즘은 배열, 컬렉션은 최대한 스트림을 이용해서 풀어보려고 노력중!
     */

    public int solution(int[][] triangle) {

        int n = triangle.length;
        int[][] dp = new int[n][triangle[n - 1].length];
        dp[0][0] = triangle[0][0];

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j <= i; j++) {

                dp[i + 1][j] = Math.max(dp[i + 1][j], triangle[i + 1][j] + dp[i][j]);
                dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], triangle[i + 1][j + 1] + dp[i][j]);
            }
        }

        return Arrays.stream(dp[n - 1])
                .max()
                .orElse(-1);
    }
}
