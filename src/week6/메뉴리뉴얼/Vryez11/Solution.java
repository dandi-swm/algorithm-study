package week6.메뉴리뉴얼.Vryez11;

import java.util.*;

public class Solution {

    /**
     *
     * [프로그래머스] 메뉴 리뉴얼
     *
     * 문제 난이도: Lv2
     * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/72411
     * 풀이 시간: 1시간
     * 풀이 근거: 못풀었습니다.. 비트마스킹으로 풀어보려고 했는데 조합 만드는 것에 벽을 느끼고 답을 봐버렸습니다.. 그래도 다음에 풀면 풀 수 있을듯...?
     */
    public String[] solution(String[] orders, int[] course) {

        int[] binaryOrders = new int[orders.length];

        for (int i = 0; i < orders.length; i++) {
            for (char c : orders[i].toCharArray()) {

                int idx = c - 'A';

                binaryOrders[i] |= (1 << idx);
            }
        }

        List<String> ans = new ArrayList<>();

        for (int count : course) {

            Map<Integer, Integer> map = new HashMap<>();

            for (int orderMask : binaryOrders) {

                if (Integer.bitCount(orderMask) < count) {
                    continue;
                }

                makeCombination(orderMask, 0, count, 0, map);
            }

            int max = map.values().stream()
                        .max(Integer::compare)
                        .orElse(-1);

            if (max < 2) {
                continue;
            }

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

                if (entry.getValue() == max) {
                    ans.add(maskToString(entry.getKey()));
                }
            }
        }

        Collections.sort(ans);

        return ans.toArray(new String[0]);
    }

    private void makeCombination(int orderMask, int start, int count, int selectedMask, Map<Integer, Integer> map) {

        if (count == 0) {
            map.put(
                    selectedMask,
                    map.getOrDefault(selectedMask, 0) + 1
            );
            return;
        }

        for (int i = start; i < 26; i++) {

            if ((orderMask & (1 << i)) == 0) {
                continue;
            }

            makeCombination(orderMask, i + 1, count - 1, selectedMask | (1 << i), map);
        }
    }

    private String maskToString(int mask) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 26; i++) {

            if ((mask & (1 << i)) != 0) {
                sb.append((char) ('A' + i));
            }
        }

        return sb.toString();
    }
}
