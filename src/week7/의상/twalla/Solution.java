package week7.의상.twalla;

import java.util.*;

/*
## ✏️ [프로그래머스] 의상

📶 문제 난이도
Lv. 2

🔗 문제 링크
https://school.programmers.co.kr/learn/courses/30/lessons/42578

⏱️ 풀이 시간
10분

✅ 풀이 근거
최소 하나는 입어야하니까,
모든 경우의 수 (A type의 의상 개수 + 1) * (B type의 의상 개수 + 1) * ...
에서 모두 안 입는 경우인 1을 빼주면 쉽게 해결 가능하다!

*/

public class Solution {
    public int solution(String[][] clothes) {

        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            String name = clothes[i][0];
            String type = clothes[i][1];

            if (map.containsKey(type)) {
                map.get(type).add(name);
            } else {
                List<String> list = new ArrayList<>();
                list.add(name);
                map.put(type, list);
            }
        }

        int answer = 1;
        for (String key : map.keySet()) {
            answer *= map.get(key).size() + 1;
        }

        return answer - 1;
    }
}