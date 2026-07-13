// ✏️ 프로그래머스 귤 고르기

// 📶 문제 난이도
// Level 2

// 🔗 문제 링크
// https://school.programmers.co.kr/learn/courses/30/lessons/138476

// ⏱️ 풀이 시간
// 30분

// ✅ 풀이 근거
// 귤 크기에 따른 갯수를 map에 저장한 뒤, value 기준으로 정렬해서 해결

import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        
        int T = tangerine.length;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < T; i++) {
            int tang = tangerine[i];
            map.put(tang, map.getOrDefault(tang, 0) + 1);
        }
        
        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> {
            return map.get(o2).compareTo(map.get(o1));
        });
        
        int answer = 0;
        
        for (int key : keySet) {
            if (k <= 0) {
                break;
            }
            k -= map.get(key);
            map.put(key, 0);
            answer += 1;
        }
        
        return answer;
    }
}