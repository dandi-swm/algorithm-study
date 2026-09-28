/*
## ✏️ [프로그래머스] 거스름돈

📶 문제 난이도
Lv. 3

🔗 문제 링크
https://school.programmers.co.kr/learn/courses/30/lessons/12907

⏱️ 풀이 시간
10분

✅ 풀이 근거
예전에 풀어봤던 dp 문제
*/
import java.util.*;

class Solution {
    public int solution(int n, int[] money) {
        final int MOD = 1000000007;
        int[] dp = new int[n + 1];
        dp[0] = 1;                       // 0원을 만드는 방법: 1가지(아무것도 안 씀)

        for (int m : money) {
            for (int i = m; i <= n; i++) {
                dp[i] += dp[i - m] % MOD;
            }
        }
        return dp[n];
    }
}