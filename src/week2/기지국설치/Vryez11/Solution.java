package week2.기지국설치.Vryez11;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     *
     * [프로그래머스] 기지국 설치
     *
     * 문제 난이도: Lv.3
     * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12979
     * 풀이 시간: 30분
     * 풀이 근거: 처음에는 boolean[]로 풀이로 시간 초과 -> 문제 다시 보니, n의 값이  2억 이하 -> 이건 수학적으로 접근해야 된다. -> seq 연속된 것만 구해서 나눗셈 더하면 되겠네
     */

    public int solution(int n, int[] stations, int w) {

        int pre = 1, ans = 0;
        int range = (2 * w + 1);

        for (int station : stations) {

            int seq = station - w - pre;
            ans += getCount(seq, range);
            pre = station + w + 1;
        }

        return ans + getCount(n - pre + 1, range);
    }

    private int getCount(int seq, int range) {
        if (seq <= 0) return 0;
        return (seq + range - 1) / range;
    }
}
