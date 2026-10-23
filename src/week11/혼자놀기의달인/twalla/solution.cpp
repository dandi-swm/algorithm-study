#include <string>
#include <vector>
#include <queue>
#include <iostream>

/*
## ✏️ [프로그래머스] 혼자 놀기의 달인

📶 문제 난이도
Lv. 2

🔗 문제 링크
https://school.programmers.co.kr/learn/courses/30/lessons/131130

⏱️ 풀이 시간
20분

✅ 풀이 근거
처음에 문제 읽고 union - find와 비슷하다는 생각이 들었다.
하지만 굳이 그래프 형태로 갈 필요 없이 while문으로 visited를 처리해주면 간단하게 해결할 수 있었다.

*/

using namespace std;

int solution(vector<int> cards) {

    int N = cards.size();

    vector<bool> visited(N, false);
    priority_queue<int> groups;

    for (int i = 0; i < N; i++) {
        if (visited[i]) {
            continue;
        }

        int cur = i;
        int cnt = 0;
        while (!visited[cur]) {
            visited[cur] = true;
            cnt += 1;
            cur = cards[cur] - 1;
        }
        groups.push(cnt);
    }

    if (groups.size() < 2) {
        return 0;
    }

    int group1 = groups.top();
    groups.pop();

    int group2 = groups.top();

    int answer = group1 * group2;
    return answer;
}