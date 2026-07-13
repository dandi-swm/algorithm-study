// ✏️ 프로그래머스 퍼즐 게임 챌린지

// 📶 문제 난이도
// Level 2

// 🔗 문제 링크
// https://school.programmers.co.kr/learn/courses/30/lessons/340212#

// ⏱️ 풀이 시간
// 40분

// ✅ 풀이 근거
// 처음에 완전 탐색을 떠올려봤는데, 시간 초과가 날 것 같아서 이분 탐색으로 접근함.
// 다만 첫 문제를 틀렸으면 어떻게 처리해야할 지에 대해 계속 고민했는데, 
// 알고보니 입력으로는 항상 첫 문제의 diff가 1이라서 그냥 넘어가도 됐음.
// (프로그래머스는 Level 2에서도 이분 탐색이 나오는 군요..!)

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        
        int N = diffs.length;
        
        int l = 1, h = 100_000, m = 0;
        int answer = h;
        while (l < h) {
            m = (l + h) / 2;
                        
            long total = 0;
            for (int i = 0; i < N; i++) {
                int diff = diffs[i];
                int time = times[i];
                
                total += time;
                
                if (diff <= m) { // 맞힘
                    continue;
                }
                
                total += (time + times[i - 1]) * (diff - m);
            }
            
            if (total == limit) {
                return m;
            }
            
            if (total < limit) {
                answer = Math.min(answer, m);
                h = m;
            } else {
                l = m + 1;
            }
        }
        
        return answer;
    }
}