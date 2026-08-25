package week7.영어끝말잇기.twalla;

import java.util.*;

/*
## ✏️ [프로그래머스] 영어 끝말잇기

📶 문제 난이도
Lv. 2

🔗 문제 링크
https://school.programmers.co.kr/learn/courses/30/lessons/12981

⏱️ 풀이 시간
10분

✅ 풀이 근거
간단한 구현 문제

*/

public class Solution {
    public int[] solution(int n, String[] words) {

        int[] answer = new int[2];

        Set<String> set = new HashSet<>();

        String prev = words[0];
        set.add(prev);

        for (int i = 1; i < words.length; i++) {
            String cur = words[i];

            if (prev.charAt(prev.length() - 1) == cur.charAt(0) && !set.contains(cur)) {
                set.add(cur);
                prev = cur;
                continue;
            }

            int loser = (i + 1) % n;
            int turn = (i + 1) / n + 1;
            if (loser == 0) {
                loser = n;
                turn -= 1;
            }
            answer[0] = loser;
            answer[1] = turn;
            return answer;

        }


        return answer;
    }
}
