#include <string>
#include <vector>
#include <iostream>

using namespace std;

/*
## ✏️ [프로그래머스] 행렬의 곱셈

📶 문제 난이도
Lv. 2

🔗 문제 링크
https://school.programmers.co.kr/learn/courses/30/lessons/12949

⏱️ 풀이 시간
20분

✅ 풀이 근거
행렬 곱셈 푸는 법 맨날 까먹음;

*/

vector<vector<int>> solution(vector<vector<int>> arr1, vector<vector<int>> arr2) {

    int l = arr1.size();
    int m = arr2.size();
    int n = arr2[0].size();

    vector<vector<int>> answer(l, vector<int>(n));
    for (int i = 0; i < l; i++) {
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < m; k++) {
                answer[i][j] += arr1[i][k] * arr2[k][j];
            }
        }
    }

    return answer;
}