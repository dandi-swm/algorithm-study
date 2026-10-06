#include <vector>
#include <iostream>

using namespace std;

int MOD = 20170805;

/*
## ✏️ [프로그래머스] 보행자 천국

📶 문제 난이도
Lv. 3

🔗 문제 링크
https://school.programmers.co.kr/learn/courses/30/lessons/1832

⏱️ 풀이 시간
(못풀었따!!!)
DP 원래 약하긴 하지만 특히 cache 배열 2개 이상 써야하는 문제는 더 어려운 것 같다..!
[같은 칸/단계라도 "어떤 상태로 도달했느냐"에 따라 다음 칸으로 갈 수 있는 규칙이나 선택지가 달라질 때!!]

✅ 풀이 근거
같은 칸에 도달했더라도 왼쪽에서 진입했는지, 위에서 진입했는지에 따라 다음 칸으로 회전할 수 있는 권한이 달라짐.
right[i][j]: 왼쪽 칸 (i, j-1)에서 유입
down[i][j]: 위쪽 칸 (i-1, j)에서 유입

*/

// 전역 변수를 정의할 경우 함수 내에 초기화 코드를 꼭 작성해주세요.
int solution(int m, int n, vector<vector<int>> city_map) {

    vector<vector<int>> right = vector(m, vector<int>(n, 0));
    vector<vector<int>> down = vector(m, vector<int>(n, 0));

    right[0][0] = 1, down[0][0] = 0;

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {

            if (city_map[i][j] == 1) {
                continue;
            }

            // 오른쪽
            if (j + 1 < n && city_map[i][j + 1] != 1) {
                if (city_map[i][j] == 0) {
                    right[i][j + 1] = (right[i][j + 1] + right[i][j] + down[i][j]) % MOD;
                } else if (city_map[i][j] == 2) {
                    right[i][j + 1] = (right[i][j + 1] + right[i][j]) % MOD;
                }
            }

            // 아래쪽
            if (i + 1 < m && city_map[i + 1][j] != 1) {
                if (city_map[i][j] == 0 && i + 1 < m) {
                    down[i + 1][j] = (down[i + 1][j] + right[i][j] + down[i][j]) % MOD;
                } else if (city_map[i][j] == 2) {
                    down[i + 1][j] = (down[i + 1][j] + down[i][j]) % MOD;
                }
            }
        }
    }

    int answer = (right[m - 1][n - 1] + down[m - 1][n - 1]) % MOD;
    return answer;
}