package week9.바이러스파이프.Vryez11;

import java.util.*;

public class Solution {

    /**
     *
     * [프로그래머스] 바이러스 파이프
     *
     * 문제 난이도: Lv2
     * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/468373
     * 풀이 시간: 40분
     * 풀이 근거: 그냥 감염자 정보를 Set으로 관리하고 이 후에 감염자로부터 가능한 모든 배양체에 dfs()로 탐색해서 set에 넣어버리기. 단, dfs할 때 기존의 감염자 정보를 복사해야함. 결국 bfs와 dfs를 두개 다함.
     */
    public int solution(int n, int infection, int[][] edges, int k) {

        List<Node>[] lists = new List[n + 1];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int s = edge[0];
            int e = edge[1];
            int pipe = edge[2];

            lists[s].add(new Node(e, pipe));
            lists[e].add(new Node(s, pipe));
        }

        Queue<Current> queue = new ArrayDeque<>();
        for (int i = 1; i <= 3; i++) {

            Set<Integer> list = new HashSet<>();

            dfs(lists, list, i, infection);
            queue.offer(new Current(list, 1, i));
        }
        int ans = 0;
        while (!queue.isEmpty()) {

            Current now = queue.poll();

            if (now.count == k) {
                ans = Math.max(ans, now.infectionList.size());
                continue;
            }

            for (int i = 1; i <= 3; i++) {

                if (now.pipe == i) {
                    continue;
                }

                Set<Integer> infections = new HashSet<>(now.infectionList);

                for (Integer start : now.infectionList) {
                    dfs(lists, infections, i, start);
                }

                queue.offer(new Current(infections, now.count + 1, i));
            }
        }

        return ans;
    }

    private void dfs(List<Node>[] lists, Set<Integer> list, int pipe, int start) {

        for (Node node : lists[start]) {

            if (list.contains(node.idx)) {
                continue;
            }

            if (node.pipe == pipe) {
                list.add(node.idx);
                dfs(lists, list, pipe, node.idx);
            }
        }
    }

    static class Current {

        Set<Integer> infectionList;
        int count;
        int pipe;

        Current(Set<Integer> list, int count, int pipe) {
            this.infectionList = list;
            this.count = count;
            this.pipe = pipe;
        }
    }

    static class Node {

        int idx;
        int pipe;

        Node(int idx, int pipe) {

            this.idx = idx;
            this.pipe = pipe;
        }
    }
}
