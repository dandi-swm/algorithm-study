/*
## ✏️ [프로그래머스] 구명보트
📶 문제 난이도
Lv. 2

🔗 문제 링크
https://school.programmers.co.kr/learn/courses/30/lessons/42885

⏱️ 풀이 시간
5분
트
✅ 풀이 근거
투포인터로 쉽게 풀 수 있었다.
*/

import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int l = 0;
        int r = people.length - 1;

        while (l <= r) {
            if (l == r) {
                answer++;
                break;
            }
            // System.out.println(l+" "+r + " " + (people[l] + people[r]));
            if (people[l] + people[r] <= limit) {
                answer++;
                l++;
                r--;
            } else {
                answer++;
                r--;
            }

        }
        return answer;
    }
}
