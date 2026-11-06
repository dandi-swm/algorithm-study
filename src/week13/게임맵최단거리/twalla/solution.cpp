#include<vector>
#include<queue>
using namespace std;

/*
## ✏️ [프로그래머스] 게임 맵 최단거리

📶 문제 난이도
Lv. 2

🔗 문제 링크
https://school.programmers.co.kr/learn/courses/30/lessons/1844

⏱️ 풀이 시간
40분

✅ 풀이 근거
간단한 BFS 문제였지만, c++ pq 사용법을 익히느라 꽤 걸렸다!
*/

int N, M;
vector<int> di = {-1, 0, 1, 0};
vector<int> dj = {0, -1, 0, 1};

struct Node {
    int x;
    int y;
    int dist;

    Node(int _x, int _y, int _dist) : x(_x), y(_y), dist(_dist) {}
};

struct Compare {
    bool operator()(const Node& a, const Node & b) {
        return a.dist > b.dist;
    }
};

bool isBound(int i, int j) {
    return (0 <= i && i < N) && (0 <= j && j < M);
}

int solution(vector<vector<int> > maps)
{
    N = maps.size();
    M = maps[0].size();

    priority_queue<Node, vector<Node>, Compare> pq;
    pq.push(Node(0, 0, 1));

    vector<vector<bool>> visited(N, vector<bool>(M));
    visited[0][0] = true;

    while (!pq.empty()) {
        Node cur = pq.top();

        if (cur.x == N - 1 && cur.y == M - 1) {
            return cur.dist;
        }

        for (int d = 0; d < 4; d++) {
            int ni = cur.x + di[d];
            int nj = cur.y + dj[d];

            if (!isBound(ni, nj) || maps[ni][nj] == 0 || visited[ni][nj]) {
                continue;
            }

            visited[ni][nj] = true;
            pq.push(Node(ni, nj, cur.dist + 1));
        }

        pq.pop();
    }

    return -1;
}