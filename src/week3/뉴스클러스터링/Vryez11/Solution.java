package week3.뉴스클러스터링.Vryez11;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    /**
     *
     * [프로그래머스] 뉴스 클러스터링
     *
     * 문제 난이도: Lv. 2
     * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/17677
     * 풀이 시간: 30분
     * 풀이 근거: Map을 통해 2자 씩 put / 이를 통해 합집합, 교집합 구하기
     */

    public int solution(String str1, String str2) {

        Map<String, Integer> str1Map = new HashMap<>();
        Map<String, Integer> str2Map = new HashMap<>();

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        for (int i = 0; i < str1.length() - 1; i++) {

            char char1 = str1.charAt(i);
            char char2 = str1.charAt(i + 1);

            if (!isAlphabetChar(char1, char2)) {
                continue;
            }

            String word = (char1 + "" + char2);

            str1Map.put(word, str1Map.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i < str2.length() - 1; i++) {

            char char1 = str2.charAt(i);
            char char2 = str2.charAt(i + 1);

            if (!isAlphabetChar(char1, char2)) {
                continue;
            }

            String word = (char1 + "" + char2);

            str2Map.put(word, str2Map.getOrDefault(word, 0) + 1);
        }

        int union = 0;
        int intersection = 0;

        for (String key : str1Map.keySet()) {

            intersection += str1Map.get(key);

            if (str2Map.containsKey(key)) {
                union += Math.min(str1Map.get(key), str2Map.get(key));
            }
        }

        for (String key : str2Map.keySet()) {

            intersection += str2Map.get(key);
        }

        System.out.println("union = " + union);
        System.out.println("intersection = " + intersection);

        intersection -= union;

        if (union == 0 && intersection == 0) {
            return 65_536;
        }

        return (int) (((double) union / intersection) * 65_536);
    }

    private boolean isAlphabetChar(char char1, char char2) {
        return char1 <= 'z' && char1 >= 'a' && 'a' <= char2 && char2 <= 'z';
    }
}
