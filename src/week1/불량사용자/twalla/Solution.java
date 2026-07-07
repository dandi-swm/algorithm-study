// ✏️ 프로그래머스 불량 사용자

// 📶 문제 난이도
// Level 3

// 🔗 문제 링크
// https://school.programmers.co.kr/learn/courses/30/lessons/64064#

// ⏱️ 풀이 시간
// 1시간

// ✅ 풀이 근거
// 불량 사용자 목록과 일치하는 사용자들을 찾기 위해 DFS를 사용하여 모든 가능한 조합 탐색
// 각 조합을 비트마스크로 표현하여 Set으로 중복 제거

import java.util.*;

class Solution {
    
    static int U, B;
    static String[] users, bans;
    static Set<Integer> set;
    
    void dfs(int index, int binary) {
        
        if (index == B) {
            set.add(binary);
            return;
        }
        
        String target = bans[index];
        
        for (int i = 0; i < U; i++) {
            String user = users[i];
            
            if (target.length() == user.length() 
                    && check(target, user) 
                    && (binary & (1 << i)) == 0) {
                int nbinary = binary | (1 << i);
                dfs(index + 1, nbinary);
            }
        }
        
    }
    
    boolean check(String target, String user) {
        
        int L = target.length();
        
        for (int i = 0; i < L; i++) {
            if (target.charAt(i) == '*') {
                continue;
            }
            if (target.charAt(i) != user.charAt(i)) {
                return false;
            }
        }
        
        return true;
    }
    
    public int solution(String[] user_id, String[] banned_id) {
        
        U = user_id.length;
        B = banned_id.length;
        
        users = user_id;
        bans = banned_id;
        
        set = new HashSet<>();
        
        dfs(0, 0);
                
        int answer = set.size();
        return answer;
    }
}