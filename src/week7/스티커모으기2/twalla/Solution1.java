package week7.스티커모으기2.twalla;

/*
## ✏️ [프로그래머스] 스티커 모으기(2)

📶 문제 난이도
Lv. 3

🔗 문제 링크
https://school.programmers.co.kr/learn/courses/30/lessons/12971

⏱️ 풀이 시간
30분

✅ 풀이 근거
연속하는 세 수 중 하나는 무조건 사용된다는 규칙 하에 dp를 3번 돌려서 해결함.

*/

public class Solution1 {
    public int solution(int sticker[]) {

        int N = sticker.length;

        if (N == 1) {
            return sticker[0];
        }

        if (N == 2) {
            return Math.max(sticker[0], sticker[1]);
        }

        int max = 0;
        int[][] cache = new int[N][2];
        // [][0]: 해당 index의 스티커를 포함하는 경우
        // [][1]: 해당 index의 스티커를 포함하지 않는 경우
        for (int i = 0; i < 3; i++) {
            // 무조건 포함해야하는 스티커
            // 연속된 셋 중 하나는 무조건 포함됨.
            cache[i][0] = sticker[i];
            cache[i][1] = sticker[i];
            for (int j = 1; j < N; j++) {
                int index = (i + j) % N;
                int prevIndex = (index + N - 1) % N; // index가 0인 경우를 방지하기 위해 +N
                if (j == 1 || j == N - 1) { // 양 옆의 스티커는 포함하지 않는다.
                    cache[index][1] = Math.max(cache[prevIndex % N][0], cache[prevIndex % N][1]);
                } else {
                    cache[index][0] = cache[prevIndex % N][1] + sticker[index];
                    cache[index][1] = Math.max(cache[prevIndex % N][0], cache[prevIndex % N][1]);
                }
            }
            int endIndex = (i + N - 1) % N;
            max = Math.max(max, Math.max(cache[endIndex][0], cache[endIndex][1]));

            cache = new int[N][2];
        }

        return max;
    }
}
