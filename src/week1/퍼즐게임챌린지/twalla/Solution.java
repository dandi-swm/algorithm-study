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