/*
## ✏️ [프로그래머스] n^2 배열 자르기

📶 문제 난이도
Lv. 2

🔗 문제 링크
https://school.programmers.co.kr/learn/courses/30/lessons/87390

⏱️ 풀이 시간
20분

✅ 풀이 근거
long을 int로 바꾸는 방법을 몰라서 헤맸다..
*/

class Solution {
    public int[] solution(int n, long left, long right) {

        int len = Math.toIntExact(right -  left + 1);
        int[] answer = new int[len];

        int cnt=0;
        for(long i=left; i<=right; i++) {

            int y = Math.toIntExact(i / n);
            int x = Math.toIntExact(i % n);

            answer[cnt++] = Math.max(y+1, x+1);

        }

/*
1 2 3
2 2 3
3 3 3
*/
        return answer;
    }
}