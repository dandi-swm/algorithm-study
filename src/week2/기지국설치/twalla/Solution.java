// ✏️ 프로그래머스 괄호 회전하기

// 📶 문제 난이도
// Level 3

// 🔗 문제 링크
// https://school.programmers.co.kr/learn/courses/30/lessons/12979

// ⏱️ 풀이 시간
// 30분

// ✅ 풀이 근거
// 아파트 개수가 최대 20억이기에 O(N)으로는 불가능
// 

class Solution {
    public int solution(int n, int[] stations, int w) {
        
        int start = 1, current = 1, total = 0, coverage = 2 * w + 1;
        for (int i = 0; i < stations.length; i++) {
            
            int station = stations[i];
            start = station - w;
            
            if (start > current) {
                int gap = start - current;
                total += (gap - 1) / coverage + 1;
            }
            
            current = Math.max(current, station + w + 1);
        }
        
        if (current < n + 1) {
            int gap = n + 1 - current;
            total += (gap - 1) / coverage + 1;
        }

        return total;
    }
}