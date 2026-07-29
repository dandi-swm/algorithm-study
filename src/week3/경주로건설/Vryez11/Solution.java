package week3.경주로건설.Vryez11;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

    /**
     *
     * [프로그래머스] 경주로 건설
     *
     * 문제 난이도: Lv. 3
     * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/67259
     * 풀이 시간: 1시간 오바 (못품..)
     * 풀이 근거: 방향 관리와 최소 cost계산을 잘 못함..
     */

    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};

    static class Node {
        int x;
        int y;
        int dir;
        int cost;

        Node(int x, int y, int dir, int cost) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }
    }

    public int solution(int[][] board) {

        int n = board.length;
        int INF = Integer.MAX_VALUE;

        int[][][] cost = new int[n][n][4];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(cost[i][j], INF);
            }
        }

        PriorityQueue<Node> pq =
                new PriorityQueue<>((a, b) -> a.cost - b.cost);

        if (n > 1 && board[1][0] == 0) {
            cost[1][0][0] = 100;
            pq.offer(new Node(0, 1, 0, 100));
        }

        if (n > 1 && board[0][1] == 0) {
            cost[0][1][3] = 100;
            pq.offer(new Node(1, 0, 3, 100));
        }

        while (!pq.isEmpty()) {

            Node now = pq.poll();

            if (now.cost > cost[now.y][now.x][now.dir]) {
                continue;
            }

            if (now.x == n - 1 && now.y == n - 1) {
                return now.cost;
            }

            for (int nd = 0; nd < 4; nd++) {

                int nx = now.x + dx[nd];
                int ny = now.y + dy[nd];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }

                if (board[ny][nx] == 1) {
                    continue;
                }

                int nextCost = now.cost;

                if (now.dir == nd) {
                    nextCost += 100;
                } else {
                    nextCost += 600;
                }

                if (cost[ny][nx][nd] > nextCost) {
                    cost[ny][nx][nd] = nextCost;
                    pq.offer(new Node(nx, ny, nd, nextCost));
                }
            }
        }

        return 0;
    }
}