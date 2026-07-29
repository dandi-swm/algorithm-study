package week3.여행결로.Vryez11;

import java.util.*;

public class Solution {

    /**
     *
     * [프로그래머스] 여행경로
     *
     * 문제 난이도: LV. 3
     * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/43164
     * 풀이 시간: 30분
     * 풀이 근거: 티켓을 먼저 정렬시켜서, 한 공항에서 다른 여러 공항이 있을 때, 사전 순으로 가도록 함. 그 다음 dfs로 해결
     */

    private Map<String, Integer> portNumMap;
    private List<Integer>[] lists;

    public String[] solution(String[][] tickets) {

        Arrays.sort(tickets, (o1, o2) -> {
            if (o1[0].equals(o2[0])) {
                return o1[1].compareTo(o2[1]);
            }
            return o1[0].compareTo(o2[0]);
        });

        portNumMap = new HashMap<>();
        int idx = 0;

        for (String[] ticket : tickets) {

            if (!portNumMap.containsKey(ticket[0])) {
                portNumMap.put(ticket[0], idx++);
            }

            if (!portNumMap.containsKey(ticket[1])) {
                portNumMap.put(ticket[1], idx++);
            }
        }

        lists = new ArrayList[idx];

        for (int i = 0; i < idx; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < tickets.length; i++) {
            int from = portNumMap.get(tickets[i][0]);
            lists[from].add(i);
        }

        boolean[] visited = new boolean[tickets.length];
        List<String> answer = new ArrayList<>();

        dfs("ICN", 0, tickets, visited, answer);

        return answer.toArray(new String[0]);
    }

    private boolean dfs(String now,
                        int depth,
                        String[][] tickets,
                        boolean[] visited,
                        List<String> answer) {

        answer.add(now);

        if (depth == tickets.length) {
            return true;
        }

        Integer nowNum = portNumMap.get(now);

        if (nowNum == null) {
            answer.remove(answer.size() - 1);
            return false;
        }

        for (int ticketIdx : lists[nowNum]) {

            if (visited[ticketIdx]) {
                continue;
            }

            visited[ticketIdx] = true;

            if (dfs(tickets[ticketIdx][1],
                    depth + 1,
                    tickets,
                    visited,
                    answer)) {
                return true;
            }

            visited[ticketIdx] = false;
        }

        answer.remove(answer.size() - 1);

        return false;
    }
}