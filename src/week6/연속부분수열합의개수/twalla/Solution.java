package week6.연속부분수열합의개수.twalla;

/*
## ✏️ [프로그래머스] 연속 부분 수열 합의 개수

📶 문제 난이도
Lv. 2

🔗 문제 링크
https://school.programmers.co.kr/learn/courses/30/lessons/131701

⏱️ 풀이 시간
10분

✅ 풀이 근거
인덱스 잘 써가면서 배열 순회해서 합을 set에 저장

*/

import java.util.*;

public class Solution {
    public int solution(int[] elements) {

        int N = elements.length;
        Set<Integer> set = new HashSet<>();

        for (int i = 1; i <= N; i++) { // 길이
            for (int j = 0; j < N; j++) { // 시작
                int sum = 0;
                for (int k = 0; k < i; k++) { // 반복
                    sum += elements[(j + k) % N];
                }
                set.add(sum);
            }
        }

        int answer = set.size();
        return answer;
    }
}