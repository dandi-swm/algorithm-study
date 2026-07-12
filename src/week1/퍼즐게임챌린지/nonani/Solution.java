/*
## ✏️ [프로그래머스] [PCCP 기출문제] 2번 / 퍼즐 게임 챌린지
📶 문제 난이도
Lv. 2

🔗 문제 링크
https://school.programmers.co.kr/learn/courses/30/lessons/340212

⏱️ 풀이 시간
20분

✅ 풀이 근거
숙련도가 높아질수록 총 풀이 시간이 단조 감소하므로, 제한 시간 안에 풀 수 있는 최소 숙련도를 이분 탐색으로 찾는다.
*/

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int N = diffs.length;
        
        int l = 1;
        int r = 100000;
        while(l <= r) {
            int mid = (l + r) / 2; // 현재 탐색하는 레벨
            
            long time = 0;
            for(int i=0;i<N;i++) {
                if(diffs[i] <= mid)
                    time += times[i];
                else
                    time += (diffs[i] - mid) * (times[i] + times[i-1]) + times[i];
                
                if(time > limit)
                    break;
            }
            if(time <= limit) {
                r = mid - 1;
                answer = mid;
            }else {
                l = mid + 1;
            }
            
        }
        return answer;
    }
}
