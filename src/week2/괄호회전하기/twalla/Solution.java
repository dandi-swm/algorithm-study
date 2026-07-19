// ✏️ 프로그래머스 괄호 회전하기

// 📶 문제 난이도
// Level 2

// 🔗 문제 링크
// https://school.programmers.co.kr/learn/courses/30/lessons/76502

// ⏱️ 풀이 시간
// 10분

// ✅ 풀이 근거
// 문자열 회전 + stack으로 해결

import java.util.*;

class Solution {
    
    int N;
    
    boolean check(String s) {
                
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < N; i++) {
            
            char cur = s.charAt(i);
            
            if (stack.isEmpty() || cur == '[' || cur == '{' || cur == '(') {
                stack.push(cur);
                continue;
            } 
            
            if (cur == ']') {
                if (stack.peek() == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (cur == '}') {
                if (stack.peek() == '{') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (cur == ')') {
                if (stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        
        if (!stack.isEmpty()) {
            return false;
        }
        
        return true;
    }
    
    public int solution(String s) {
        
        N = s.length();
        
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            String moved = s.substring(i, N) + s.substring(0, i);
            
            if (check(moved)) {
                cnt += 1;
            }
        }
        
        return cnt;
    }
}