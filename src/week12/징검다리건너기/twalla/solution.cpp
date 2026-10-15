#include <string>
#include <vector>
#include <cmath>
#include <iostream>

using namespace std;

/*
## ✏️ [프로그래머스] 징검다리 건너기

📶 문제 난이도
Lv. 3

🔗 문제 링크
https://school.programmers.co.kr/learn/courses/30/lessons/64062

⏱️ 풀이 시간
40분

✅ 풀이 근거
처음엔 Treemap으로 난리를 쳤는데, 며칠 뒤에 다시 문제를 읽어보고 해결할 수 있었다.
일단 배열 최대 길이가 2억이라서 NlogN 위주의 해결책을 생각해보았고 이분탐색을 생각해낼 수 있었다!

*/

int solution(vector<int> stones, int k) {

    int S = stones.size();

    int l = 1, h = 200000000;
    int answer = 0;

    while (l < h) {
        int m = (l + h) / 2;

        int count = 0;
        bool isCrossable = true;
        for (int i = 0; i < S; i++) {

            if (stones[i] < m) {
                count += 1;
            } else {
                count = 0;
            }

            if (count == k) {
                isCrossable = false;
                break;
            }
        }

        if (isCrossable) {
            answer = max(answer, m);
            l = m + 1;
        } else {
            h = m;
        }
    }

    return answer;
}