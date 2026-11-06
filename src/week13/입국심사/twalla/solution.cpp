#include <string>
#include <vector>
#include <algorithm>

/*
## ✏️ [프로그래머스] 입국심사

📶 문제 난이도
Lv. 3

🔗 문제 링크
https://school.programmers.co.kr/learn/courses/30/lessons/43238

⏱️ 풀이 시간
40분 (힌트 봤음...!)

✅ 풀이 근거
"n의 최대가 10억이니까 NlogN 가능하겠지? PQ로 해결해야지~" 했다가 시간 초과가 났다!
log N을 얕봐서 문제였다! log (10억) = 17이었다...!!
10억 x 17 = 170억 이니까 당연히 시간 초과가 날 만한 횟수였다!

그러고는 힌트를 보고 이분탐색으로 해결할 수 있었다!
*/

using namespace std;

long long solution(int n, vector<int> times) {

    long long lo = 1, hi = (long long) *min_element(times.begin(), times.end()) * n;
    long long mid, answer;
    while (lo <= hi) {
        mid = (lo + hi) / 2;
        long long cnt = 0;
        for (int i = 0; i < times.size(); i++) {
            cnt += mid / times[i];
            if (cnt >= n) break;
        }

        if (cnt >= n) {
            answer = mid;
            hi = mid - 1;
        } else {
            lo = mid + 1;
        }
    }

    return answer;
}