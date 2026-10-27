#include <string>
#include <vector>

using namespace std;

/*
## ✏️ [프로그래머스] 타겟 넘버

📶 문제 난이도
Lv. 2

🔗 문제 링크
https://school.programmers.co.kr/learn/courses/30/lessons/43165

⏱️ 풀이 시간
15분

✅ 풀이 근거
숫자의 개수 범위가 적어서 완전 탐색으로 충분히 해결 가능했다!
*/

int N;
int T;
int answer = 0;

void dfs(int cur, int index, vector<int> &numbers) {
    if (index == N) {
        if (cur == T) {
            answer += 1;
        }
        return;
    }

    dfs(cur + numbers[index], index + 1, numbers);
    dfs(cur - numbers[index], index + 1, numbers);
}

int solution(vector<int> numbers, int target) {

    N = numbers.size();
    T = target;

    dfs(0, 0, numbers);

    return answer;
}