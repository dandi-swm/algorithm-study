import java.util.*;

// ✏️ 프로그래머스 [1차] 캐시

// 📶 문제 난이도
// Level 2

// 🔗 문제 링크
// https://school.programmers.co.kr/learn/courses/30/lessons/17680#

// ⏱️ 풀이 시간
// 30분

// ✅ 풀이 근거
// 처음에는 queue를 생각했으나, 중간의 요소를 빼야 해서 
// arrayList를 생각했으나, 중간의 요소를 빼는 데에 시간 복잡도가 O(N)이라서
// LinkedList를 사용하여 해결

// miss가 나는 두 가지 경우의 수를 생각하지 못해서 오래 고민.

class Solution {
    public int solution(int cacheSize, String[] cities) {
        
        List<String> cache = new LinkedList<>();
        int time = 0;
        
        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase();
                        
            if (cache.contains(city)) { // hit
                int idx = cache.indexOf(city);
                cache.addLast(city);
                cache.remove(idx);
                time += 1;
                continue;
            }
            
            if (cache.size() < cacheSize) { // miss
                cache.addLast(city);
                time += 5;
                continue;
            }
            
            cache.addLast(city); // miss
            cache.removeFirst();
            time += 5;
        }
        
        return time;
    }
}