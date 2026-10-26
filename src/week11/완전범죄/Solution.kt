/*
## ✏️ [프로그래머스] 완전 범죄

📶 문제 난이도
Lv. 2

🔗 문제 링크
https://school.programmers.co.kr/learn/courses/30/lessons/389480

⏱️ 풀이 시간
못풀었어요

✅ 풀이 근거
dp 너무 어렵다...
2^40밖에 안 떠올랐음
이제 i번째까지 갈때의 각 가능한 경우를 [i][n][m] 에 메모 해두는 방식으로 담부터는 비슷한거
나왔을때 시도해봐야곘다
*/

class Solution {
    fun solution(info: Array<IntArray>, N: Int, M: Int): Int {
        val I = info.size
        val dp = Array<Array<BooleanArray>>(I){
            Array<BooleanArray>(N) {
                BooleanArray(M)
            }
        }
        // dp[I][n][m] -> i번째 까지 훔쳤을 때 누적 상태로 있을 수 있는 경우

        if(info[0][0] < N)
            dp[0][info[0][0]][0] = true
        if(info[0][1] < M)
            dp[0][0][info[0][1]] = true

        for(i in 1..<I) {
            // i 번째를 훔칠때 A, B가 남기는 흔적 수
            val A = info[i][0]
            val B = info[i][1]

            for(n in 0..<N) {
                for(m in 0..<M) {
                    if(dp[i-1][n][m]) {
                        if(n + A < N) dp[i][n + A][m] = true
                        if(m + B < M) dp[i][n][m + B] = true
                    }
                }
            }
        }

        for(n in 0..<N) {
            for(m in 0..<M) {
                if(dp[I-1][n][m])
                    return n
            }
        }



        return -1
    }
}