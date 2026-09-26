package week9.n2배열자르기.twalla;

/*
## ✏️ [프로그래머스] n^2 배열 자르기

📶 문제 난이도
Lv. 2

🔗 문제 링크
https://school.programmers.co.kr/learn/courses/30/lessons/87390

⏱️ 풀이 시간
20분

✅ 풀이 근거
첫 시도: 2차원 배열을 만들고 인덱스로 접근 -> long 타입을 고려하지 못해 컴파일 에러
두번째 시도: long 타입 컴파일 에러 해결 -> 메모리 초과
세번째 시도: 2차원 배열을 굳이 만들지 않아도 Math.max()로 값을 알 수 있다는 걸 깨닫고 해결

left와 right의 범위가 10의 14승까지임을 미리 알았다면...!

앞으론 입력 값의 범위와 자료형을 풀이 전에 미리 확인하는 습관을 들여야겠습니다!

*/

public class Solution {
    public int[] solution(int n, long left, long right) {

        int length = (int) (right - left + 1);

        int[] answer = new int[length];
        int index = 0;

        for (long i = left; i < right + 1; i++) {
            int r = (int) (i / (long) n);
            int c = (int) (i % (long) n);

            answer[index] = Math.max(r + 1, c + 1);
            index += 1;
        }

        return answer;
    }
}