/*
## ✏️ [프로그래머스] 파괴되지 않은 건물
📶 문제 난이도
Lv. 3

🔗 문제 링크
https://school.programmers.co.kr/learn/courses/30/lessons/92344

⏱️ 풀이 시간
20분 인줄 알았던 1시간

✅ 풀이 근거
각 스킬의 직사각형 범위 갱신을 2차원 누적합 배열의 네 꼭짓점에만 기록한 뒤, 가로/세로 누적합으로 최종 변화량을 복원한다.
*/

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int N = board.length;
        int M = board[0].length;
        int[][] dp = new int[N+1][M+1];
        for(int[] cmd : skill) {
            int type = cmd[0];
            int r1 = cmd[1];
            int c1 = cmd[2];
            int r2 = cmd[3];
            int c2 = cmd[4];
            int degree = cmd[5];
            
            if(type == 1) {
             degree= -degree;
            }
            dp[r1][c1]+=degree;
            dp[r1][c2+1]-=degree;
            dp[r2+1][c1]-=degree;
            dp[r2+1][c2+1]+=degree;
            
        }
        // 가로 누적합
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < M; j++) {
                dp[i][j] += dp[i][j - 1];
            }
        }

        // 세로 누적합
        for (int j = 0; j < M; j++) {
            for (int i = 1; i < N; i++) {
                dp[i][j] += dp[i - 1][j];
            }
        }



        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] + dp[i][j] > 0) {
                    answer++;
                }
            }
        }

        return answer;
    }
    
}

/*
이전 오답 풀이
class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;

        for(int[] cmd : skill) {
            int type = cmd[0];
            if(type == 1)
                modifyBoard(board, cmd[1], cmd[2], cmd[3], cmd[4], -cmd[5]);
            else
                modifyBoard(board, cmd[1], cmd[2], cmd[3], cmd[4], cmd[5]);
        }


        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[i].length;j++) {
                if(board[i][j] > 0)
                    answer++;
            }
        }
        return answer;
    }

    private void modifyBoard(int[][] board, int x1, int y1, int x2, int y2, int degree) {

        for(int i = x1; i <= x2; i++) {
            for(int j = y1; j <= y2; j++) {
                board[i][j] += degree;
            }
        }

    }
}
*/