package week7.영어끝말잇기.Vryez11;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    /**
     *
     * [프로그래머스] 영어 끝말잇기
     *
     * 문제 난이도: Lv2
     * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12981
     * 풀이 시간: 25분
     * 풀이 근거: Set 자료구조로 O(1)의 시간복잡도로 포함 확인 & prev 맨 뒤 단어와 now 맨 앞 단어 비교
     */
    public int[] solution(int n, String[] words) {

        Set<String> set = new HashSet<>();
        String prev = words[0];
        set.add(prev);
        int[] ans = new int[]{0, 0};

        for (int i = 1; i < words.length; i++) {

            String word = words[i];

            if (set.contains(word) || isValid(prev, word)) {

                int size = set.size() + 1;

                ans[0] = size % n == 0 ? n : size % n;
                ans[1] = size % n == 0 ? size / n : size / n + 1;

                return ans;
            }

            prev = word;
            set.add(word);
        }

        return ans;
    }

    private boolean isValid(String prev, String now) {

        return prev.charAt(prev.length() - 1) != now.charAt(0);
    }
}
