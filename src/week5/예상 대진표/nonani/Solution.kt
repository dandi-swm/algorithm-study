import kotlin.math.*

/*
## ✏️ [프로그래머스] 예상 대진표
📶 문제 난이도
Lv. 2

🔗 문제 링크
https://school.programmers.co.kr/learn/courses/30/lessons/12985

⏱️ 풀이 시간
20분

✅ 풀이 근거
단순 수학 문제? 였던 것 같다

 */

class Solution {
    fun solution(n: Int, a: Int, b: Int): Int {
        var answer = 1

        val aa = a - 1
        val bb = b - 1

        // 2 shl answer: 2 << answer 와 같은 표현
        while (aa / (1 shl answer) != bb / (1 shl answer))
            answer += 1

        return answer
    }
}