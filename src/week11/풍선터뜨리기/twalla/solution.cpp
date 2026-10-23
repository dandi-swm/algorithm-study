#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

/*
## ✏️ [프로그래머스] 풍선 터뜨리기

📶 문제 난이도
Lv. 3

🔗 문제 링크
https://school.programmers.co.kr/learn/courses/30/lessons/68646

⏱️ 풀이 시간
(못풀었따!!!)

✅ 풀이 근거
완전 탐색으로 해야하나? 하기엔 a의 길이가 최대 100만이라 고민이 되었다.
결국 규칙을 찾아야 했는데, 계속 고민하다가 힌트를 보고 풀 수 있었다.
규칙은 굉장히 간단했는데, 그냥 양 옆에 나보다 작은 애가 있으면 불가능했다!!!
그래서 left와 right에서 각각 나보다 작은 수 중 가장 작은 수를 저장해놓고 해결할 수 있었다!

*/

int solution(vector<int> a) {

    int L = a.size();

    vector<int> left(L), right(L);

    left[0] = a[0];
    for (int i = 1; i < L; i++) {
        left[i] = min(left[i - 1], a[i]);
    }

    right[L - 1] = a[L - 1];
    for (int i = L - 2; i >= 0; i--) {
        right[i] = min(right[i + 1], a[i]);
    }

    int answer = 0;

    for (int i = 0; i < L; i++) {
        if (i == 0 || i == L - 1) {
            answer += 1;
            continue;
        }

        if (left[i] < a[i] && right[i] < a[i]) {
            continue;
        } else {
            answer += 1;
        }

    }

    return answer;
}