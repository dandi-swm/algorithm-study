package week3.경주로건설.twalla;

// ✏️ 프로그래머스 경주로 건설

// 📶 문제 난이도
// Level 3

// 🔗 문제 링크
// https://school.programmers.co.kr/learn/courses/30/lessons/67259

// ⏱️ 풀이 시간
// 1시간

// ✅ 풀이 근거
// 최소 비용 경로를 찾아야 하기에 DFS보단 BFS가 더 유리할 것이라고 판단
// 기존 문제와 달랐던 점은 이전 방향을 기억하고 그에 맞는 비용을 각각 계산해줘야 했었음.


import java.util.*;

public class Solution {

    int N, min = Integer.MAX_VALUE;
    int[][] Board;

    // up, left, down, right
    int[] di = new int[]{-1, 0, 1, 0};
    int[] dj = new int[]{0, -1, 0, 1};

    int[][][] costs;

    int bfs() {

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 0, -1));

        costs = new int[N][N][4];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(costs[i][j], Integer.MAX_VALUE);
            }
        }

        while (!q.isEmpty()) {

            Node cur = q.poll();

            if (cur.i == N - 1 && cur.j == N - 1) {
                min = Math.min(min, cur.cost);
                continue;
            }

            for (int d = 0; d < 4; d++) {
                int ni = cur.i + di[d];
                int nj = cur.j + dj[d];

                if (!isBound(ni, nj) || Board[ni][nj] == 1) {
                    continue;
                }

                int ncost = 0;
                if (cur.d == -1 || cur.d == d) {
                    ncost = cur.cost + 100;
                } else {
                    ncost = cur.cost + 600;
                }

                if (costs[ni][nj][d] > ncost) {
                    costs[ni][nj][d] = ncost;
                    q.add(new Node(ni, nj, ncost, d));
                }
            }
        }

        return min;
    }

    boolean isBound(int i, int j) {
        return (0 <= i && i < N) && (0 <= j && j < N);
    }

    public int solution(int[][] board) {

        N = board.length;
        Board = board;

        int answer = bfs();

        return answer;
    }
}

class Node {
    int i;
    int j;
    int cost;
    int d;

    public Node(int i, int j, int cost, int d) {
        this.i = i;
        this.j = j;
        this.cost = cost;
        this.d = d;
    }
}
