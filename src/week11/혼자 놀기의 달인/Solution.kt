/*
## ✏️ [프로그래머스] 혼자 놀기의 달인

📶 문제 난이도
Lv. 2

🔗 문제 링크
https://school.programmers.co.kr/learn/courses/30/lessons/131130

⏱️ 풀이 시간
20분

✅ 풀이 근거
싸이클을 구하면 되는문제였다
*/


class Solution {
    fun solution(cards: IntArray): Int {
        val N = cards.size
        val visited = BooleanArray(N) { false }
        val groups = mutableListOf<Int>()

        for (i in 0..<N) {
            if (!visited[i]) {
                groups.add(dfs(i, cards, visited))
            }
        }

        // 그룹이 하나뿐이면 2번 상자 그룹이 없으므로 0점
        if (groups.size < 2) return 0

        groups.sortDescending()
        return groups[0] * groups[1]
    }

    // index 상자부터 따라가며 이번 사이클에 속한 상자 수를 센다
    fun dfs(index: Int, cards: IntArray, visited: BooleanArray): Int {
        if (visited[index]) return 0
        visited[index] = true
        return 1 + dfs(cards[index] - 1, cards, visited)
    }
}