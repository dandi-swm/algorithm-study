package week7.마법의엘리베이터.twalla;

/*
## ✏️ [프로그래머스] 마법의 엘리베이터

📶 문제 난이도
Lv. 2

🔗 문제 링크
https://school.programmers.co.kr/learn/courses/30/lessons/148653

⏱️ 풀이 시간
2시간

✅ 풀이 근거
처음엔 5 이하, 5 초과 2가지 경우의 수로 해결하려 했으나, 테케에 통과하지 못함.
'5'의 경우 특정 경우에 따라 내려가거나 올라가야하는데, 그 경우를 찾는 데에 시간이 오래 걸림.
클로드의 힌트를 받아, 그 다음 자릿수를 보고 판단함을 깨닫고 세 가지 경우의 수를 생각.

1. 5 초과
2. 5 미만
3. 5

3번에서 판단 기준은 그 다음 자릿수인 nextTarget!

*/

public class Solution {
    public int solution(int storey) {

        int answer = 0;

        while (storey >= 1) {
            int target = storey % 10;

            if (target > 5) {
                storey += 10;
                answer += (10 - target);
            } else if (target < 5 ) {
                answer += target;
            } else {
                int nextTarget = (storey / 10) % 10;
                if (nextTarget >= 5) {
                    storey += 10;
                    answer += 5;
                } else {
                    answer += 5;
                }
            }

            storey /= 10;
        }

        return answer;
    }
}
