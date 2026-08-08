import java.util.LinkedList

/*
## ✏️ [프로그래머스] 가장 먼 노드
📶 문제 난이도
Lv. 3

🔗 문제 링크
https://school.programmers.co.kr/learn/courses/30/lessons/49189

⏱️ 풀이 시간
30분

✅ 풀이 근거
bfs로 탐색을 하면서 거리가 늘어나면 세트를 초기하고 최대거리랑 같은 애들을 세트로 관리하는 식!
kotlin으로 풀어보고 있는데 편한듯 불편하다..ㅎ
*/


class Solution {
    fun solution(n: Int, edge: Array<IntArray>): Int {
        val graph = Array(n + 1) { ArrayList<Int>() }

        for ((a, b) in edge) {
            graph[a].add(b)
            graph[b].add(a)
        }

        // 1부터 bfs
        val visited = mutableSetOf<Int>(1)
        val queue = LinkedList<Pair<Int, Int>>() // (next, dist)

        var maxDist = -1
        var answerSet = mutableSetOf<Int>()
        queue.offer(Pair(1, 0))
        while (queue.isNotEmpty()) {
            val (cur, dist) = queue.poll()
            if (dist > maxDist) {
                maxDist = dist
                answerSet = mutableSetOf<Int>()
                answerSet.add(cur)
            }
            if (dist == maxDist) {
                answerSet.add(cur)
            }

            for (next in graph[cur]) {
                if (!visited.contains(next)) {
                    queue.offer(Pair(next, dist + 1))
                    visited.add(next)
                }
            }


        }
        return answerSet.size
    }
}

fun main() {

}
