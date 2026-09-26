package week10.인사고과.twalla;

import java.util.*;

/*
## ✏️ [프로그래머스] 인사고과

📶 문제 난이도
Lv. 3

🔗 문제 링크
https://school.programmers.co.kr/learn/courses/30/lessons/152995

⏱️ 풀이 시간
1시간

✅ 풀이 근거

(1) 탈락자를 걸러내고  (2) 남은 사람들 사이에서 완호의 등수를 구한다.

1. 최대 동료평가 테이블 구성
   maxMap[근무태도] = 해당 근무태도를 가진 사람들의 동료평가 최댓값
   단, 합이 완호보다 작은 사람은 넣지 않는다.

2. maxMap의 Key(근무태도)를 내림차순 정렬

3. 전체 인원을 다시 순회하며 탈락 판정
   자신보다 근무태도가 높은 구간만 확인해
   그중 동료평가 최댓값이 자신보다 크면 탈락.
     - 탈락  → 제외 (완호라면 -1 반환)
     - 미탈락 → sumMap[합]++ 로 집계

4. sumMap의 Key(합)를 내림차순 정렬

5. 완호의 합이 나올 때까지 인원수를 누적해 등수를 확정
*/

public class Solution {
    public int solution(int[][] scores) {

        int N = scores.length;

        int won1 = scores[0][0];
        int won2 = scores[0][1];
        int wonsum = won1 + won2;

        Map<Integer, Integer> maxMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int s1 = scores[i][0];
            int s2 = scores[i][1];

            if (s1 + s2 < wonsum) {
                continue;
            }

            if ((maxMap.containsKey(s1) && s2 > maxMap.get(s1)) || (!maxMap.containsKey(s1))) {
                maxMap.put(s1, s2);
            }
        }

        List<Integer> sortedMax = new ArrayList<>(maxMap.keySet());
        Collections.sort(sortedMax, Collections.reverseOrder());

        Map<Integer, Integer> sumMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int s1 = scores[i][0];
            int s2 = scores[i][1];

            boolean fail = false;
            for (int k : sortedMax) {
                int v = maxMap.get(k);

                if (s1 >= k) {
                    break;
                }

                if (k > s1 && v > s2) {
                    if (i == 0) {
                        return -1;
                    }
                    fail = true;
                    break;
                }
            }

            if (!fail) {
                int sum = s1 + s2;
                sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
            }
        }

        int rank = 1;
        List<Integer> sortedSum = new ArrayList<>(sumMap.keySet());
        Collections.sort(sortedSum, Collections.reverseOrder());

        for (int sum : sortedSum) {
            if (sum == won1 + won2) {
                return rank;
            } else {
                rank += sumMap.get(sum);
            }
        }

        return rank;
    }
}
