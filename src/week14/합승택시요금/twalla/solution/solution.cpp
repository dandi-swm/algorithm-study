#include <string>
#include <vector>
#include <queue>
#include <climits>
#include <algorithm>
#include <iostream>

using namespace std;

int INF = 1e9;

struct Node {
    int index;
    int dist;

    Node(int _index, int _dist) : index(_index), dist(_dist) {}
};

struct CompareNode {
    bool operator()(const Node &a, const Node &b) {
        return a.dist < b.dist;
    }
};

vector<vector<int>> floyd_warshall(int n, vector<vector<int>> &map) {
    vector<vector<int>> result(n + 1, vector<int>(n + 1));

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            if (i == j) {
                result[i][j] = 0;
            } else if (map[i][j] == 0) {
                result[i][j] = INF;
            } else {
                result[i][j] = map[i][j];
            }
        }
    }

    for (int k = 1; k <= n; ++k) {
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (result[i][k] + result[k][j] < result[i][j]) {
                    result[i][j] = result[i][k] + result[k][j];
                }
            }
        }
    }

    return result;
}

int solution(int n, int s, int a, int b, vector<vector<int>> fares) {

    vector<vector<int>> map(n + 1, vector<int>(n + 1));

    for (int i = 0; i < fares.size(); i++) {
        int c = fares[i][0];
        int d = fares[i][1];
        int f = fares[i][2];

        map[c][d] = f;
        map[d][c] = f;
    }

    vector<vector<int>> fwResult = floyd_warshall(n, map);
    int answer = INF;
    for (int i = 1; i <= n; i++) {
        if (fwResult[s][i] == INF || fwResult[i][a] == INF || fwResult[i][b] == INF) {
            continue;
        }
        answer = min(answer, fwResult[s][i] + fwResult[i][a] + fwResult[i][b]);
    }

    return answer;
}