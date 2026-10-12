#include <string>
#include <vector>
#include <set>
#include <cmath>
#include <iostream>

using namespace std;

/*
## ✏️ [프로그래머스] 롤케이크 자르기

📶 문제 난이도
Lv. 2

🔗 문제 링크
https://school.programmers.co.kr/learn/courses/30/lessons/132265

⏱️ 풀이 시간
20분

✅ 풀이 근거
처음엔 lef와 right를 양쪽에 두고 while(left < right) 조건으로 각 set에 하나씩 추가했었는데, 이렇게 하니까 반례가 많았다.

그래서 그냥 배열 2개를 두고 각각 쭉 돌려서 leftSetSize[i] == rightSetSize[i + 1] 조건으로 해결했다.
*/

int solution(vector<int> topping) {

    int N = topping.size();

    vector<int> leftSetSize(N), rightSetSize(N);
    set<int> leftSet, rightSet;

    for (int i = 0; i < N; i++) {
        int left = i, right = N - 1 - i;

        leftSet.insert(topping[left]);
        leftSetSize[left] = leftSet.size();
        rightSet.insert(topping[right]);
        rightSetSize[right] = rightSet.size();
    }

    int answer = 0;
    for (int i = 0; i < N - 1; i++) {
        if (leftSetSize[i] == rightSetSize[i + 1]) {
            answer += 1;
        }
    }

    return answer;
}