#include <string>
#include <vector>
#include <iostream>
#include <queue>
#include <algorithm>
#include <set>

/*
## ✏️ [프로그래머스] 양과 늑대

📶 문제 난이도
Lv. 3

🔗 문제 링크
https://school.programmers.co.kr/learn/courses/30/lessons/92343

⏱️ 풀이 시간
(못 풂!!!!!)

✅ 풀이 근거
그래도 풀이에 가장 근접하게 접근한 것 같긴 한데,
처음에는 Node에 현재까지 방문한 Node 벡터를 저장했었는데, 이게 매번 다음 목적지를 탐색하는 데에 중복되는 계산이랑 시간이 많이 걸렸던 것 같다.
풀이를 보고 Node에 현재까지 방문한 노드들이 아니라 다음에 갈 수 있는 노드 벡터를 저장해서 시간 안에 해결할 수 있었다.
*/

using namespace std;

struct Node {
    int sheep;
    int wolf;
    vector<int> next;

    Node(int _sheep, int _wolf, vector<int> &_next) : sheep(_sheep), wolf(_wolf), next(_next) {}
};

int solution(vector<int> info, vector<vector<int>> edges) {

    int N = info.size();

    vector<vector<int>> graph(N);

    for (int i = 0; i < edges.size(); i++) {
        graph[edges[i][0]].push_back(edges[i][1]);
    }

    vector<int> next;
    for (int i = 0; i < graph[0].size(); i++) {
        next.push_back(graph[0][i]);
    }

    Node root = Node(1, 0, next);

    queue<Node> q;
    q.push(root);
    int answer = 0;
    while (!q.empty()) {

        Node cur = q.front();
        q.pop();

        answer = max(answer, cur.sheep);

        for (int i = 0; i < cur.next.size(); i++) {

            int candidate = cur.next[i];

            vector<int> newNext = cur.next;
            newNext.erase(newNext.begin() + i);

            for (int i = 0; i < graph[candidate].size(); i++) {
                newNext.push_back(graph[candidate][i]);
            }

            if (info[candidate] == 0) { // 양
                q.push(Node(cur.sheep + 1, cur.wolf, newNext));
            } else { // 늑대
                if (cur.sheep > cur.wolf + 1) {
                    q.push(Node(cur.sheep, cur.wolf + 1, newNext));
                }
            }
        }

    }

    return answer;
}