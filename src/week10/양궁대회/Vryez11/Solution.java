package week10.양궁대회.Vryez11;

import java.util.*;

public class Solution {

    /**
     *
     * [프로그래머스] 양궁대회
     *
     * 문제 난이도: Lv2
     * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/92342
     * 풀이 시간:
     * 풀이 근거:
     */
    public int[] solution(int n, int[] info) {

        List<int[]> finishedShot = new ArrayList<>();
        Queue<Stage> queue = new ArrayDeque<>();

        if (info[0] < n) {
            int[] current = new int[11];
            current[0] = info[0] + 1;
            queue.add(new Stage(current, n - (info[0] + 1), 1));
        }
        queue.add(new Stage(new int[11], n, 1));

        while (!queue.isEmpty()) {

            Stage now = queue.poll();

            if (now.stage == 10) {
                int[] current = now.current.clone();
                current[now.stage] = now.count;

                finishedShot.add(current);
                continue;
            }

            if (info[now.stage] < now.count) {
                int[] current = now.current.clone();
                current[now.stage] = info[now.stage] + 1;
                queue.add(new Stage(current, now.count - (info[now.stage] + 1), now.stage + 1));
            }

            queue.add(new Stage(now.current.clone(), now.count, now.stage + 1));
        }

        return findAns(finishedShot, info);
    }

    private int[] findAns(List<int[]> list, int[] info) {

        int maxScore = 0;
        int[] ans = {-1};

        for (int[] now : list) {

            int scoreA = 0;
            int scoreB = 0;

            for (int i = 0; i < now.length; i++) {

                if (now[i] > info[i]) {
                    scoreA += (10 - i);
                    continue;
                }

                if (info[i] == 0) {
                    continue;
                }

                scoreB += (10 - i);
            }

            if (scoreB >= scoreA) continue;

            int temp = scoreA - scoreB;
            if (temp < maxScore) continue;

            if (temp > maxScore) {
                maxScore = temp;
                ans = now;
            } else {
                for (int i = 10; i >= 0; i--) {
                    if (now[i] == ans[i]) continue;
                    if (now[i] > ans[i]) {
                        ans = now;
                        break;
                    } else {
                        break;
                    }
                }
            }
        }

        return ans;
    }



    static class Stage {
        int[] current;
        int count;
        int stage;

        Stage(int[] current, int count, int stage) {
            this.current = current;
            this.count = count;
            this.stage = stage;
        }
    }
}
