/*
## ✏️ [프로그래머스] 여행경로
📶 문제 난이도
Lv. 3

🔗 문제 링크
https://school.programmers.co.kr/learn/courses/30/lessons/43164
⏱️ 풀이 시간
40분

✅ 풀이 근거
못 풀었습니다!!!
어렵네요!!!!!!!
AI 코드 진짜 잘짠다!!!!!!!
문제를 잘못이해한게 좀 컸던 것 같다. 모든 점 방문이 아니라 티켓을 다 소진하는 경우였는데 잘못 접근
*/
import java.util.*;

class Solution {
    String[] answer;
    boolean[] used;
    boolean found = false;

    public String[] solution(String[][] tickets) {
        answer = new String[tickets.length + 1];
        used = new boolean[tickets.length];

        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });

        answer[0] = "ICN";
        dfs("ICN", 1, tickets);

        return answer;
    }

    private void dfs(String current, int depth, String[][] tickets) {
        if (found) return;

        // 모든 티켓을 사용했으므로 경로 완성
        if (depth == tickets.length + 1) {
            found = true;
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!used[i] && tickets[i][0].equals(current)) {
                used[i] = true;
                answer[depth] = tickets[i][1];

                dfs(tickets[i][1], depth + 1, tickets);

                if (found) return;

                used[i] = false;
            }
        }
    }
}