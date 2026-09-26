package week11.풍선터트리기.Vryez11;

public class Solution {

    /**
     *
     * [프로그래머스] 풍선 터트리기
     *
     * 문제 난이도: Lv3
     * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/68646
     * 풀이 시간: 30분
     * 풀이 근거: 특정 풍선보다 작은 값이 왼쪽과 오른쪽에 모두 존재하면 작은 풍선을 두 번 제거해야 하므로 풍선은 살아남을 수 없음.
     */
    public int solution(int[] a) {

        int n = a.length;

        boolean[] possible = new boolean[n];

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (a[i] < min) {
                possible[i] = true;
                min = a[i];
            }
        }

        min = Integer.MAX_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            if (a[i] < min) {
                possible[i] = true;
                min = a[i];
            }
        }

        int ans = 0;

        for (boolean can : possible) {
            if (can) {
                ans++;
            }
        }

        return ans;
    }
}
