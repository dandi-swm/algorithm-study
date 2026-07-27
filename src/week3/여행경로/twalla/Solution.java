// ✏️ 프로그래머스 점프와 순간 이동

// 📶 문제 난이도
// Level 3

// 🔗 문제 링크
// https://school.programmers.co.kr/learn/courses/30/lessons/43164

// ⏱️ 풀이 시간
// 1시간

// ✅ 풀이 근거
// 노드가 아니라 엣지 자체에 visited를 매겨서 해결하는 문제
// 처음엔 모든 경로를 찾고 사전순으로 정렬했었는데,
// 그냥 tickets 배열을 정렬하고 가장 먼저 찾은 경로를 반환하면 더 간단하게 해결할 수 있었다!

package week3.여행경로.twalla;

import java.util.*;

class Solution {

    List<String> route;
    boolean[] visited;

    boolean dfs(String current, String[][] tickets, int count) {

        if (count == tickets.length) {
            return true;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(current)) {

                visited[i] = true;
                route.add(tickets[i][1]);

                if (dfs(tickets[i][1], tickets, count + 1)) {
                    return true;
                }

                visited[i] = false;
                route.remove(route.size() - 1);
            }
        }

        return false;
    }

    public String[] solution(String[][] tickets) {

        Arrays.sort(tickets, (o1, o2) -> {
            if (o1[0].equals(o2[0])) {
                return o1[1].compareTo(o2[1]);
            }
            return o1[0].compareTo(o2[0]);
        });

        route = new ArrayList<>();
        route.add("ICN");
        visited = new boolean[tickets.length];

        dfs("ICN", tickets, 0);

        return route.toArray(new String[0]);
    }
}
