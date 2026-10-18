/*
## ✏️ [프로그래머스] 행렬의 곱셈

📶 문제 난이도
Lv. 2

🔗 문제 링크
https://school.programmers.co.kr/learn/courses/30/lessons/12949?language=kotlin

⏱️ 풀이 시간
20분

✅ 풀이 근거
반복문 문제
*/
class Solution {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {


        val N = arr1.size
        val M = arr2.size
        val P = arr2[0].size

        val answer = Array<IntArray>(N) { i ->
                IntArray(P) { j ->
                (0 until M).sumOf { k ->
                arr1[i][k] * arr2[k][j]
        }
            }
        }

        return answer
    }
}