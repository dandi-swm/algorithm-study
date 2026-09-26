package week9.인사고과.Vryez11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    /**
     *
     * [프로그래머스] 인사고과
     *
     * 문제 난이도: Lv3
     * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/152995
     * 풀이 시간: 50분
     * 풀이 근거: 완호 점수만 저장해놓고 scores를 내림차순 정렬시키고 무식하게 list에 인센티브 받을 수 있는 Score 다 저장, 이 후 안되는 것은 flag로 분기로 처내고 완호 점수일 때 바로 완호 점수로 가능한지 안한지 판별
     */
    public int solution(int[][] scores) {

        int score1 = scores[0][0];
        int score2 = scores[0][1];
        int wanhoScore = score1 + score2;

        Arrays.sort(scores, (a, b) -> {
            return Integer.compare(b[0]+ b[1], a[0] + a[1]);
        });

        int maxScore = scores[0][0] + scores[0][1];
        List<Score> list = new ArrayList<>();
        boolean flag;
        int ans = 0;

        if (wanhoScore == maxScore) {
            return 1;
        }

        for (int i = 0; i < scores.length; i++) {

            int sumScore = scores[i][0] + scores[i][1];
            flag = false;

            if (sumScore == maxScore) {
                list.add(new Score(scores[i][0], scores[i][1]));
                ans++;
                continue;
            }

            if (sumScore == wanhoScore) {
                scores[i][0] = score1;
                scores[i][1] = score2;
            }

            for (Score score : list) {
                if (score.score1 > scores[i][0] && score.score2 > scores[i][1]) {
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                list.add(new Score(scores[i][0], scores[i][1]));
                ans++;
            }

            if (sumScore == wanhoScore) {
                if (!flag) {
                    return ans;
                } else {
                    return -1;
                }
            }
        }

        return ans;
    }

    static class Score {
        int score1;
        int score2;

        Score(int score1, int score2) {

            this.score1 = score1;
            this.score2 = score2;
        }
    }
}
