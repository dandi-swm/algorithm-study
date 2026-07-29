package week3.거스름돈.Vryez11;

public class Solution {

    /**
     *
     * [프로그래머스] 거스름돈
     *
     * 문제 난이도: Lv. 3
     * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12907
     * 풀이 시간: 20분
     * 풀이 근거: 타일 개수 더하기랑 비슷함, 1원으로 0원에서 1원, 1원에서 1원 더하면 2원 ... DP
     */

    final static int MOD = 1_000_000_007;

    public int solution(int n, int[] money) {

        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int coin : money) {
            for (int price = coin; price <= n; price++) {

                dp[price] = (dp[price] + dp[price - coin]) % MOD;
            }
        }

        return dp[n];
    }
}
