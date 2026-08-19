package week6.가장많이받은선물.Vryez11;

import java.util.HashMap;

public class Solution {

    /**
     *
     * [프로그래머스] 가장 많이 받은 선물
     *
     * 문제 난이도: Lv2
     * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/258712
     * 풀이 시간: 40분
     * 풀이 근거: map에 값으로 [자신의 인덱스, 준 횟수, 받은 횟수] 저장, isGifted는 각 친구끼리 주고받은 횟수, 따라서 크면 받는 거, 0이면 선물 점수 비교
     */
    public int solution(String[] friends, String[] gifts) {

        int[][] isGifted = new int[friends.length][friends.length];

        HashMap<String, int[]> map = new HashMap<>();
        for (int i = 0; i < friends.length; i++) {

            int[] arr = new int[]{i, 0, 0};
            map.put(friends[i], arr);
        }

        for (String gift : gifts) {

            String[] split = gift.split(" ");
            String sender = split[0];
            String receiver = split[1];

            map.get(sender)[1]++;
            map.get(receiver)[2]++;

            isGifted[map.get(sender)[0]][map.get(receiver)[0]]++;
            isGifted[map.get(receiver)[0]][map.get(sender)[0]]--;
        }

        int ans = 0;

        for(int i = 0; i < friends.length; i++) {
            int score = 0;

            for (int j = 0; j < friends.length; j++) {

                if (i == j) {
                    continue;
                }

                if (isGifted[i][j] > 0) {
                    score++;
                } else if (isGifted[i][j] == 0){
                    int sendScore = map.get(friends[i])[1] - map.get(friends[i])[2];
                    int receiverScore = map.get(friends[j])[1] - map.get(friends[j])[2];

                    if (sendScore > receiverScore) score++;
                }
            }

            ans = Math.max(ans, score);
        }

        return ans;
    }
}
