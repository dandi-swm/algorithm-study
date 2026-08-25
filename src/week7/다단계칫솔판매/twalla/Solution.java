package week7.다단계칫솔판매.twalla;

import java.util.*;

/*
## ✏️ [프로그래머스] 다단계 칫솔 판매

📶 문제 난이도
Lv. 3

🔗 문제 링크
https://school.programmers.co.kr/learn/courses/30/lessons/77486

⏱️ 풀이 시간
40분

✅ 풀이 근거
처음엔 트리 구조를 만들고 데이터를 집어넣을까 하다가, enroll과 referral 배열 두개를 반복문으로 타고타고 가도 충분히 해결가능할 것 같아서 while문으로 해결

*/

public class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] sellers, int[] amounts) {

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < enroll.length; i++) {
            String name = enroll[i];
            map.put(name, i);
        }

        int[] answer = new int[enroll.length];

        for (int i = 0; i < sellers.length; i++) {

            String cur = sellers[i];
            int money = amounts[i] * 100;

            while (!cur.equals("-") && money > 0) {
                int index = map.get(cur);
                int up = money / 10;

                answer[index] += money - up;

                cur = referral[index];
                money = up;
            }

        }

        return answer;
    }
}