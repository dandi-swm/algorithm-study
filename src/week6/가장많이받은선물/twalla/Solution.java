package week6.가장많이받은선물.twalla;

import java.util.*;

public class Solution {
    public int solution(String[] friends, String[] gifts) {

        int N = friends.length;
        int M = gifts.length;

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(friends[i], i);
        }

        int[][] giftTable = new int[N][N];
        int[][] giftPower = new int[N][3];

        for (int i = 0; i < M; i++) {
            String[] record = gifts[i].split(" ");
            String a = record[0];
            String b = record[1];

            int indexA = map.get(a);
            int indexB = map.get(b);

            giftTable[indexA][indexB] += 1;
            giftPower[indexA][0] += 1;
            giftPower[indexB][1] += 1;
            giftPower[indexA][2] += 1;
            giftPower[indexB][2] -= 1;
        }

        int[] result = new int[N];

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (giftTable[i][j] > giftTable[j][i]) {
                    result[i] += 1;
                } else if (giftTable[i][j] < giftTable[j][i]) {
                    result[j] += 1;
                } else {
                    if (giftPower[i][2] > giftPower[j][2]) {
                        result[i] += 1;
                    } else if (giftPower[i][2] < giftPower[j][2]) {
                        result[j] += 1;
                    }
                }
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, result[i]);
        }

        return max;
    }
}
