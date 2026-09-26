package week9.거스름돈.twalla;

/*
## ✏️ [프로그래머스] 거스름돈

📶 문제 난이도
Lv. 3

🔗 문제 링크
https://school.programmers.co.kr/learn/courses/30/lessons/12907

⏱️ 풀이 시간
30분

✅ 풀이 근거
전형적인 DP 문제!
(1, 2, 5) 코인이 있다면,
n을 (1)로만 만들수 있는 경우, (1, 2)로만 만들 수 있는 경우, 순서로 계산해보면 (1, 2, 5)도 구할 수 있다!

*/

public class Solution {
    public int solution(int n, int[] money) {

        int m = money.length;

        int[][] cache = new int[m + 1][n + 1];

        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0) {
                    cache[i][j] = 0;
                } else if (j == 0) {
                    cache[i][j] = 1;
                }
            }
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (j >= money[i - 1]) {
                    cache[i][j] = cache[i][j - money[i - 1]] + cache[i - 1][j];
                } else {
                    cache[i][j] = cache[i - 1][j];
                }
            }
        }

        int answer = cache[m][n];
        return answer;
    }
}
