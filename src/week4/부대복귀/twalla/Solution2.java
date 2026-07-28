package week4.부대복귀.twalla;

// ✏️ 프로그래머스 부대복귀

// 📶 문제 난이도
// Level 3

// 🔗 문제 링크
// https://school.programmers.co.kr/learn/courses/30/lessons/132266

// ⏱️ 풀이 시간
// 20분

// ✅ 풀이 근거
// destination을 역으로 시작점으로 생각하고 나머지 노드까지의 최단거리를 구하면
// 한번의 BFS로 해결할 수 있다!

import java.util.*;

public class Solution2 {

    int N;
    List<List<Integer>> graph;

    int[] bfs(int destination) {

        Queue<Integer> q = new ArrayDeque<>();
        q.add(destination);

        int[] costs = new int[N + 1];
        Arrays.fill(costs, -1);

        costs[destination] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next: graph.get(cur)) {

                if (costs[next] != -1) {
                    continue;
                }

                costs[next] = costs[cur] + 1;
                q.add(next);
            }
        }

        return costs;
    }

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {

        N = n;
        graph = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < roads.length; i++) {
            graph.get(roads[i][0]).add(roads[i][1]);
            graph.get(roads[i][1]).add(roads[i][0]);
        }

        int[] costs = bfs(destination);

        int[] answer = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            answer[i] = costs[sources[i]];
        }

        return answer;
    }
}
