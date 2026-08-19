package week6.산모양타일링.Vryez11;

public class Solution {

    /**
     *
     * [프로그래머스] 산 모양 타일링
     *
     * 문제 난이도: Lv3
     * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/258705
     * 풀이 시간: 1시간 30분
     * 풀이 근거: 전체 38.7점 나오는데 모르겠습니다 . . .
     */
    public int solution(int n, int[] tops) {

        int ans = 0;

        int[] dp = new int[2 * n + 2];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= 2 * n + 1; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10_007;
        }

        int top = 0;
        for (int i = 0; i < n; i++) {
            if (tops[i] == 0) {
                continue;
            }

            top |= 1 << ((n - 1) - i);
        }

        for (int i = 0; i <= top; i++) {

            if ((i | top) != top) {
                continue;
            }

            int mul = 1;
            int cnt = 0;
            for (int j = n - 1; j >= 0; j--) {

                if ((i & (1 << j)) == 0) {
                    cnt++;
                } else {
                    mul = mul * dp[2 * cnt + 1] % 10_007;
                    cnt = 0;
                }
            }

            mul = mul * dp[2 * cnt + 1] % 10_007;

            ans = (ans + mul) % 10_007;
        }

        return ans;
    }
}
