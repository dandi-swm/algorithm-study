// ✏️ 프로그래머스 멀리 뛰기

// 📶 문제 난이도
// Level 2

// 🔗 문제 링크
// https://school.programmers.co.kr/learn/courses/30/lessons/12914

// ⏱️ 풀이 시간
// 10분

// ✅ 풀이 근거
// 피보나치로 간단하게 해결

import java.util.*;

class Solution {
    
    long[] cache;
    int mod = 1_234_567;
    
    long fibo(int n) {
        
        if (cache[n] != -1) {
            return cache[n];
        }
        
        if (n == 1) {
            return cache[1] = 1;
        } else if (n == 2) {
            return cache[2] = 2;
        }
        
        return cache[n] = (fibo(n - 2) + fibo(n - 1)) % mod;
    }
    
    public long solution(int n) {
        
        cache = new long[n + 1];
        Arrays.fill(cache, -1);
        
        long answer = fibo(n);
        return answer;
    }
}