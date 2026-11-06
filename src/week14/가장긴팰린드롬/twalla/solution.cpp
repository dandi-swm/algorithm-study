#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

int expand(string &s, int l, int r) {
    int jump = 1;
    int count;

    if (l == r) {
        count = 1;
    } else {
        count = 2;
    }

    while (l - jump >= 0 && r + jump < s.size()) {
        if (s.at(l - jump) == s.at(r + jump)) {
            count += 2;
        } else {
            break;
        }
        jump += 1;
    }

    return count;
}

int solution(string s)
{
    int N = s.size();

    int answer = 0;
    for (int i = 0; i < N; i++) {
        answer = max(answer, expand(s, i, i));
        if (i + 1 < N && s.at(i) == s.at(i + 1)) {
            answer = max(answer, expand(s, i, i + 1));
        }
    }

    return answer;
}