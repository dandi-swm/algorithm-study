package week3.도넛과막대그래프;


class Solution {

    /**
     *
     * [프로그래머스] 도넛과 막대 그래프
     *
     * 문제 난이도: Lv 2
     * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/258711
     * 풀이 시간: 못 품..
     * 풀이 근거: 문제를 잘 읽자.., in, out 생각을 못했습니다...
     */

    public int[] solution(int[][] edges) {

        int max = 0;

        for (int[] edge : edges) {
            max = Math.max(max, Math.max(edge[0], edge[1]));
        }

        int[] in = new int[max + 1];
        int[] out = new int[max + 1];

        for (int[] edge : edges) {
            out[edge[0]]++;
            in[edge[1]]++;
        }

        int create = 0;
        int stick = 0;
        int eight = 0;

        for (int i = 1; i <= max; i++) {

            if (in[i] == 0 && out[i] >= 2) {
                create = i;
            }

            if (in[i] >= 1 && out[i] == 0) {
                stick++;
            }

            if (in[i] >= 2 && out[i] == 2) {
                eight++;
            }
        }

        int donut = out[create] - stick - eight;

        return new int[]{create, donut, stick, eight};
    }
}
