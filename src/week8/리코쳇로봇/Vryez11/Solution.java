package week8.리코쳇로봇.Vryez11;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {

    /**
     *
     * [프로그래머스] 리코쳇 로봇
     *
     * 문제 난이도: Lv2
     * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/169199
     * 풀이 시간: 30분
     * 풀이 근거: 현재 블록이 방문한 적이 있는지 확인 및 없으면 동서남북 이동 / BFS 풀이
     */

    char[][] gameBoard;

    public int solution(String[] board) {

        gameBoard = new char[board.length][board[0].length()];

        int[] RPoint = new int[2];

        for (int i = 0; i < board.length; i++) {

            char[] elementsArr = board[i].toCharArray();

            for (int j = 0; j < elementsArr.length; j++) {

                gameBoard[i][j] = elementsArr[j];

                if (elementsArr[j] == 'R') {
                    RPoint[0] = i;
                    RPoint[1] = j;
                }
            }
        }

        boolean[][] isVisited =
                new boolean[gameBoard.length][gameBoard[0].length];

        Queue<Node> queue = new ArrayDeque<>();

        queue.offer(new Node(RPoint[1], RPoint[0], 0));
        isVisited[RPoint[0]][RPoint[1]] = true;

        while (!queue.isEmpty()) {

            Node now = queue.poll();

            if (gameBoard[now.y][now.x] == 'G') {
                return now.count;
            }

            Node nextN = moveNorth(now.y, now.x);

            if (!isVisited[nextN.y][nextN.x]) {
                isVisited[nextN.y][nextN.x] = true;
                queue.offer(new Node(nextN.x, nextN.y, now.count + 1));
            }

            Node nextS = moveSouth(now.y, now.x);

            if (!isVisited[nextS.y][nextS.x]) {
                isVisited[nextS.y][nextS.x] = true;
                queue.offer(new Node(nextS.x, nextS.y, now.count + 1));
            }

            Node nextE = moveEast(now.y, now.x);

            if (!isVisited[nextE.y][nextE.x]) {
                isVisited[nextE.y][nextE.x] = true;
                queue.offer(new Node(nextE.x, nextE.y, now.count + 1));
            }

            Node nextW = moveWest(now.y, now.x);

            if (!isVisited[nextW.y][nextW.x]) {
                isVisited[nextW.y][nextW.x] = true;
                queue.offer(new Node(nextW.x, nextW.y, now.count + 1));
            }
        }

        return -1;
    }

    private Node moveNorth(int y, int x) {

        while (y > 0 && gameBoard[y - 1][x] != 'D') {
            y--;
        }

        return new Node(x, y, 0);
    }

    private Node moveSouth(int y, int x) {

        while (y < gameBoard.length - 1
                && gameBoard[y + 1][x] != 'D') {
            y++;
        }

        return new Node(x, y, 0);
    }

    private Node moveEast(int y, int x) {

        while (x < gameBoard[0].length - 1
                && gameBoard[y][x + 1] != 'D') {
            x++;
        }

        return new Node(x, y, 0);
    }

    private Node moveWest(int y, int x) {

        while (x > 0 && gameBoard[y][x - 1] != 'D') {
            x--;
        }

        return new Node(x, y, 0);
    }

    static class Node {

        int x;
        int y;
        int count;

        Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}