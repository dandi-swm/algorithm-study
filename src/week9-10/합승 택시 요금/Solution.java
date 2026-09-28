/*
완전 탐색하면 3^10인데 이게 59049이라서 완탐해도 될것같음

한번 딸깍할때마다 그럼 모든 노드를 확인해서 감염되었는지 본다고하면
3^10 * (모든 노드 방문하는 비용) = 5904900 이므로 크게 문제없을듯?


*/
import java.util.*;

class Edge {
    int next;
    int type;

    Edge(int next, int type) {
        this.next = next;
        this.type = type;
    }
}

class Solution {

    List<Edge>[] graph;
    int answer;
    int k;

    public int solution(int n, int infection, int[][] edges, int k) {
        this.k = k;

        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            int type = edge[2];

            graph[a].add(new Edge(b, type));
            graph[b].add(new Edge(a, type));
        }

        Set<Integer> infected = new HashSet<>();
        infected.add(infection);

        dfs(0, infected);

        return answer;
    }

    private void dfs(int depth, Set<Integer> infected) {

        if (depth == k) {
            answer = Math.max(answer, infected.size());
            return;
        }

        for (int type = 1; type <= 3; type++) {

            // 현재 DFS 상태 복사
            Set<Integer> nextInfected = new HashSet<>(infected);

            spread(type, nextInfected);

            dfs(depth + 1, nextInfected);
        }
    }

    private void spread(int type, Set<Integer> infected) {

        Queue<Integer> q = new ArrayDeque<>();

        // 현재 감염된 모든 노드에서 출발
        for (int node : infected) {
            q.add(node);
        }

        while (!q.isEmpty()) {

            int cur = q.poll();

            for (Edge edge : graph[cur]) {

                // 지금 연 파이프 타입만 이동 가능
                if (edge.type != type) {
                    continue;
                }

                if (infected.add(edge.next)) {
                    q.add(edge.next);
                }
            }
        }
    }
}