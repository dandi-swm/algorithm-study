#include <string>
#include <vector>
#include <iostream>

using namespace std;

/*
## ✏️ [프로그래머스] 파괴되지 않은 건물

📶 문제 난이도
Lv. 3

🔗 문제 링크
https://school.programmers.co.kr/learn/courses/30/lessons/92344

⏱️ 풀이 시간
(못풀었따!)

✅ 풀이 근거
누적합을 2차원 배열에서 적용해야했던 문제!!
*/

int solution(vector<vector<int>> board, vector<vector<int>> skill) {

    int N = board.size();
    int M = board[0].size();

    vector<vector<int>> result(N + 1, vector<int>(M + 1));

    for (int i = 0; i < skill.size(); i++) {
        int type = skill[i][0];
        int r1 = skill[i][1];
        int c1 = skill[i][2];
        int r2 = skill[i][3];
        int c2 = skill[i][4];
        int degree = skill[i][5];

        if (type == 1) {
            degree = -degree;
        }

        result[r1][c1] += degree;
        result[r1][c2 + 1] -= degree;
        result[r2 + 1][c1] -= degree;
        result[r2 + 1][c2 + 1] += degree;
    }

    for (int i = 1; i < N; i++) {
        for (int j = 0; j < M; j++) {
            result[i][j] += result[i - 1][j];
        }
    }

    for (int i = 0; i < N; i++) {
        for (int j = 1; j < M; j++) {
            result[i][j] += result[i][j - 1];
        }
    }

    int answer = 0;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            if (board[i][j] + result[i][j] > 0) {
                answer += 1;
            }
        }
    }

    return answer;
}