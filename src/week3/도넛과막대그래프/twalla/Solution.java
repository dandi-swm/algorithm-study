package week3.도넛과막대그래프.twalla;

import java.util.*;

public class Solution {

    public int[] solution(int[][] edges) {

        int N = 1_000_000;

        boolean[] exists = new boolean[N + 1];

        int[] indegree = new int[N + 1];
        int[] outdegree = new int[N + 1];

        for (int i = 0; i < edges.length; i++) {
            int s = edges[i][0];
            int e = edges[i][1];

            outdegree[s] += 1;
            indegree[e] += 1;

            exists[s] = true;
            exists[e] = true;
        }

        int donut = 0, bar = 0, eight = 0, total = 0, mid = 0;
        for (int i = 1; i < N + 1; i++) {

            if (!exists[i]) {
                continue;
            }

            if (indegree[i] == 0 && outdegree[i] >= 2) {
                total = outdegree[i];
                mid = i;
            } else if (indegree[i] >= 2 && outdegree[i] >= 2) {
                eight += 1;
            } else if (outdegree[i] == 0) {
                bar += 1;
            }
        }

        donut = total - bar - eight;

        int[] answer = new int[]{mid, donut, bar, eight};

        return answer;
    }
}
