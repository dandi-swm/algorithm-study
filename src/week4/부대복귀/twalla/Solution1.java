package week4.부대복귀.twalla;

// ✏️ 프로그래머스 부대복귀

// 📶 문제 난이도
// Level 3

// 🔗 문제 링크
// https://school.programmers.co.kr/learn/courses/30/lessons/132266

// ⏱️ 풀이 시간
// 20분

// ✅ 풀이 근거
// 처음엔 플로이드 워셜인가? 라고 생각했는데, 노드의 개수가 10만개이므로 메모리 초과가 날 것이라고 판단함.
// 그 다음 생각한 방식이 아래의 코드, 각 source마다 BFS 돌리기
// 시간 초과는 안났지만, 굉장히 느리다고 판단함.
// 다음 코드에서 destination에서 시작하는 방향으로 개선

import java.util.*;

public class Solution1 {

    int N;
    List<List<Integer>> graph;

    int bfs(int source, int destination) {

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(source, 0));

        boolean[] visited = new boolean[N + 1];
        visited[source] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.index == destination) {
                return cur.cost;
            }

            for (int next: graph.get(cur.index)) {

                if (visited[next]) {
                    continue;
                }

                q.add(new Node(next, cur.cost + 1));
                visited[next] = true;
            }
        }

        return -1;
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

        int[] answer = new int[sources.length];

        for (int i = 0; i < sources.length; i++) {
            int source = sources[i];
            answer[i] = bfs(source, destination);
        }

        return answer;
    }
}

class Node {
    int index;
    int cost;

    public Node(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }
}