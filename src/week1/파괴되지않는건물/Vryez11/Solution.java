package week1.파괴되지않는건물.Vryez11;

public class Solution {

    /**
     *
     * 파괴 도지 않는 건물
     *
     * 문제 난이도 : Lv3
     * 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/92344
     * 풀이 시간 : 50분
     * 풀이 근거 : 직접 board에 계산하는 것이 아닌, 각 행에 대한 action 값을 누적
     */

    public int solution(int[][] board, int[][] skill) {

        int[][] actionArr = new int[board.length + 1][board[0].length + 1];

        for (int[] action : skill) {
            int type = action[0];
            int r1 = action[1];
            int c1 = action[2];
            int r2 = action[3];
            int c2 = action[4];
            int degree = type == 2? action[5] : action[5] * (-1);

            actionArr[r1][c1] += degree;

            if (c2 + 1 < board[0].length) {
                actionArr[r1][c2 + 1] -= degree;
            }

            if (r2 + 1 < board.length) {
                actionArr[r2 + 1][c1] -= degree;
            }

            if (r2 + 1 < board.length && c2 + 1 < board[0].length) {
                actionArr[r2 + 1][c2 + 1] += degree;
            }
        }


        for (int i = 0; i < board.length; i++) {
            for (int j = 1; j < board[0].length; j++) {
                actionArr[i][j] += actionArr[i][j - 1];
            }
        }
        for (int j = 0; j < board[0].length; j++) {
            for (int i = 1; i < board.length; i++) {
                actionArr[i][j] += actionArr[i - 1][j];
            }
        }

        int ans = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                ans += board[i][j] + actionArr[i][j] > 0 ? 1 : 0;
            }
        }

        return ans;
    }
}
