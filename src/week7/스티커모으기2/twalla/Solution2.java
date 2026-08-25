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
클로드의 도움으로 개선한 코드!

첫번째 스티커와 마지막 스티커는 동시에 사용하지 못한다.
not (A and B) = (not A) or (not B) (드모르간의 법칙)

결국 아래의 두 가지 경우만 생각하면 된다.
1. 첫번째 스티커를 사용하지 않는 경우
2. 마지막 스티커를 사용하지 않는 경우

*/

public class Solution2 {

    int getMax(int[] sticker, int start, int end) {

        int include = 0, exclude = 0;

        for (int i = start; i < end; i++) {
            int newInclude = exclude + sticker[i];
            exclude = Math.max(include, exclude);
            include = newInclude;
        }

        return Math.max(include, exclude);
    }

    public int solution(int sticker[]) {

        int N = sticker.length;

        if (N == 1) {
            return sticker[0];
        }

        int result1 = getMax(sticker, 0, N - 1);
        int result2 = getMax(sticker, 1, N);

        return Math.max(result1, result2);
    }
}
