import kotlin.math.*

/*
## ✏️ [프로그래머스] 정수 삼각형
📶 문제 난이도
Lv. 3

🔗 문제 링크
https://school.programmers.co.kr/learn/courses/30/lessons/43105

⏱️ 풀이 시간
20분

✅ 풀이 근거
대놓고 dp였어서 쉽게 해결할 수 있었던 것 같다.

 */

import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (j == 0)
                    triangle[i][j] += triangle[i - 1][j];
                else if (j == triangle[i].length - 1) {
                    triangle[i][j] += triangle[i - 1][j - 1];
                } else {
                    triangle[i][j] += Math.max(triangle[i - 1][j], triangle[i - 1][j - 1]);
                }
            }
        }


        for (int i = 0; i < triangle[triangle.length - 1].length; i++) {
            answer = Math.max(answer, triangle[triangle.length - 1][i]);
        }

        return answer;

    }
}