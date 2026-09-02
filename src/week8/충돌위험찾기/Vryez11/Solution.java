package week8.충돌위험찾기.Vryez11;

import java.util.*;

public class Solution {

    /**
     *
     * [프로그래머스] 충돌위험 찾기
     *
     * 문제 난이도: Lv2
     * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/340211
     * 풀이 시간: 1시간
     * 풀이 근거: 각 Robot 객체는 자기 위치 / 포인트 / 몇 번 움직였는지 알고 있음 ->
     *          queue에서 첫 Robot의 step이 같을 때, conflict 개수 확인 ->
     *          움직이기 ->
     *          board에 현재 위치 동기화 ->
     *          목표지점에 다다르면 삭제 ->
     *          목표 리스트가 비어있으면 queue에 다시 넣지 않기위해 Optional.empty()로 반환
     *
     *          위와 같은 흐름으로 구현했습니당
     */
    public int solution(int[][] points, int[][] routes) {

        int[][] board = new int[101][101];

        Queue<Robot> queue = new ArrayDeque<>();

        for (int[] route : routes) {

            Robot robot = new Robot(0, points[route[0] - 1][0], points[route[0] - 1][1]);
            board[robot.r][robot.c]++;

            for (int i = 1; i < route.length; i++) {

                robot.list.add(new Point(points[route[i] - 1][0], points[route[i] - 1][1]));
            }

            queue.offer(robot);
        }

        int ans = 0;
        int step = 0;
        while (!queue.isEmpty()) {

            Robot now = queue.poll();

            if (step == now.step) {

                ans += findConflictCount(board);
                step++;
            }

            Optional<Robot> next = moveRobot(now, board);

            if (next.isPresent()) {
                queue.offer(next.get());
            }
        }

        return ans;
    }

    private Optional<Robot> moveRobot(Robot robot, int[][] board) {

        if (robot.list.isEmpty()) {
            board[robot.r][robot.c]--;
            return Optional.empty();
        }

        Point goal = robot.list.get(0);

        int currentR = robot.r;
        int currentC = robot.c;

        board[currentR][currentC]--;

        int nextR = currentR;
        int nextC = currentC;

        if (currentR != goal.r) {
            nextR = goal.r > currentR ? currentR + 1 : currentR - 1;
        } else {
            nextC = goal.c > currentC ? currentC + 1 : currentC - 1;
        }

        board[nextR][nextC]++;

        if (nextR == goal.r && nextC == goal.c) {

            robot.list.remove(0);
        }

        return Optional.of(new Robot(robot.step + 1, nextR, nextC, robot.list));
    }

    private int findConflictCount(int[][] board) {

        int count = 0;

        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {

                if (board[i][j] > 1) {
                    count++;
                }
            }
        }

        return count;
    }

    static class Robot {

        List<Point> list;
        int step;
        int r;
        int c;

        Robot(int step, int r, int c) {

            this.list = new ArrayList<>();
            this.step = step;
            this.r = r;
            this.c = c;
        }

        Robot(int step, int r, int c, List<Point> list) {

            this.list = list;
            this.step = step;
            this.r = r;
            this.c = c;
        }
    }

    static class Point {

        int r;
        int c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
