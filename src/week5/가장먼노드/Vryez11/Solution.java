package week5.가장먼노드.Vryez11;

import java.util.*;

public class Solution {

    /**
     *
     * [프로그래머스] 가장 먼 노드
     *
     * 문제 난이도: Lv.3
     * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/49189
     * 풀이 시간: 15분
     * 풀이 근거: BFS로 최적의 접근 방법으로 maxDepth계산하고 visited로 마지막에 찾기. 마지막 skip(1)은 0노드를 제외하기 위해서!
     */

    public int solution(int n, int[][] edge) {

        List<Integer>[] lists = new List[n];
        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int[] node : edge) {
            int start = node[0] - 1;
            int end = node[1] - 1;

            lists[start].add(end);
            lists[end].add(start);
        }

        int[] visited = new int[n];
        int maxDepth = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);

        while (!queue.isEmpty()) {

            Integer now = queue.poll();

            for (Integer next : lists[now]) {

                if (visited[next] != 0) {
                    continue;
                }

                queue.offer(next);
                visited[next] = visited[now] + 1;
                maxDepth = Math.max(maxDepth, visited[next]);
            }
        }

        int finalMaxDepth = maxDepth;
        return (int) Arrays.stream(visited)
                .skip(1)
                .filter(v -> v == finalMaxDepth)
                .count();
    }
}
