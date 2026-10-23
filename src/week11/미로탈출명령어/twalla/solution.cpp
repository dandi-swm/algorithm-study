#include <string>
#include <vector>
#include <queue>
#include <cmath>
#include <iostream>

/*
## ✏️ [프로그래머스] 미로 탈출 명령어

📶 문제 난이도
Lv. 3

🔗 문제 링크
https://school.programmers.co.kr/learn/courses/30/lessons/150365

⏱️ 풀이 시간
30분

✅ 풀이 근거
사전순으로 빠른 경로라고 하길래 바로 PQ를 떠올렸다.
다만 이대로만 하면 시간 초과가 나는 테스트 케이스가 있는데,
바로 최소 거리가 홀수라면 k도 홀수여야하며, 짝수면 k도 짝수여야한다.
이 조건이 지켜지지 않으면 k만큼 아무리 가도 절대 도달할 수 없기 때문이다.

*/

using namespace std;

struct Node {
    int i, j;
    string path;

    Node(int i, int j, string path) : i(i), j(j), path(path) {}

    bool operator<(const Node& other) const {
        return this->path > other.path;
    }
};

int getDist(int i, int j, int r, int c) {
    return abs(r - i) + abs(c - j);
}

bool isPossible(int i, int j, int r, int c, int curK, int k) {
    return ((abs(r - i) + abs(c - j) + curK) <= k);
}

bool isBound(int i, int j, int n, int m) {
    return (1 <= i && i < n + 1) && (1 <= j && j < m + 1);
}

vector<int> di = {-1, 0, 1, 0}; // 위, 왼, 아, 오
vector<int> dj = {0, -1, 0, 1};
vector<string> direction = {"u", "l", "d", "r"};

string solution(int n, int m, int x, int y, int r, int c, int k) {

    priority_queue<Node> pq;
    pq.push(Node(x, y, ""));

    int dist = getDist(x, y, r, c);
    if (dist % 2 != k % 2) {
        return "impossible";
    }

    while (!pq.empty()) {
        Node cur = pq.top();
        // cout << cur.path << endl;

        if (cur.path.size() == k) {
            if (cur.i == r && cur.j == c) {
                return cur.path;
            } else {
                pq.pop();
                continue;
            }
        }

        for (int d = 0; d < 4; d++) {
            int ni = cur.i + di[d];
            int nj = cur.j + dj[d];

            if (!isBound(ni, nj, n, m) || !isPossible(ni, nj, r, c, cur.path.size(), k)) {
                continue;
            }

            pq.push(Node(ni, nj, cur.path + direction[d]));
        }

        pq.pop();
    }

    return "impossible";
}