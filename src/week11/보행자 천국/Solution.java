/*
## ✏️ [프로그래머스] 보행자 천국

📶 문제 난이도
Lv. 3

🔗 문제 링크
https://school.programmers.co.kr/learn/courses/30/lessons/1832?language=java

⏱️ 풀이 시간
30분

✅ 풀이 근거
bfs로 했따가 dp로 바꿨다.
이거 고딩때 확통 문제 그 자체인데 바로 안한게 아쉽다..ㅠ
확통 콤비네이션만 생각해도 맵크기가 500이면 말도 안되는 큰 값이 나온다는걸 알수있었을텐데
다음부턴 좀더 신경써서 고민하고 풀어야겠다.
*/
class Solution {
    int MOD = 20170805;
    public int solution(int n, int m, int[][] cityMap) {
        int[][] right = new int[n][m];
        int[][] down = new int[n][m];
        right[0][0] = 1;

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (cityMap[y][x] == 1) continue; // 벽이면 0으로 남김

                if (x > 0) {
                    if (cityMap[y][x - 1] == 2)
                        right[y][x] = right[y][x - 1];
                    else
                        right[y][x] = (right[y][x - 1] + down[y][x - 1]) % MOD;
                }

                if (y > 0) {
                    if (cityMap[y - 1][x] == 2)
                        down[y][x] = down[y - 1][x];
                    else
                        down[y][x] = (right[y - 1][x] + down[y - 1][x]) % MOD;
                }
            }
        }
        return (right[n - 1][m - 1] + down[n - 1][m - 1]) % MOD;
    }
}