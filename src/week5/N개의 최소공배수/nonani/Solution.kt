
import kotlin.math.*

/*
## ✏️ [프로그래머스] N개의 최소공배수
📶 문제 난이도
Lv. 2

🔗 문제 링크
https://school.programmers.co.kr/learn/courses/30/lessons/12953

⏱️ 풀이 시간
30분

✅ 풀이 근거
유클리드 호제법을 통해 최대 공약수를 구하고 최대 공배수는 a, b를 곱한것 즉,
 a*b에 최대공약수를 나눠준 것과 같다는 것을 사용해서 해결함.

 유클리드 호제법을 까먹어서 다시 공부하면서 해결

 */


class Solution {
    fun solution(arr: IntArray): Int {
        var answer = arr[0]
        // answer와 i의 최소공배수를 구하자

        for (i in arr) {
            answer = answer * i / gcd(max(answer, i), min(answer, i))
        }
        return answer
    }

    private fun gcd(a: Int, b: Int): Int { // a >= b
        if (b == 0)
            return a
        return gcd(b, a % b)
    }
}