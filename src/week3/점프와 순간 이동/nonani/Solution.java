/*
## ✏️ [프로그래머스] 멀리 뛰기
📶 문제 난이도
Lv. 2

🔗 문제 링크
https://school.programmers.co.kr/learn/courses/30/lessons/12980

⏱️ 풀이 시간
5분

✅ 풀이 근거
N의 크기가 10억이라 O(N)으로도 안 풀리는 문제였다.
그래서 처음에는 dp인가했는데 단순하게 그냥 홀수이면 짝수로 만들어버리고 / 2를 해버리기만 하면 될 것 같아서 시도해봤고 정답이 나왔다.
*/

import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;

        while(n != 0) {
            if(n%2==0) {
                n/=2;
            } else {
                n--;
                ans++;
            }
        }
        return ans;
    }
}