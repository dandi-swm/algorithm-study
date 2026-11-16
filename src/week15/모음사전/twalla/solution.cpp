#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
#include <queue>

using namespace std;

int solution(string word) {

    string start = "";
    priority_queue<string, vector<string>, greater<string>> pq;
    pq.push(start);

    vector<string> candidate = {"A", "E", "I", "O", "U"};

    int cnt = -1;
    while (!pq.empty()) {
        cnt += 1;
        string cur = pq.top();
        pq.pop();

        if (cur == word) {
            return cnt;
        }

        if (cur.size() == 5) {
            continue;
        }

        for (int i = 0; i < 5; i++) {
            pq.push(cur + candidate[i]);
        }
    }

    return cnt;
}