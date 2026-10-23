#include <string>
#include <vector>
#include <iostream>
#include <cmath>

using namespace std;

/*
## ✏️ [프로그래머스] 연속 펄스 부분 수열의 합

📶 문제 난이도
Lv. 3

🔗 문제 링크
https://school.programmers.co.kr/learn/courses/30/lessons/161988

⏱️ 풀이 시간
1시간

✅ 풀이 근거
(못 풀었다!!)
이 문제 왜이렇게 어렵나요;;;
구간합은 알겠는데 거기서 결국 최댓값 - 최솟값 도출하는게 말도 안됨...;;

*/

long long solution(vector<int> sequence) {

    int N = sequence.size();

    long long prefix = 0;
    long long min_value = 0, max_value = 0;

    int pulse = 1;
    for (int i = 0; i < N; i++) {

        prefix += sequence[i] * pulse;

        min_value = min(min_value, prefix);
        max_value = max(max_value, prefix);

        pulse = -pulse;
    }

    long long answer = max_value - min_value;

    return answer;
}