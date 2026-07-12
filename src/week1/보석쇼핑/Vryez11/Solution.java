package week1.보석쇼핑.Vryez11;

import java.util.*;

public class Solution {

    /**
     *
     * [프로그래머스] 보석 쇼핑
     *
     * 문제 난이도 : Lv3
     * 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/67258
     * 풀이 시간 :
     * 풀이 근거 :
     */

    public int[] solution(String[] gems) {

        HashSet<String> set = new HashSet<>(List.of(gems));
        int gemTypeCount = set.size();

        if (gemTypeCount == 1) {
            return new int[]{1,1};
        }

        Map<String, Integer> gemsCountMap = new HashMap<>();
        int minLen = Integer.MAX_VALUE;
        int[] result = new int[2];
        int left = 0, right = 0;

        while (left < gems.length && right < gems.length) {

            if (gemsCountMap.size() < gemTypeCount) {
                gemsCountMap.put(gems[right], gemsCountMap.getOrDefault(gems[right], 0) + 1);
                right++;
                continue;
            }

            if (gemsCountMap.get(gems[left]) > 1) {
                gemsCountMap.put(gems[left], gemsCountMap.get(gems[left]) - 1);
                left++;

                continue;
            }

            if ((right - left) < minLen) {
                result[0] = left + 1;
                result[1] = right;
                minLen = (right - left);
            }

            gemsCountMap.remove(gems[left]);
            left++;
        }

        while (left < gems.length) {

            if (gemsCountMap.get(gems[left]) > 1) {
                gemsCountMap.put(gems[left], gemsCountMap.get(gems[left]) - 1);
                left++;

                continue;
            }

            if (gemsCountMap.size() == gemTypeCount && (right - left) < minLen) {
                result[0] = left + 1;
                result[1] = right;
                minLen = (right - left);
            }

            gemsCountMap.remove(gems[left]);
            left++;
        }

        if (result[0] == 0 && result[1] == 0) {
            result = new int[]{1, gems.length};
        }

        return result;
    }
}
