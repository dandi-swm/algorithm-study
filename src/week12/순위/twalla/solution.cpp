#include <string>
#include <vector>
#include <iostream>

using namespace std;

/*
## ✏️ [프로그래머스] 순위

📶 문제 난이도
Lv. 3

🔗 문제 링크
https://school.programmers.co.kr/learn/courses/30/lessons/49191

⏱️ 풀이 시간
1시간 30분

✅ 풀이 근거
(못 풀었다!!)
그래프라는거까지는 접근했는데, indegree 배열이랑 outdegree 배열 두고 재귀로 타고타고 들어가야하나 하면서 계속 헤맸다!
고민하다가 플로이드 워셜이라는 힌트 보고 해결할 수 있었다!
A와 B가 연관이 있고, B와 C가 연관이 있다면, A와 C도 연관이 있는가? --> 플로이드 워셜! (DFS/BFS로도 가능)

*/

int solution(int n, vector<vector<int>> results) {

    int N = n;
    int M = results.size();

    vector<vector<int>> graph(N + 1, vector<int>(N + 1));

    for (int i = 0; i < M; i++) {
        int win = results[i][0];
        int lose = results[i][1];

        graph[win][lose] = 1;
        graph[lose][win] = -1;
    }

    for (int i = 1; i < N + 1; i++) {
        for (int j = 1; j < N + 1; j++) {
            for (int k = 1; k < N + 1; k++) {
                if (graph[i][k] == 1 && graph[k][j] == 1) {
                    graph[i][j] = 1;
                    graph[j][i] = -1;
                } else if (graph[i][k] == -1 && graph[k][j] == -1) {
                    graph[i][j] = -1;
                    graph[j][i] = 1;
                }
            }
        }
    }

    int answer = 0;
    for (int i = 1; i < N + 1; i++) {
        int count = 0;
        for (int j = 1; j < N + 1; j++) {
            if (graph[i][j] == 1 || graph[i][j] == -1) {
                count += 1;
            }
        }

        if (count == N - 1) {
            answer += 1;
        }
    }

    return answer;
}