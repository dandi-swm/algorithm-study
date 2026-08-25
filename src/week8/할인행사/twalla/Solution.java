package week8.할인행사.twalla;

import java.util.*;

/*
## ✏️ [프로그래머스] 할인 행사

📶 문제 난이도
Lv. 2

🔗 문제 링크
https://school.programmers.co.kr/learn/courses/30/lessons/131127

⏱️ 풀이 시간
30분

✅ 풀이 근거
장볼 목록을 wishList에 넣어두고 sliding window처럼 인덱스를 하나씩 옮겨가며 wishList와 현재 장바구니를 체크

*/

public class Solution {
    public int solution(String[] want, int[] number, String[] discount) {

        int N = want.length;
        int M = discount.length;

        Map<String, Integer> wishList = new HashMap<>();

        for (int i = 0; i < N; i++) {
            wishList.put(want[i], number[i]);
        }

        Map<String, Integer> cur = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            cur.put(discount[i], cur.getOrDefault(discount[i], 0) + 1);
        }

        int answer = 0;
        int index = 10;

        while (true) {

            boolean register = true;

            for (int i = 0; i < N; i++) {
                String item = want[i];
                if (!cur.containsKey(item) || wishList.get(item) != cur.get(item)) {
                    register = false;
                    break;
                }
            }

            if (register) {
                answer += 1;
            }

            if (index == M) {
                break;
            }

            String newItem = discount[index];
            cur.put(newItem, cur.getOrDefault(newItem, 0) + 1);

            String oldItem = discount[index - 10];
            cur.put(oldItem, cur.get(oldItem) - 1);

            index += 1;
        }

        return answer;
    }
}
