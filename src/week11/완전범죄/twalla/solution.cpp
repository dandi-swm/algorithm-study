#include <string>
#include <vector>
#include <queue>
#include <iostream>
#include <climits>
#include <algorithm>

using namespace std;

/*
## ✏️ [프로그래머스] 완전범죄

📶 문제 난이도
Lv. 2

🔗 문제 링크
https://school.programmers.co.kr/learn/courses/30/lessons/389480

⏱️ 풀이 시간
(못풀었따!!!)

✅ 풀이 근거
DFS 완전 탐색으로 풀면 2^40으로 시간초과가 남.
그래서 visited로 방문 체크를 해줘야함!

*/

int N, A;
int answer = INT_MAX;
bool visited[41][121][121];

void dfs(vector<vector<int>> &info, int i, int n, int m) {

    if (i == N) {
        answer = min(answer, A - n);
        return;
    }

    if (visited[i][n][m]) {
        return;
    }

    visited[i][n][m] = true;

    vector<int> cur = info[i];

    int curA = cur[0];
    int curB = cur[1];

    if (n - curA > 0) {
        dfs(info, i + 1, n - curA, m);
    }

    if (m - curB > 0) {
        dfs(info, i + 1, n, m - curB);
    }
}


int solution(vector<vector<int>> info, int n, int m) {

    N = info.size();
    A = n;
    dfs(info, 0, n, m);

    if (answer == INT_MAX) {
         return -1;
    }

    return answer;
}