/*
## ✏️ [프로그래머스] 행렬의 곱셈

📶 문제 난이도
Lv. 2

🔗 문제 링크
https://school.programmers.co.kr/learn/courses/30/lessons/12949?language=kotlin

⏱️ 풀이 시간
20분

✅ 풀이 근거
배열의 길이가 길어서 O(n)안에 풀어야하는 문제라고 판단하고 고민했다.
정렬을 해야하나, 고민을 했었는데 테스트 케이스 해설 부분에서 힌트를 얻었다.

앞에서 부터 2개를 묶어가면서 터뜨리는 경우를 보여주는게 아니라 특정 숫자가 살아남는 경우를 설명하길래
그 특정숫자가 살아남기위해서 어떻게 되어야하지? 고민하니까 답이 보였다.
특정 숫자 X가  살아남기위해서 (A) X (B)
구간 A의 최소값이나 구간 B의 최소값이 둘중 하나만 X보다 작아야한다.
그래야 그 작은걸 터뜨리는 예외 규칙 한번을 수행할 수 있으니!
그럼 이제 구간 최소값만 기억해두면 문제가 쉽게 풀릴거라 생각했다.
*/

import java.util.*

class Solution {
    fun solution(a: IntArray): Int {
        // 구간 [0, i]에서의 최소값 = l[i]
        // 구간 [i, a.size)에서의 최소값 = r[i]
        val l = IntArray(a.size)
        val r = IntArray(a.size)

        var min = Int.MAX_VALUE
        for(i in a.indices) {
            min = min.coerceAtMost(a[i])
            l[i] = min
        }

        min = Int.MAX_VALUE
        for(i in a.indices.reversed()) {
            min = min.coerceAtMost(a[i])
            r[i] = min
        }


        var answer: Int = 0
        for(i in a.indices) {
            if(i == 0 || i == a.size-1) answer++
            else if(l[i] ==  a[i] || r[i] ==  a[i]) answer++
        }
        return answer
    }
}