// ✏️ 프로그래머스 점프와 순간 이동

// 📶 문제 난이도
// Level 2

// 🔗 문제 링크
// https://school.programmers.co.kr/learn/courses/30/lessons/12980

// ⏱️ 풀이 시간
// 30분

// ✅ 풀이 근거
// N이 최대 10억이라면 int[N]은 4 bytes * 1_000_000_000 = 4 GB가 된다.

package week3.점프와순간이동.twalla;

public class Solution {

    int recur(int n) {

        if (n == 1) {
            return 1;
        }

        if (n % 2 == 0) {
            return recur(n / 2);
        } else {
            return recur(n - 1) + 1;
        }
    }

    public int solution(int n) {

        int answer = recur(n);
        return answer;
    }
}