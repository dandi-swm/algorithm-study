package week2.섬연결하기.Vryez11;

import java.util.Arrays;

public class Solution {

    /**
     *
     * [프로그래머스] 섬 연결하기
     *
     * 문제 난이도 : Lv. 3
     * 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42861
     * 풀이 시간 : 20분
     * 풀이 근거 : costs 배열을 cost로 정렬 / union-find로 연결된 섬 O(1)로 확인 
     */

    int[] parent;

    public int solution(int n, int[][] costs) {

        Arrays.sort(costs, (o1, o2) -> {
            return Integer.compare(o1[2], o2[2]);
        });

        int ans = 0;
        int line = 0;

        parent = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int[] cost : costs) {

            if (line == n - 1) break;

            int start = cost[0];
            int end = cost[1];

            if (find(start) == find(end)) continue;

            union(start, end);

            ans += cost[2];
            line++;
        }

        return ans;
    }

    private int find(int node) {

        if (parent[node] == node) return node;

        return parent[node] = find(parent[node]);
    }

    private void union(int start, int end) {

        int startParent = find(start);
        int endParent = find(end);

        if (startParent == endParent) return;

        if (startParent < endParent) {
            parent[startParent] = endParent;
        }

        if (startParent > endParent) {
            parent[endParent] = startParent;
        }
    }
}
