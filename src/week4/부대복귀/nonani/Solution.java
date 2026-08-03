/*
## ✏️ [프로그래머스] 부대 복귀
📶 문제 난이도
Lv. 3

🔗 문제 링크
https://school.programmers.co.kr/learn/courses/30/lessons/132266

⏱️ 풀이 시간
30분

✅ 풀이 근거
[source] -> destination 출발지는 여럿인데 목적지는 하나이다.
이러면 출발지마다 목적지를 탐색하는 것이 아닌
목적지 노드로부터 모든 노드의 최단거리를 구하게 하는 다익스트라 알고리즘을 쓰는 것이 좋을 것이다.

*/

import java.util.*;


class Solution {
    static ArrayList<Integer>[] graph; // 그래프를 인접 리스트로 저장
    static int[] answer; // 최종 결과를 저장할 배열
    static int[] min; // 목적지로부터 각 정점까지의 최단 거리를 저장할 배열

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        answer = new int[sources.length];

        for (int i = 0; i < roads.length; i++) {
            int a = roads[i][0];
            int b = roads[i][1];
            graph[a].add(b);
            graph[b].add(a);
        }
        min = new int[n + 1];
        Arrays.fill(min, Integer.MAX_VALUE);
        search(destination); // 목적지에서 다익스트라로 탐색

        for (int i = 0; i < sources.length; i++) {
            if (min[sources[i]] == Integer.MAX_VALUE)
                answer[i] = -1;
            else
                answer[i] = min[sources[i]];
        }

        return answer;
    }

    public static void search(int s) { // 목적지에서 출발하는 다익스트라
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        min[s] = 0; // 목적지까지의 거리는 0
        q.add(new int[]{s, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (min[cur[0]] != cur[1])
                continue;
            for (int i = 0; i < graph[cur[0]].size(); i++) {
                int next = graph[cur[0]].get(i);
                if (min[next] > cur[1] + 1) { // 더 짧은 곳을 찾은 경우
                    min[next] = cur[1] + 1;
                    q.add(new int[]{next, cur[1] + 1}); // 다음 정점으로
                }
            }
        }
    }
}