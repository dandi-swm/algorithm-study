package week8.리코쳇로봇.twalla;

import java.util.*;

/*
## ✏️ [프로그래머스] 리코쳇 로봇

📶 문제 난이도
Lv. 2

🔗 문제 링크
https://school.programmers.co.kr/learn/courses/30/lessons/169199

⏱️ 풀이 시간
40분

✅ 풀이 근거
BFS로 board를 탐색하는 여느 문제와 비슷하지만
차이점은 말이 한칸씩 이동하는게 아니라 한 방향으로 쭉 나아간다는 점이었다.

따라서 visited를 관리할 때 최종 도착지에서만 true로 처리해주고,
이동은 장애물이 없는 한 while문으로 끝까지 이동하도록 처리해서 해결했다.

*/

public class Solution {

    int N;
    int M;

    // 상, 좌, 하, 우
    int[] di = new int[]{-1, 0, 1, 0};
    int[] dj = new int[]{0, -1, 0, 1};

    boolean isBound(int i, int j) {
        return (0 <= i && i < N) && (0 <= j && j < M);
    }

    public int solution(String[] board) {

        N = board.length;
        M = board[0].length();

        char[][] matrix = new char[N][M];
        int[] ready = new int[2];
        int[] goal = new int[2];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                char elem = board[i].charAt(j);
                matrix[i][j] = elem;

                if (elem == 'R') {
                    ready[0] = i;
                    ready[1] = j;
                } else if (elem == 'G') {
                    goal[0] = i;
                    goal[1] = j;
                }
            }
        }

        Queue<Robot> q = new ArrayDeque<>();
        q.add(new Robot(ready, 0));

        boolean[][] visited = new boolean[N][M];
        visited[ready[0]][ready[1]] = true;

        while (!q.isEmpty()) {

            Robot cur = q.poll();

            // 이동
            for (int d = 0; d < 4; d++) {

                int ni = cur.pos[0], nj = cur.pos[1];
                while (isBound(ni + di[d], nj + dj[d])
                        && matrix[ni + di[d]][nj + dj[d]] != 'D') {
                    ni += di[d];
                    nj += dj[d];
                }

                if (visited[ni][nj]) {
                    continue;
                }

                if (ni == goal[0] && nj == goal[1]) {
                    return cur.count + 1;
                }

                visited[ni][nj] = true;
                q.add(new Robot(new int[]{ni, nj}, cur.count + 1));

            }
        }

        return -1;
    }
}

class Robot {
    int[] pos;
    int count;

    public Robot(int[] pos, int count) {
        this.pos = pos;
        this.count = count;
    }
}