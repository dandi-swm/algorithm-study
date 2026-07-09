import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        
        int N = gems.length;
        
        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(gems[i]);
        }
        
        int total = set.size();
        
        Map<String, Integer> map = new HashMap<>();
        
        int rs = 0, re = 0, min = 100_000;
        
        int start = 0;
        for (int end = 0; end < N; end++) {
                        
            String cgem = gems[end];
            map.put(cgem, map.getOrDefault(cgem, 0) + 1);
            
            if (map.size() < total) {
                continue;
            }
            
            while (true) {
                String sgem = gems[start];
                
                if (map.size() < total) {
                    break;
                }
                
                if (map.get(sgem) > 1) {
                    map.put(sgem, map.get(sgem) - 1);
                    start += 1;
                } else {
                    map.remove(sgem);
                    if (min > end - start) {
                        min = end - start;
                        rs = start;
                        re = end;
                    }
                    start += 1;
                    break;
                }
            }
        }
        
        int[] answer = new int[]{rs + 1, re + 1};
        return answer;
    }
}