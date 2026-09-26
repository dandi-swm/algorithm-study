#include <string>
#include <vector>
#include <algorithm>
#include <iostream>


using namespace std;

int N;
int answer = 0;
vector<bool> visited;

void dfs(int current_k, int count, vector<vector<int>> &dungeons) {
    answer = max(answer, count);

    for (int i = 0; i < N; i++) {
        if (visited[i] || dungeons[i][0] > current_k) {
            continue;
        }

        visited[i] = true;
        dfs(current_k - dungeons[i][1], count + 1, dungeons);
        visited[i] = false;
    }
}


int solution(int k, vector<vector<int>> dungeons) {

    N = dungeons.size();
    answer = 0;

    visited.assign(N, false);

    dfs(k, 0, dungeons);

    return answer;
}