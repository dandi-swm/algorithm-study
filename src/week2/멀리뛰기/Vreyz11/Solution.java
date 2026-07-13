package week2.멀리뛰기.Vreyz11;

public class Solution {

    /**
     *
     * [프로그래머스] 멀리 뛰기
     *
     * 문제 난이도 : Lv. 2
     * 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12914
     * 풀이 시간 : 10분
     * 풀이 근거 : n-1에서 1로 뛰면 n / n-2에서 2로 뛰면 n / 따라서 n - 1, n - 2합 축적
     */

    static final int MOD = 1_234_567;

    public long solution(int n) {

        long[] dp = new long[n + 1];

        if (n == 1) return 1;

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {

            dp[i] = (dp[i - 2] + dp[i - 1]) % MOD;
        }

        return dp[n];
    }
}
