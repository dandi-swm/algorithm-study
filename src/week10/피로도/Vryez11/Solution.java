package week10.피로도.Vryez11;

import java.util.Arrays;

public class Solution {

    /**
     *
     * [프로그래머스] 피로도
     *
     * 문제 난이도: Lv2
     * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/87946
     * 풀이 시간: 20분
     * 풀이 근거: 정렬해서 풀려고 했는데 아이디어가 안떠오르길래 다른 방법을 생각해봄. 문제에서 dungeons의 개수가 1 이상 8이하 라고 해서 그러면 그냥 dfs 깊이 탐색(백트래킹)으로 다 탐색해서 풀어야 겠다고 생각.
     */
    public int solution(int k, int[][] dungeons) {

        int ans = 0;

        for (int i = 0; i < dungeons.length; i++) {
            boolean[] visited = new boolean[dungeons.length];
            if (k >= dungeons[i][0]) {
                int count = dfs(dungeons, visited, i, k - dungeons[i][1], 1, 1);
                ans = Math.max(ans, count);
            }
        }

        return ans;
    }

    private int dfs(int[][] dungeons, boolean[] visited, int stage, int hp, int count, int max) {

        visited[stage] = true;

        for (int i = 0; i < dungeons.length; i++) {

            if (visited[i]) {
                continue;
            }

            if (hp < dungeons[i][0]) {
                continue;
            }

            max = dfs(dungeons, visited, i, hp - dungeons[i][1], count + 1, Math.max(count + 1, max));
        }

        visited[stage] = false;
        return max;
    }
}
