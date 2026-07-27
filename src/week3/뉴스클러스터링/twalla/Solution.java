package week3.뉴스클러스터링.twalla;

// ✏️ 프로그래머스 [1차] 뉴스 클러스터링

// 📶 문제 난이도
// Level 2

// 🔗 문제 링크
// https://school.programmers.co.kr/learn/courses/30/lessons/17677

// ⏱️ 풀이 시간
// 30분

// ✅ 풀이 근거
// 그냥 map에 때려박고 containsKey()로 합집합, 교집합 찾아서 해결!

import java.util.*;

public class Solution {
    public int solution(String str1, String str2) {

        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for (int i = 0; i < str1.length() - 1; i++) {

            String temp = str1.substring(i, i + 2);
            temp = temp.toLowerCase();

            if (temp.matches("^[a-zA-Z]+$")) {
                map1.put(temp, map1.getOrDefault(temp, 0) + 1);
            }
        }

        for (int i = 0; i < str2.length() - 1; i++) {

            String temp = str2.substring(i, i + 2);
            temp = temp.toLowerCase();

            if (temp.matches("^[a-zA-Z]+$")) {
                map2.put(temp, map2.getOrDefault(temp, 0) + 1);
            }
        }

        int intersection = 0, union = 0;

        for (String key: map1.keySet()) {
            if (map2.containsKey(key)) { // 포함
                intersection += Math.min(map1.get(key), map2.get(key));
                union += Math.max(map1.get(key), map2.get(key));
                continue;
            }

            union += map1.get(key);
        }

        for (String key: map2.keySet()) {
            if (map1.containsKey(key)) {
                continue;
            }

            union += map2.get(key);
        }

        if (intersection == 0 && union == 0) {
            return 65536;
        }

        int answer = (int) (((double) intersection / (double) union) * 65536);
        return answer;
    }
}
